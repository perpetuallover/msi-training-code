// JS OOP Concepts: Inheritance
var assert = require("assert");

// Object.create(o) will return an object that inherits o
// Simulating Object.create(o)
function create(o){
	var F = function(){};
	F.prototype = o;
	return new F();
}

var A = function(){}
var B = function(){}
B.prototype = create(A.prototype);

var b = new B();
// prototype chain: b -> B.prototype -> A.prototype -> Object.prototype -> null
assert.ok(b instanceof B);
assert.ok(b instanceof A);

// Object Inheritance through property __proto__
var x = {
	name: "x"
};
var y ={}
y.__proto__ = x;	// make y inherit x
// prototype chain: y -> x -> Object.prototype -> null
assert.equal("x", y.name);
assert.ok(x.isPrototypeOf(y));
assert.ok(Object.prototype.isPrototypeOf(x));
// console.log(Object.getOwnPropertyNames(Object.prototype));

// __proto__ vs prototype
assert.ok(b.__proto__ === B.prototype);
assert.ok(!b.hasOwnProperty("__proto__"));

// Professional way to write the inheritance hierachy
var Shape = function(){
	this.x = 0;
	this.y = 0;
	console.log("Create an instance of Shape");
};
Shape.prototype.move = function(x, y){
	this.x = x;
	this.y = y;
	console.log("Move to (" + x + ", " + y + ")");
};

// The first way to make inheritance
var Rectangle = function(){
	Shape.call(this);	// Important to obtain x and y
	console.log("Create an instance of Rectangle");
};
Rectangle.prototype = Object.create(Shape.prototype);
//Rectangle.prototype = new Shape();
Rectangle.prototype.constructor = Rectangle;

var rect = new Rectangle();
assert.ok(rect instanceof Rectangle);
assert.ok(rect instanceof Shape);
assert.equal(0, rect.x); 
assert.equal(0, rect.y);
console.log(Object.keys(rect));

// The second way to make inheritance
var Triangle = function(){
	this.base = Shape;
	this.base();
	console.log("Create an instance of Triangle");
}
Triangle.prototype = Object.create(Shape.prototype);
Triangle.prototype.constructor = Triangle;

var tri = new Triangle();
assert.ok(tri instanceof Triangle);
assert.ok(tri instanceof Shape);
assert.equal(0, tri.x);
assert.equal(0, tri.y);

// Make use of properties without inheritance
// It provides a way to make multiple inheritance
var Point = function(){};
Point.prototype.move = function(x, y){
	Shape.prototype.move.call(this, x, y);
};

var point = new Point();
assert.ok(!(point instanceof Shape));
point.move(10, 20);
assert.equal(10, point.x);
assert.equal(20, point.y);
