import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar2',
  templateUrl: './navbar2.component.html',
  styleUrls: ['./navbar2.component.css']
})
export class Navbar2Component implements OnInit {

  hiddenToggle:boolean = true
  hiddenToggle2:boolean = true

  viewCart(){
    this.hiddenToggle = !this.hiddenToggle
  }
  logout(){
    this.hiddenToggle2 = !this.hiddenToggle2
  }





  constructor() { }

  ngOnInit(): void {
  }

}
