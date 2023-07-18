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
  isOpen: boolean = false //se o dialog esta aberto
  progress: string = "" //status
  selectedOption: boolean
  isFormValid = false;

  constructor(private service: PurchaseService) { }

  ngOnInit(): void {
    this.purchase.purchaseID = this.id


  }

  async save() {
    this.isOpen = true
    this.progress = "Efetuando pagamento"
    this.purchase.purchaseID = this.id



    this.service.postPurchase(this.purchase).subscribe(
      (data: Purchase) => {
        alert('salvo com id:' + this.purchase.purchaseID)
        this.progress = "deu certo berg"
        this.id++
        setTimeout(() => {
          this.isOpen = false;
        }, 2000);

      },
      (error) => {
        this.progress = "Olha merda"
        setTimeout(() => {
          this.progress = "Erro ao se conectar com o servidor";
        }, 1000);
        {
          setTimeout(() => {
            this.isOpen = false;
          }, 4000);
        }
      
      })}
  




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
