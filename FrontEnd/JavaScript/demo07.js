// JS OOP Concepts: Inheritance through prototype chain
var assert = require("assert");

/*
	Each object has a prototype and inherits all the properties from its prototype.
	The object prototype is also an object and thus has its own prototype. Thus we
	get a prototype chain until Object.prototype, whose prototype is null
*/
// An example to explain why prototype is important
var A = function(){
	this.value = 100;
	this.obj = {};
	this.getValue = function(){
		return this.value;
	}
}
var a1 = new A();
var a2 = new A();
assert.equal(a1.value, a2.value);
assert.ok(!(a1.obj == a2.obj)); // compare reference
assert.ok(!(a1.getValue == a2.getValue)); // They have different copies of functions and that waste memory

var B = function(){
	this.name = "B";
}
B.prototype.getName = function(){
	return this.name;
}
var b1 = new B();
var b2 = new B();
assert.equal(b1.name, b2.name);
assert.ok(b1.getName === b2.getName);	// They have the same function inherited from prototype

// Object.getPrototypeOf
// Prototype chain: b1 -> B.prototype -> Object.prototype -> null
assert.ok(Object.getPrototypeOf(b1) === B.prototype);
assert.ok(Object.getPrototypeOf(B.prototype) === Object.prototype);
assert.ok(Object.getPrototypeOf(Object.prototype) === null);
// Another prototype chain: B(function) -> Function.prototype -> Object.prototype -> null
assert.ok(Object.getPrototypeOf(B) === Function.prototype);
assert.ok(Object.getPrototypeOf(Object) === Function.prototype);
assert.ok(Object.getPrototypeOf(Function.prototype) === Object.prototype);

// isPrototypeOf to verify the prototype chain
assert.ok(B.prototype.isPrototypeOf(b1));
assert.ok(Object.prototype.isPrototypeOf(B.prototype));	

// Use prototype to make inheritance
var Parent = function(){
	this.name = "Parent";
};
Parent.prototype.hello = function(){
	return "Hello " + this.name;
};
var Child = function(){
	this.name = "Child";
};

// The first way to make inheritance
Child.prototype = new Parent();

var c = new Child();
// Prototype chain c -> Child.prototype = new Parent() -> Parent.prototype -> Object.prototype -> null
assert.ok(c instanceof Child);
assert.ok(c instanceof Parent);
assert.ok(c instanceof Object);
assert.equal("Child", c.name);	// c's own name
assert.equal("Hello Child", c.hello());
delete c.name;
assert.equal("Parent", c.name);	// inherited name from parent
assert.equal("Hello Parent", c.hello());

// The second way to make inheritance
var Base = function(){
	this.name = "Base";
}
var Sub = function(){
	Base.call(this)	// If I want to inherit properties from Base
}
assert.ok(Sub.prototype.constructor === Sub);
// Prototype chain: sub -> Sub.prototype -> Base.prototype -> Object.prototype -> null
Sub.prototype = Object.create(Base.prototype);
var sub = new Sub();	// This does not call the constructor of Base
assert.ok(sub instanceof Base); // only inherited from Base.prototype, not Base
// assert.equal(undefined, sub.name);
assert.equal("Base", sub.name);
assert.ok(Base.prototype.constructor === Base);
assert.ok(Sub.prototype.constructor === Base);		// This one does not make sense
Sub.prototype.constructor = Sub;	//