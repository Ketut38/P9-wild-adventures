import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { first } from 'rxjs/operators';
import { PaymentService } from '../services/payment.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  public saved: boolean;
  public errorMessage: any;
  prix;

  constructor(private http: HttpClient, private paymentService : PaymentService) {}

  ngOnInit() {
  }

  /* chargeCreditCard() {
    let form = document.getElementsByTagName("form")[0];
    (<any>window).Stripe.card.createToken({
      number: form.cardNumber.value,
      exp_month: form.expMonth.value,
      exp_year: form.expYear.value,
      cvc: form.cvc.value
    }, (status: number, response: any) => {
      if (status === 200) {
        let token = response.id;
        this.chargeCard(token);
      } else {
        console.log("response.error", response.error.message);
      }
    });
  }

  chargeCard(token: string) {
    const headers = new Headers({'token': token, 'amount': 100});
    this.http.post('http://localhost:9006/charge', {}, {headers: headers})
      .subscribe(resp => {
        console.log(resp);
      })
  } */

   /* chargeCreditCard() {
    let form = document.getElementsByTagName("form")[0];
    (<any>window).Stripe.card.createToken({
      number: form.cardNumber.value,
      exp_month: form.expMonth.value,
      exp_year: form.expYear.value,
      cvc: form.cvc.value
    }, (status: number, response: any) => {
      if(form.cardNumber.value != '' && form.expMonth.value != '' && form.expYear.value != '' && form.cvc.value != ''){
      if (status === 200) {
        let token = response.id;
        this.paymentService.chargeCard(token, this.prix);
       // this.chargeCard(token, this.prix);
        //this.getUpdateCommande(this.idCommand, this.commandeUpdated);
        this.saved = true;
       // this.router.navigate([this.return]);
       console.log("saved", this.saved);
        form.cardNumber.value = '';
        form.expMonth.value = '';
        form.expYear.value = '';
      } 
      else {
       // this.errorMessage = response.error.message;
        console.log("messageeeeeee error", this.errorMessage);
      }
    }else {
      this.errorMessage ="Veuillez renseigner les champs"
    }
    });
  }  */

}
