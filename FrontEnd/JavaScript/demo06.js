// JS OOP Concepts: keyword this
var assert = require("assert");

/*
	Basically saying, "this" is the object or the owner that calls this. If we cannot 
	find the owner, then we move up until we find the global scope. In brower model, 
	"this" means window; in Node, "this" means global scope.
*/

var item ={
	price: 100,
	getPrice: function(){
		return this.price;
	},
	calculate: function(qty){
		var that = this;	// Make a local variable to represent item
		return {
			name: "order",
			getValue: function(){
				return qty * that.price;	// this -> undefined
			}
		}
	}
};
assert.equal(100, item.price);
assert.equal(100, item.getPrice());
var cal = item.calculate(10);
assert.equal("order", cal.name);
// assert.ok(isNaN(cal.getValue()));0
assert.equal(1000, cal.getValue());

// How to stabilize "this"
// Three ways: call, apply, bind
function power(a, b){		// Calculate (a+b)^n
	return Math.pow(a+b, this.n);	// this is undetermined
}
var p = {
	n: 2
};
assert.equal(25, power.call(p, 2, 3));	// The first parameter of call method specify "this"
assert.equal(25, power.apply(p, [2, 3]));	// The apply method is similar to call, but the second parameter is an array
// The method bind does not invoke the function, it only specify "this"
var power2 = power.bind(p);
assert.equal(25, power2(2, 3));
assert.equal(25, power.bind(p)(2, 3));

// Example: Find the total value of an order based on customer's type
// Normal function
function getTotalValue(qty, price, type){
	var result = qty * price;
	switch(type){
		case "VIP": result *= 0.7; break;
		case "Premium": result *= 0.8; break;
		case "Regular":
		default: break;
	}
	return result;
}
assert.equal(700, getTotalValue(10, 100, "VIP"));
assert.equal(800, getTotalValue(10, 100, "Premium"));
assert.equal(1000, getTotalValue(10, 100, "Regular"));

// Code Refactoring
// More efficient implementation
var discount = {
	VIP: 0.7,
	Premium: 0.8,
	Regular: 1
};
function getTotalValueEasy(qty, price){		// Decouple logic and data
	return qty * price * discount[this.type];
}
assert.equal(700, getTotalValueEasy.call({type: "VIP"}, 10, 100));
assert.equal(800, getTotalValueEasy.apply({type: "Premium"}, [10, 100]));
assert.equal(1000, getTotalValueEasy.bind({type: "Regular"})(10, 100));