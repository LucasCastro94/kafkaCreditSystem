import { Component, OnInit } from '@angular/core';
import { Purchase } from '../model/Purchase'
import { PurchaseService } from '../credit-purchase/purchase-service.service'

@Component({
  selector: 'app-credit-purchase',
  templateUrl: './credit-purchase.component.html',
  styleUrls: ['./credit-purchase.component.css']
})
export class CreditPurchaseComponent implements OnInit {

  id:number = 1

  purchase: Purchase = new Purchase
  isOpen:boolean=false //se o dialog esta aberto
  progress:string = "" //status
  selectedOption : boolean
  isFormValid = false;

  constructor(private service: PurchaseService) { }

  ngOnInit(): void {
   this.purchase.purchaseID = this.id
    

  }

  save()
  {
    this.isOpen = true
    this.progress = "Efetuando pagamento"
    this.purchase.purchaseID = this.id

    alert(''+this.id)

    this.service.postPurchase(this.purchase).subscribe(
      (data: Purchase) => {
        alert('salvo com id:'+this.purchase.purchaseID)
        this.id++
      },
      (error) => {
       
        setTimeout(() => {
          this.progress = "Erro ao se conectar com o servidor";
        }, 1000);
  
        setTimeout(() => {
          this.isOpen = false;
        }, 4000);
      },
      () => {
        this.isOpen = false;
      }
    );
  }
  



verificarIdEspecifico() {
  this.service.successfullpayment(this.id).subscribe((data: Purchase) =>{

    if(data){
     this.progress = "Pagamento feito com sucesso, cartão: "+this.purchase.creditCard
     this.id++

    }
    else
    {
      console.log("falhou em verificar");

    }

  })
}

checkFormValidity() {
  this.isFormValid = (
    this.purchase.creditCard &&
    this.purchase.namePrinted &&
    this.purchase.validityCard &&
    this.purchase.codSec &&
    this.purchase.valueOfPayment &&
    this.purchase.installments &&
    this.selectedOption !== undefined
  );
}


}
