import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Hero} from "../vo/hero";
import {HeroService} from "../service/hero.service";


@Component({
  // directive tag name
  selector: 'my-heroes',
  moduleId: module.id, // enable relative path
  // could use url
  templateUrl: "../template/heroes.component.html",
  styleUrls: ["../css/heroes.component.css"],
  providers: [HeroService]
  // ` support multiple lines
 /* `
  <h1>{{title}}</h1>
  <h2>{{hero.name}} details</h2>
  <div>
    <p> ID: {{hero.id}}</p>
    <p> Name: {{hero.name}}</p>
  </div>
  `*/
  
})
export class HeroesComponent implements OnInit{ 
    
    x:string;
    // hero = "windstorm";
    hero: Hero = {
      id: 1,
      name : "windstorm"
    }
    selectedHero : Hero;
    heroes:Hero[];
    onSelect(hero:Hero):void{
      this.selectedHero = hero;
    }
    // constructor called at last
    // constructor is used to inject services
    constructor(private heroService: HeroService,
    private router: Router){
      console.log(this.selectedHero);
      
    }
    gotoDetail():void{
      this.router.navigate(["/detail", this.selectedHero.id]);
    }
    ngOnInit(): void{
      this.heroService.getHeroes().then(heroes => this.heroes = heroes);
      // this.heroService.getHeroes().then(function(resp: Hero[]){
      //   this.heroes = resp;
      //   console.log(resp);
      // })
    }
    add(name: string): void {
  name = name.trim();
  if (!name) { return; }
  this.heroService.create(name)
    .then(hero => {
      this.heroes.push(hero);
      this.selectedHero = null;
    });
  }
  delete(hero: Hero): void {
  this.heroService
      .delete(hero.id)
      .then(() => {
        this.heroes = this.heroes.filter(h => h !== hero);
        if (this.selectedHero === hero) { this.selectedHero = null; }
      });
}
}