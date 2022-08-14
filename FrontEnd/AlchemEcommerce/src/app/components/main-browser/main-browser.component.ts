import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie';
import { Order } from 'src/app/models/order';
import { Potions } from 'src/app/models/potions';
import { OrderService } from 'src/app/services/order.service';
import { PotionsService } from 'src/app/services/potions.service';

@Component({
  selector: 'app-main-browser',
  templateUrl: './main-browser.component.html',
  styleUrls: ['./main-browser.component.css'],
})
export class MainBrowserComponent implements OnInit {
  public input: number = 0;

  public potionsArray: Potions[] = [];

  // testOrder = new Order(
  //   useridFK:{,
  //   userid: 11,
  //   username: "daniel",
  //   password: "password",
  //   isadmin: true,}
  //   orderaddress: "high st",
  //   ordertotal: 55,
  //   items: [20, 2],
  //   itemsquantity: [10, 50],
  // );

  Order: Array<any> = [];
  @Output() passFunction = new EventEmitter<any>();

  constructor(
    private ps: PotionsService,
    private cookieService: CookieService,
    private router: Router,
  ) {}

  getPotions() {
    this.ps.getPotionTest().subscribe({
      next: (data) => {
        this.potionsArray = data;
        data.push();
        console.log(this.potionsArray);
        var realNameArray = [];
        for (let nameArray of this.potionsArray) {
          console.log(nameArray);
          realNameArray.push({
            name: nameArray.name,
            description: nameArray.description,
          });
          console.log(realNameArray);
        }
      },
    });
  }

  addPotionsToInventory(itemNum: number, potion: any) {
    let userid = this.cookieService.get('userid');
    console.log(userid);

    let potionQuantity = document.getElementById(
      'potionQuantity-' + itemNum
    ) as HTMLInputElement | null;
    if (potionQuantity != null) {
      const value = potionQuantity.value;
      console.log(value);
      let cartItem = {
        useridFK: {
          userid: userid,
        },
        potion: potion,
        potionQuantity: JSON.parse(value)  
      };
      this.Order.push(cartItem)
    }
      console.log(this.Order)
      localStorage.setItem("cart", JSON.stringify(this.Order))
  }

  






  ngOnInit(): void {

    



    this.ps.getPotionFromApi('', '').subscribe((data: any) => {
      this.potionsArray = data.body;
      //   console.log(this.potionsArray);
    });

    this.ps.getPotionTest().subscribe({
      next: (data) => {
        this.potionsArray = data;
        data.push();
        //  console.log(this.potionsArray)
        var realNameArray = [];
        for (let nameArray of this.potionsArray) {
          console.log(nameArray);
          realNameArray.push({
            name: nameArray.name,
          });
          //  console.log(realNameArray)
        }
      },
    });
  }
}
