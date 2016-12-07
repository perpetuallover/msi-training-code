// JS OOP Concepts: constructor
var assert = require("assert");

var Vehicle = function() {
	this.price = 1000;
};

var v = new Vehicle();		// User "new" keyword to make the function as constructor
assert.equal(1000, v.price);
assert.ok(v instanceof Vehicle);
var u = Vehicle();			// Without "new" keyword, it is only a function
assert.ok(u === undefined);
assert.ok(!(u instanceof Vehicle));


// How to make a constructor always return an object even invoked as a function?
var Person = function(name) {
	if(!(this instanceof Person)) {
		return new Person(name);
	}
	this.name = name;
}

var p = new Person("Alice");
assert.equal("Alice", p.name);
assert.ok(p instanceof Person);
var q = Person("Bob");
assert.equal("Bob", q.name);
assert.ok(q instanceof Person);

// What if a constructor returns a value
var A = function() {
	this.value = 100;
	return 101;		// It returns a primitive value
};
var a1 = new A();	// Using constructor call will omit the returened primitive value
assert.equal(100, a1.value);
assert.ok(a1 instanceof A);
var a2 = A();
assert.equal(101, a2); 
assert.ok(!(a2 instanceof A));

var B = function() {
	this.value = 100;
	return {value : 200};	// it returns an object
};
var b1 = new B();
assert.equal(200, b1.value);	// b1 is the returned object. Constructor failed
assert.ok(!(b1 instanceof B));
var b2 = B();
assert.equal(200, b2.value);	
assert.ok(!(b2 instanceof B));

var C = function() {
	this.value = 100;
	return this;
}
var c1 = new C();
assert.equal(100, c1.value);
assert.ok(c1 instanceof C);

var c2 = C();
assert.ok(!(c2 instanceof C));
assert.equal(100, value); // *value belongs to global scope

console.log(c2.value);
console.log(c2);
