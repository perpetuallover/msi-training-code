import {Injectable} from "@angular/core";
import {Http, Headers} from "@angular/http";
import {Hero} from "../vo/hero";
import "rxjs/add/operator/toPromise";

// each service must be Injectable
@Injectable()
export class HeroService{
    private url:string = "app/heroes";

    private headers = new Headers({'Content-Type': 'application/json'});
    getHeroes(): Promise<Hero[]>{
       
            return this.http.get(this.url)
               .toPromise()
               .then(response => console.log(response.json())||response.json().data as Hero[])
               .catch(this.handleError);
    }
    getHero(id:number): Promise<Hero>{
        return this.getHeroes().then(heroes => 
            heroes.find(hero => hero.id ===id)
        );
    }
update(hero: Hero): Promise<Hero> {
  const url = `${this.url}/${hero.id}`;
  return this.http
    .put(url, JSON.stringify(hero), {headers: this.headers})
    .toPromise()
    .then(() => hero)
    .catch(this.handleError);
}
    create(name: string): Promise<Hero> {
  return this.http
    .post(this.url, JSON.stringify({name: name}), {headers: this.headers})
    .toPromise()
    .then(res => res.json().data)
    .catch(this.handleError);
}
    private handleError(error:any){
        console.error("An error is occurred!", error);
        return Promise.reject(error.message || error);
    }
    constructor(private http:Http){

    }
    delete(id: number): Promise<void> {
        const url = `${this.url}/${id}`;
        return this.http.delete(url, {headers: this.headers})
            .toPromise()
            .then(() => null)
            .catch(this.handleError);
    }
}