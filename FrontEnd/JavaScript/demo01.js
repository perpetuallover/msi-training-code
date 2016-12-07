//Basic JavaScript
var assert = require("assert"); // require modules (Like import ... in java)

//Define a Variable 
var x = 10;
assert.equal(10, x); // FIRST IS EXPECTED VALUE, SECOND IS ACUTAL VALUE
x = "abb"; // JS is a loose-type and we can assign any type is value

var y;
assert.equal(undefined, y); // if you do not give a default value , it's default value is undefined
 
//Define a function
function foo() {
	return "foo";
}
assert.equal("foo", foo());

//Define a function with parameters
var hello = function(name) {
	return "hello " + name;
};
assert.equal("hello Alice", hello("Alice"));

//Define a funtion without paramenters, but it can accept any number of parameters
function avg() {
	var length = arguments.length;
	var sum = 0;
	for(var i = 0; i < length; ++i) {
		sum += arguments[i];
	}
	return sum / length;
}
assert.equal(5, avg(1, 5, 9));

//Hoisting Feature -> no block scope
(function() {       		// Self-Invoking function 
	assert.equal(undefined, i);
	assert.equal(undefined, j); // undefined =/= not defined
	for(var i = 0; i < 10; ++i) {
		for(var j = 0; j < 10; ++j) {
			//some code
		}
	}
	assert.equal(10, i);
	assert.equal(10, j);
})();


(function(a){
	console.log(a);
})("hello");

// How to find whether or not a variable is defined?
//assert.equal(undefined, z); // z is not defined, thus is not undefined. undefined != not defined
assert.ok(typeof z === "undefined");   

//Difference between == and ===
assert.ok(5 == "5");  // == compares the value
assert.ok(!(5 === "5")) // === compares the type first, then compare the value

//?primitive type -> string number...

var obj1 = {name: "Bob"};
var obj2 = {name: "Bob"};
assert.ok(!(obj1 == obj2));
assert.ok(!(obj1 === obj2)); // For objects, both == and === will check the reference of the two types

//Difference between null and undefined
assert.ok(null == undefined);
assert.ok(!(null === undefined));
assert.equal(3, 3 + null); // In arithemetic expression, null will be converted to 0
assert.ok(isNaN(3 + undefined)); // In arithemtic expression, undefined will result NaN
// NaN == NaN ? False

//Local variable and global variable
(function(){
	var str1 = "abc"; // local variable
	str2 = "def"; // global variable: if in side of a function mush run the function first then use the global variable
})();
assert.ok(typeof str1 === "undefined");
assert.equal("def", str2);



// BOOK : The Good Parts


// Hoisting feature for funcitons
(function() {
	assert.equal("f1", f1());
	function f1() { // Using this way to define a function will get hoisting feature
		return "f1";
	};

	//assert.equal("f2", f2()); // Using var to define a function does not have hoisting feature
	assert.equal(undefined, f2);
	var f2 = function() {
		return "f2";
	};
	assert.equal("f2", f2());
})();


//Difference between using and not using var to define a global variable
assert.equal(undefined, p);  //p has hoisting feature
var p = 10;  //Define global variable using var
delete p;
assert.equal(10, p); //p cannot be deleted

assert.ok(typeof q === "undefined");
q = 20;      //Define global variable not using var
delete q;
assert.ok(typeof q === "undefined"); // q can be deleted