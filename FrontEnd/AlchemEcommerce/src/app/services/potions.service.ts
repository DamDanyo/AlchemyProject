import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Potions } from '../models/potions';

@Injectable({
  providedIn: 'root'
})
export class PotionsService {

  //potions object to get displayed
 // potion:Potions = {
  //  name:"",
  //  description:""
    //sprite:""
 // }
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
  

}
