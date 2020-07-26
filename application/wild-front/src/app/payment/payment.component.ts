import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { first } from 'rxjs/operators';
import { PaymentService } from '../services/payment.service';
import { Order } from '../shared/model/order';  
import { SessionService } from '../services/session.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  public saved: boolean;
  public errorMessage: any;
  prix;

  constructor(private http: HttpClient, private paymentService : PaymentService,  private sessionService : SessionService) {}

  ngOnInit() {
    let orderToAdd = this.createOrder();
    console.log("orderToAdd : ", orderToAdd)
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

    chargeCreditCard() {
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
        this.chargeCard(token, this.prix);
        this.saved = true;
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
  }
  
  chargeCard(token: string, montant: string) {
    return this.paymentService.chargeCard(token, montant).pipe(first()).subscribe(resp => {
      console.log("payementtttt ", resp);
    }, (error) => {
      switch (true) {
        case error.status === 400 || error.status === 401: {
          this.errorMessage = 'Information incorrecte';
          break;
        }
        case error.status === 504: {
          this.errorMessage = 'Veuillez réessayer plutart!';
          break;
        }
        default: {
          this.errorMessage = 'Erreur de connexion';
          break;
        }
      } 
    });
  }

  getCommandeById(id : number) {
    return this.paymentService.getCommandeById(id).subscribe(res => { 
      console.log("getCommandeById", res)
    });
  }

  getUpdateCommande(id) {
    return this.paymentService.updateCommande(id).subscribe(res => { 
     console.log(res);
  });
}

createOrder(){
  let sessions = [];
  let sessionIdsStored = JSON.parse(sessionStorage.getItem("sessionsIdsStored")); 
  sessionIdsStored.shift();
  let userId = JSON.parse(sessionStorage.getItem("userId"));
  let order = new Order();
  order.userId = userId;
  order.date = new Date();
  order.isPaid = false;
  sessionIdsStored.forEach(id => {
    this.sessionService.getSessionById(id).subscribe((res) => {
      sessions.push(res)
    })
  });
  order.sessions = sessions;
  return order;
}

}
