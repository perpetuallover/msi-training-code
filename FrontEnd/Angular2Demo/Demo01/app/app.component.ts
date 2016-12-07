import { Component, OnInit } from '@angular/core';

@Component({
  // directive tag name
  selector: 'my-app',
  moduleId: module.id, // enable relative path
  // could use url
  templateUrl: './template/app.component.html'
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
export class AppComponent{ 
    title = "Tours of Heroes";
}