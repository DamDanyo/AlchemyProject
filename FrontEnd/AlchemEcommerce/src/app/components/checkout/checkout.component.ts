import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CookieService } from 'ngx-cookie';
import { newOrder, Order } from 'src/app/models/order';
import { Potions } from 'src/app/models/potions';
import { User } from 'src/app/models/user';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css'],
})
export class CheckoutComponent implements OnInit {
  initializeCart() {
    let localCart = localStorage.getItem('cart');
    if (localCart != null) {
      let cart = JSON.parse(localCart);
      console.log(cart);
      this.cart = cart;
    }
    for (let i = 0; i < this.cart.length; i++) {
      let potion = this.cart[i].potion;
      let q = this.cart[i].potionQuantity;
      let q2 = this.cart[i].potion.potionvalue;
      let q3: number = q * q2;
      console.log(q);
      this.Total += q3;
    }
  }

  deleteOrderItem(index: number): void {
    let localCart = localStorage.getItem('cart');
    if (localCart != null) {
      let cartArray = JSON.parse(localCart);
      console.log(index);
      let q: number = cartArray[index].potionQuantity;
      let q2: number = cartArray[index].potion.potionvalue;
      let q3: number = q * q2;
      console.log(q);
      console.log(q2);
      this.Total = this.Total - q3;
      console.log(this.Total);
      cartArray.splice(index, 1);
      localStorage.setItem('cart', JSON.stringify(cartArray));
      this.cart = cartArray;
      if (this.cart.length == 0) {
        this.Total = 0;
      }
    }

    console.log(this.cart);
  }
  addOrder(order: newOrder) {
    let cartOrder = localStorage.getItem('cart');
    console.log(cartOrder);

    let id = this.cs.get('userid');
    console.log(id);
    let address = document.getElementById('#address') as HTMLInputElement;
    console.log(address);
    let ordertotal = this.Total;
    console.log(ordertotal);
  }

  cart: Array<any> = [];
  Total: number = 0;
  newOrder: Array<any> = [];
  @Output() passFunction = new EventEmitter<any>();
  constructor(private os: OrderService, private cs: CookieService) {}

  ngOnInit(): void {
    this.initializeCart();
  }
}
