import { NgModule }      from '@angular/core';

import {RouterModule, Routes} from "@angular/router";
import {HeroDetailComponent} from "./component/hero-detail.component";
import {DashboardComponent} from "./component/dashboard.component";
import {HeroesComponent} from "./component/hero.component";

const routes:Routes = [

    {
      path: "heroes",
      component: HeroesComponent
    },
    {
      path: "dashboard",
      component: DashboardComponent
    },
    {
      path: "detail/:id",
      component: HeroDetailComponent
    },
    {
      path: "",
      redirectTo: "/dashboard",
      pathMatch: "full"
    }
  
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{}
