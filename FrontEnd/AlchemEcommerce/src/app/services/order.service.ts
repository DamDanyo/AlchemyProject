import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { newOrder, Order } from '../models/order';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  // order:Order = {
  //   // userid: 11,
  //   // username: "daniel",
  //   // password: "password",
  //   // isadmin: true,
  //   // orderaddress: "high st",
  //   ordertotal: "",
  //   items: "",
  //   itemsquantity: "",

  // }

  placeOrder(newOrder: newOrder): Observable<newOrder> {
    return this.http.post<newOrder>(
      this.orderUrl,
      newOrder
    ) as Observable<newOrder>;
  }

  constructor(private http: HttpClient) {}
  private orderUrl = 'http://localhost:5555/data/order/insert';
  // private loginUrl = 'http://localhost:5555/data/user/login';
  // private addUrl = 'http://localhost:5555/data/user';

  // login(userCreds: UserCreds): Observable<UserCreds> {
  //   return this.http.post<UserCreds>(
  //     this.loginUrl,
  //     userCreds
  //   ) as Observable<UserCreds>;
  // }
}
