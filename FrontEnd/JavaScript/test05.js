var Person = function(name){
	this.name = name;
	return this;
};

var p = new Person("Alice");
var p2 = Person("Bob");
console.log(p instanceof Person);
console.log("p: " + p);
console.log(p2 instanceof Person);
console.log(p2.name);
console.log(name);
//consol.log(p2);

var Aro = function(){
	if(!(this instanceof Aro)){
		return new Aro();
	}

}

