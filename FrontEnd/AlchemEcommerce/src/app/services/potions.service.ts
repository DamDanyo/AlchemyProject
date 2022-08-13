import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../models/order';
import { Potions } from '../models/potions';

@Injectable({
  providedIn: 'root'
})
export class PotionsService {

  //potions object to get displayed
<<<<<<< HEAD
 // potion:Potions = {
  //  name:"",
  //  description:""
    //sprite:""
 // }
=======
  // potion:Potions = {
  //   name:"",
  //   description:""
  //   //sprite:""
  // }



>>>>>>> 361566d8df8b4f282dd89f795dfd633769a2b983
 private getPotionsUrl = "http://localhost:5555/data/potion/all"
  
 getPotionTest(){

  return  this.http.get<any>(this.getPotionsUrl);

 }

 


  constructor(private http:HttpClient) { }

  //This function will GET Potion data from HP API
  getPotionFromApi(name: any, description:any):Observable<HttpResponse<Potions>>{
    return this.http.get("http://localhost:5555/data/potion/all" , {observe: "response"}) as Observable<HttpResponse<Potions>>
   //return this.http.get("localhost:5555/data/potion/all" , {observe: "response"}) as Observable<HttpResponse<Potions>>

    //console.log("response")
   // return this.http.get("localhost:5555/data/potion/all").subscribe((returnedStuff) => {console.log(returnedStuff);});

  }
  
  sendOrder(order:Order):Observable<Order>{
    return this.http.post("http://localhost:5555/data/order/insert", order) as Observable<Order>
  }

}
