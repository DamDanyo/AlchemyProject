import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User, UserCreds } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}
  private loginUrl = 'http://localhost:5555/data/user/login';
  private addUrl = 'http://localhost:5555/data/user';

  login(userCreds: UserCreds): Observable<UserCreds> {
    return this.http.post<UserCreds>(
      this.loginUrl,
      userCreds
    ) as Observable<UserCreds>;
  }

  addUser(user: User): Observable<User> {
    return this.http.post<User>(this.addUrl, {
      userid: 1,
      username: '',
      password: '',
      isadmin: false,
    }) as Observable<User>;
  }
}
