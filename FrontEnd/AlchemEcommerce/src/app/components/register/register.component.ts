import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  registerForm = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
  });
  userCreds: any;
  constructor(private us: UserService) {}

  register() {
    this.userCreds = this.registerForm.value;
    this.us.addUser(this.userCreds).subscribe((response: any) => {
      console.log(response);
    });
  }
  ngOnInit(): void {}
}
