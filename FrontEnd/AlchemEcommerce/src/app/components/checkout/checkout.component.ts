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
      let q = this.cart[i].potionQuantity;
      let q2 = this.cart[i].potion.potionvalue
      console.log(q)
      this.Total = q2 * q;
    }
  }

  deleteOrderItem(index: number): void {
    let localCart = localStorage.getItem('cart');
    if (localCart != null) {
      let cartArray = JSON.parse(localCart);
      console.log(index)
      let q = cartArray.potionQuantity
      this.Total = cartArray[index].potion.potionvalue * q
      cartArray.splice(index, 1)
      localStorage.setItem("cart", JSON.stringify(cartArray))
      this.cart = cartArray
       if (this.cart.length == 0){
        this.Total = 0
       }
    
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
