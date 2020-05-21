import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './components/home/home.component';
import {HomeRoutingModule} from "./home-routing.module";
import {MaterialModule} from "../../material/material.module";
import {FormsModule} from "@angular/forms";
import {SharedModule} from "../../shared/shared.module";



@NgModule({
  declarations: [HomeComponent],
    imports: [
        CommonModule,
        HomeRoutingModule,
        MaterialModule,
        FormsModule,
        SharedModule
    ]
})
export class HomeModule { }
