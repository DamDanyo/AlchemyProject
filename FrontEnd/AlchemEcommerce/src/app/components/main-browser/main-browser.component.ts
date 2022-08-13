import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order';
import { Potions } from 'src/app/models/potions';
import { OrderService } from 'src/app/services/order.service';
import { PotionsService } from 'src/app/services/potions.service';



@Component({
  selector: 'app-main-browser',
  templateUrl: './main-browser.component.html',
  styleUrls: ['./main-browser.component.css']
})
export class MainBrowserComponent implements OnInit {

 
  public input:number = 0;
   
  public potionsArray:Potions[] = [];
  
  // testOrder = new Order(
  //   useridFK:"",
  //   userid: 11,
  //   username: "daniel",
  //   password: "password",
  //   isadmin: true,    
  //   orderaddress: "high st",
  //   ordertotal: 55,   
  //   items: [20, 2],
  //   itemsquantity: [10, 50],
  // );

  Order: any;



  
  //ptools = [Potions]

  constructor(private ps:PotionsService) { }

 getPotions(){

      this.ps.getPotionTest().subscribe(
      {next:(data)=>{
        this.potionsArray = data
        data.push()
        console.log(this.potionsArray)
        var realNameArray = []
        for (let nameArray of this.potionsArray){
          console.log(nameArray)
          realNameArray.push({
            name:nameArray.name,
            description:nameArray.description
        })
        console.log(realNameArray)
        }
      } 
      })
    }
   
    
  addPotionsToInventory(){
 
    let potionQuantity = document.getElementById("numInput") as HTMLInputElement|null;
    if(potionQuantity != null){
      const value = potionQuantity.value
      console.log(value)
    }
    return 


    // this.order = this.testOrder.value;
    // this.ps.sendOrder(this.Order).subscribe((response: any) => {
    //   console.log(response);
    // });

    // if (this.Order) {
    // } else {
    // }
       
        
      // }
     


  }
  



// THIS WORKS
  //   this.ps.getPotionTest().subscribe(
  //     {next:(data)=>{
  //       console.log(data)
  //     }, error:(err)=>{
  //       console.log(err)
  //     }
  //   } )
  // }



    //THIS SECTION WAS ORIGINAL
    // this.ps.getPotionFromApi("").subscribe(
    //   (data:any) => {
    //     this.potionsArray = data.body;
    //     console.log(this.potionsArray);
    
        // for (let potionVar of data){
        
// potential refactor
  //        for (let Potions of data) {
          //  potionVar.push({
          //  name: Potions.name
          //  });
          // console.log(potionVar);



//dans
          //var data1 = [];
    // for (let reimb of data) {
    //   data1.push({
    //     ID: reimb.reimb_id,
    //     Amount: reimb.reimb_amount,
    //     Submitted: reimb.reimb_submitted,
    //     Description: reimb.reimb_description,
    //     Author: reimb.reimb_author,
    //     Resolver: reimb.reimb_resolver,
    //     Status: reimb.reimbursement_status.reimb_status,
    //     Type: reimb.reimbursement_type.reimb_type,
    //   });

      //  } 
      //  console.log(data);
     // }
  //  )
  


  ngOnInit(): void {

    
    
      this.ps.getPotionFromApi("","").subscribe(
        (data:any) => {
          this.potionsArray = data.body;
       //   console.log(this.potionsArray);
        }
      )
    

      this.ps.getPotionTest().subscribe(
        {next:(data)=>{
          this.potionsArray = data
          data.push()
        //  console.log(this.potionsArray)
          var realNameArray = []
          for (let nameArray of this.potionsArray){
            console.log(nameArray)
            realNameArray.push({
              name:nameArray.name
          })
        //  console.log(realNameArray)
          }
        
        } 
        })

  }

}

  
  