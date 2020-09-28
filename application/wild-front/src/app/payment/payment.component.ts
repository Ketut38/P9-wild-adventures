import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { OrderSession } from '../shared/model/order-session';
import { PaymentService } from '../services/payment.service';
import { Order } from '../shared/model/order';  
import { SessionService } from '../services/session.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from '../shared/model/user';
import { KeycloakService } from 'keycloak-angular';

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
  public orderSession : OrderSession;
  public orderSessions : OrderSession[] = [];
  public prix;
  public user : User;
  public paymantDone: boolean=false;
  public order = {
    id : null,
    userId: null,
    orderSessions: null,
    date: null,
    isPaid: false,
    amount : null
  };

  constructor(private http: HttpClient, private paymentService : PaymentService,  private sessionService : SessionService,  protected readonly keycloak: KeycloakService,
    private userService: UserService,  private router: Router, private route: ActivatedRoute) {
    }

  ngOnInit() {
    this.orderAmount = +this.route.snapshot.paramMap.get('price');
    //this.createOrder();
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
  sessionStorage.removeItem("sessionsIdsStored");
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
  this.prix = +this.route.snapshot.paramMap.get('price');
  let sessionIdsStored = JSON.parse(sessionStorage.getItem("sessionsIdsStoredForOrders")); 
  this.user = JSON.parse(sessionStorage.getItem("userInfos"));
  this.userService.getUserInfos().subscribe(res => {
    this.user = res;
    if(this.user != undefined){
      sessionStorage.setItem('user-connected', JSON.stringify(this.user));
      this.order.userId = this.user.id;
      this.order.date = new Date();
      this.order.isPaid = false;
      this.orderSession = new OrderSession();
      sessionIdsStored.forEach(id => {
        this.orderSession.sessionId = id;
        this.orderSession.orderId = null;
        this.orderSessions.push(this.orderSession)
      });
      this.order.orderSessions = this.orderSessions;
      this.order.isPaid = true;
      this.order.amount = this.orderAmount;
      this.paymentService.saveOrder(this.order).subscribe((res) => {
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
      });
    }
  });
}

}