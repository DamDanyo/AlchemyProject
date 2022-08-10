import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loginForm = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
  });
  userCreds: any;
  constructor(private us: UserService) {}

  userLogin() {
    this.userCreds = this.loginForm.value;
    this.us.login(this.userCreds).subscribe((response: any) => {
      console.log(response);
    });

    if (this.userCreds) {
    } else {
    }
  }

  ngOnInit(): void {}
}
