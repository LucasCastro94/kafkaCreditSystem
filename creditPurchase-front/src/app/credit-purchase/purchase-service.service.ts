import { Injectable } from '@angular/core';
import{ HttpClient } from '@angular/common/http'
import { Purchase } from '../model/Purchase';
import { Payment } from '../model/Payment';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  private postUrl : string = 'http://localhost:8080/v1'

  private getUrl : String = 'http://localhost:8083/v1'


  constructor(private http:HttpClient) { }

  getPurchases() : Observable<Payment[]>
  {
    return this.http.get<Payment[]>(this.getUrl+'/payments')
  }

  postPurchase(purchase: Purchase) : Observable<Purchase>
  {
    return this.http.post<Purchase>(this.postUrl+'/purchase',purchase)
  }

  successfullpayment(paymentId : number) : Observable<Payment>
  {
    return this.http.get<Payment>(`${this.getUrl}/payments/${paymentId}`)
  }

}
