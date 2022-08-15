import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-checkout-complete',
  templateUrl: './checkout-complete.component.html',
  styleUrls: ['./checkout-complete.component.css'],
})
export class CheckoutCompleteComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  main() {
    this.router.navigateByUrl('/main');
  }
  cart() {
    this.router.navigateByUrl('/checkout');
  }
}
