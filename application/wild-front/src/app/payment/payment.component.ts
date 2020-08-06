import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Session } from '../shared/model/session';
import { PaymentService } from '../services/payment.service';
import { Order } from '../shared/model/order';  
import { SessionService } from '../services/session.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  public saved: boolean;
  public createdOrder: any;
  public errorMessage: any;
  public paymentSuccess : boolean;
  public paymentError : boolean;
  public orderAmount : number;
  public sessions : Session[] = [];
  prix;

  constructor(private http: HttpClient, private paymentService : PaymentService,  private sessionService : SessionService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit() {
    this.orderAmount = +this.route.snapshot.paramMap.get('price');
  }

  chargeCreditCard() {
  this.prix = +this.route.snapshot.paramMap.get('price');
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
    this.paymentService.chargeCard(token, montant).subscribe(resp => {
      console.log(resp)
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
    this.createOrder();
  }

  getCommandeById(id : number) {
    return this.paymentService.getOrderById(id).subscribe(res => { 
      console.log("getCommandeById", res)
    });
  }

  getUpdateCommande(id) {
    return this.paymentService.updateOrder(id).subscribe(res => { 
     console.log(res);
  });
}

createOrder(){
  let sessionIdsStored = JSON.parse(sessionStorage.getItem("sessionsIdsStored")); 
  sessionIdsStored.shift();
  let userId = JSON.parse(sessionStorage.getItem("userId"));
  let order = new Order();
  order.userId = userId;
  order.date = new Date();
  order.isPaid = false;
  sessionIdsStored.forEach(id => {
    this.sessionService.getSessionById(id).subscribe((res) => {
      this.sessions.push(res)
    })
  });
  order.sessions = this.sessions;
  order.isPaid = true;
  order.amount = this.orderAmount;
  this.paymentService.saveOrder(order).subscribe((res) => {
  this.createdOrder = res;
  if(this.createdOrder.id != null){
    this.paymentSuccess = true;
    setTimeout(
      () => {
        this.paymentSuccess = false;
        this.router.navigate([""]);
    }, 5000);
  }else{
    this.paymentError = true;
    setTimeout(
      () => {
        this.paymentError = false;
    }, 5000);
  }
  })
}

}
