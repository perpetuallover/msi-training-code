import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import {HeroDetailComponent} from "./component/hero-detail.component";
import {AppComponent} from './app.component';
import {HeroesComponent} from "./component/hero.component";
import {HttpModule} from "@angular/http";

import {RouterModule} from "@angular/router";
import {DashboardComponent} from "./component/dashboard.component";
import {AppRoutingModule} from "./app-routing.module";

// Imports for loading & configuring the in-memory web api
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './service/in-memory-data.service';

@NgModule({
  imports: [ BrowserModule,
  FormsModule,
  AppRoutingModule,
  HttpModule,
  InMemoryWebApiModule.forRoot(InMemoryDataService )
  ],
  declarations: [ AppComponent,
  HeroDetailComponent,
  HeroesComponent,
  DashboardComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { 

}