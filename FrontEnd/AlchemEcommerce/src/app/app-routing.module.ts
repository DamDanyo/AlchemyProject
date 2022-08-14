import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckoutCompleteComponent } from './components/checkout-complete/checkout-complete.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { LoginComponent } from './components/login/login.component';
import { MainBrowserComponent } from './components/main-browser/main-browser.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },

  {
    path: 'checkout',
    component: CheckoutComponent,
  },

  {
    path: 'main',
    component: MainBrowserComponent,
  },

  {
    path: 'checkout-complete',
    component: CheckoutCompleteComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
