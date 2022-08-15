import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { MainBrowserComponent } from './components/main-browser/main-browser.component';
import { MainNavbarComponent } from './components/main-navbar/main-navbar.component';
import { CartComponent } from './components/cart/cart.component';
import { CookieModule } from 'ngx-cookie';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    CheckoutComponent,
    MainBrowserComponent,
    MainNavbarComponent,
    CartComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CookieModule.withOptions(),
    BrowserAnimationsModule,
    RouterModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
