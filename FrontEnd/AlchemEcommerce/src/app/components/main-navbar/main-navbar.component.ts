import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main-navbar',
  templateUrl: './main-navbar.component.html',
  styleUrls: ['./main-navbar.component.css']
})
export class MainNavbarComponent implements OnInit {

  hiddenToggle:boolean = true
  hiddenToggle2:boolean = true

  viewCart(){
    this.hiddenToggle = !this.hiddenToggle
  }
  logout(){
    this.hiddenToggle2 = !this.hiddenToggle2
  }

  




  constructor(private router: Router) { }

  ngOnInit(): void {
  }

}
