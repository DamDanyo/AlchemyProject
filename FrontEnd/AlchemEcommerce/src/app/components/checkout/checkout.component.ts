import { Component, OnInit } from '@angular/core';
import { Potions } from 'src/app/models/potions';

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
      this.Total += potion.potionvalue;
    }
  }

  deleteOrderItem(index: number): void {
    let localCart = localStorage.getItem('cart');
    if (localCart != null) {
      let cartArray = JSON.parse(localCart);
      console.log(index)
      this.Total -= cartArray[index].potion.potionvalue
      cartArray.splice(index, 1)
      localStorage.setItem("cart", JSON.stringify(cartArray))
      this.cart = cartArray
    }
    console.log(this.cart);
  }
 
  cart: Array<any> = [];
  Total: number = 0;
  constructor() {}

  ngOnInit(): void {
    this.initializeCart();
  }
}
