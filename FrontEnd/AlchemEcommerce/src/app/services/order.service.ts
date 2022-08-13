import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../models/order';
import { UserCreds } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  //order:Order = {
    // userid: 11,
    // username: "daniel",
    // password: "password",
    // isadmin: true,
    // orderaddress: "high st",
   //ordertotal: ,   
    //items: "",
   // itemsquantity: "",
    
 // }



  
  //constructor(private http: HttpClient) {}
  //private loginUrl = 'http://localhost:5555/data/user/login';
  //private addUrl = 'http://localhost:5555/data/user';

  //login(userCreds: UserCreds): Observable<UserCreds> {
    //return this.http.post<UserCreds>(
      //this.loginUrl,
      //userCreds
   // ) as Observable<UserCreds>;
 //}




}
