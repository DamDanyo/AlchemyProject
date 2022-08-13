import { Component, OnInit } from '@angular/core';
import { PotionsService } from 'src/app/services/potions.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  constructor(private ps:PotionsService) {}

  getPotions() {
  this.ps.getPotionTest().subscribe(
         {next:(data)=>{
           console.log(data)
         }, error:(err)=>{
           console.log(err)
         }
       } )
     
      }

  ngOnInit(): void {

    this.ps.getPotionTest().subscribe(
         {next:(data)=>{
           console.log(data)
         }, error:(err)=>{
           console.log(err)
         }
       } )

  }

}
