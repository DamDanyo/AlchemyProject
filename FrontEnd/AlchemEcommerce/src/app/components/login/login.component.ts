import {
  animate,
  state,
  style,
  transition,
  trigger,
} from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  animations: [
    trigger('fireball', [
      transition(':leave', [
        style({
          position: 'fixed',
          right: 0,
          bottom: 0,
          minWidth: '100vw',
          minHeight: '100vw',
          zIndex: 0,
          margin: 0,
        }),
        animate(2000),
      ]),
    ]),
  ],
})
export class LoginComponent implements OnInit {
  loginForm = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
  });
  userCreds: any;
  constructor(private us: UserService, private router: Router) {}

  userLogin() {
    this.userCreds = this.loginForm.value;
    this.us.login(this.userCreds).subscribe({
      next: (value) => {
        // Success
        console.info('%cYou are logged in.', 'color: green');
        console.info(value);
        this.router.navigate(['/main']);
      },
      error: (err) => {
        // Error Handling
        console.error('%cWrong credentials.', 'color: red');
        console.error(err.error);
      },
    });
  }

  ngOnInit(): void {}
}
