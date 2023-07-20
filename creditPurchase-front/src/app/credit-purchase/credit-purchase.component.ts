import { Component, OnInit } from '@angular/core';
import { Purchase } from '../model/Purchase'
import { PurchaseService } from '../credit-purchase/purchase-service.service'

@Component({
  selector: 'app-credit-purchase',
  templateUrl: './credit-purchase.component.html',
  styleUrls: ['./credit-purchase.component.css']
})
export class CreditPurchaseComponent implements OnInit {

  id: number = 1

  purchase: Purchase = new Purchase
  isOpen: boolean = false
  progress: string = ""
  isFormValid = false;

  constructor(private service: PurchaseService) { }

  ngOnInit(): void {
    this.purchase.purchaseID = this.id


  }

   save() {
    this.isOpen = true
    this.progress = "Efetuando pagamento"
    this.purchase.purchaseID = this.id

    this.service.postPurchase(this.purchase).subscribe(
       () => {
        setTimeout(async() => {
          await this.successfull(this.id)
        },2000)

       
      },
      (error) => {
        setTimeout(() => {
          this.progress = "Erro ao se conectar com o servidor";
        }, 1000);
        {
          setTimeout(() => {
            this.isOpen = false;
          }, 4000);
        }

      })
  }


  successfull(purchaseID : number) {
    return new Promise<void>((resolve) => {

      this.service.successfullpayment(9999).subscribe({
        next: obj => {
          alert('Compra aprovada!\n cartão de credito: ' + obj.creditCardNumber)
          this.id++
          
          this.progress = "Aprovada"
          setTimeout(() => {
            this.isOpen = false;
            this.purchase = new Purchase
          }, 2000)
          resolve()

        },
        error: err =>{
          this.progress = "Pagamento negado"
          setTimeout(() => {
            this.isOpen = false;
            this.purchase = new Purchase
          }, 2000)
          resolve()
        }
     
      })
    });
  }


  checkFormValidity() {
    this.isFormValid = !!(
      this.purchase.creditCard &&
      this.purchase.namePrinted &&
      this.purchase.validityCard &&
      this.purchase.codSec &&
      this.purchase.valueOfPayment &&
      this.purchase.installments
    );
  }



}
