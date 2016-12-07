import {Component, Input, OnInit} from "@angular/core";
import {ActivatedRoute, Params} from "@angular/router";
import {Location} from "@angular/common";


import {Hero} from "../vo/hero";
import {AppComponent} from"../app.component.js";
import {HeroService} from "../service/hero.service";
@Component({
    selector: "my-hero-detail",
    moduleId: module.id,
    templateUrl: "../template/hero-detail.component.html",
    styleUrls: ["../css/hero-detail.component.css"],
    providers: [HeroService]
})
export class HeroDetailComponent implements OnInit{
   // @Input()
    hero: Hero;
    //hero =AppComponent.arguments.selectedHero;
    constructor(
        private heroService: HeroService,
        private route:ActivatedRoute,
        private location:Location
    ){}
    ngOnInit(): void{
        this.route.params.forEach((params:Params) => {
            let id = +params["id"];
            this.heroService.getHero(id).then(hero => this.hero = hero);
        })
    }
    goBack(): void{
        this.location.back();
    }
    save(): void{
        this.heroService.update(this.hero).then(()=>this.goBack());
    }

}