import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LayoutComponent} from "./layout/layout.component";
import {LoginComponent} from "./modules/auth/components/login/login.component";

// Aplicando tecnica de
const routes: Routes = [
  {
    path: '', redirectTo: '/login', pathMatch: 'full',
  },
  {
    path: '', component: LayoutComponent, children: [
      {
        path: 'home', loadChildren: () => import('./modules/home/home.module').then(m => m.HomeModule)
      }
    ]
  },
  {
    path: 'login', loadChildren: () => import('./modules/auth/auth.module').then(m => m.AuthModule)
  },
  {
    path: '**', component: LoginComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
