import { Component, OnInit } from '@angular/core';
import { Potions } from 'src/app/models/potions';
import { PotionsService } from 'src/app/services/potions.service';



@Component({
  selector: 'app-main-browser',
  templateUrl: './main-browser.component.html',
  styleUrls: ['./main-browser.component.css']
})
export class MainBrowserComponent implements OnInit {

  //  //hidden toggle
  //  hiddenToggle:boolean = true

   //4 browser objects that we will render onto our webpage
  //  potion1 = {
  //    id: 1,
  //    name: "example",
  //    purchase: "Yes/no"
  //  }
 
  //  potion2 = {
  //    id: 2,
  //    name: "example2",
  //    purchase: "Yes/no"
  //  }
 
  //  potion3 = {
  //    id: 3,
  //    name: "example3",
  //    purchase: "Yes/no"
  //  }
 
  //  potion4 = {
  //    id: 4,
  //    name: "example4",
  //    purchase: "Yes/no"
  //  }
  
  //  potion5 = {
  //    id: 5,
  //    name: "example5",
  //    purchase: "Yes/no"
  //  }
 
  //  potion6 = {
  //    id: 6,
  //    name: "example6",
  //    purchase: "Yes/no"
  //  }
 
  //  //An array filled with the above browser objects
  //  potionsArray = [this.potion1, this.potion2, this.potion3, this.potion4, this.potion5, this.potion6]
 
   
   
  public potionsArray:Potions[] = [];
  

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
  

  purchasePotion(){
     
  }

  ngOnInit(): void {

    
    
      this.ps.getPotionFromApi("","").subscribe(
        (data:any) => {
          this.potionsArray = data.body;
          console.log(this.potionsArray);
        }
      )
    

      this.ps.getPotionTest().subscribe(
        {next:(data)=>{
          this.potionsArray = data
          data.push()
          console.log(this.potionsArray)
          var realNameArray = []
          for (let nameArray of this.potionsArray){
            console.log(nameArray)
            realNameArray.push({
              name:nameArray.name
          })
          console.log(realNameArray)
          }
        
        } 
        })

  }

}

  
  