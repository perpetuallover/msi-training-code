// JS Closure
var assert = require("assert");

/*
	JS closure is a function that is defined in another function. The inner function can access
	all the local variables of the outer function. If the inner function is returned, then the 
	local variable of the outer function is still alive after the outer function is executed.
	Disadvantage: Closure might result memory leak.
*/

function welcome(){
	var name = "Alice";
	return function(prefix){
		return "Hello " + prefix + " " + name;
	}
}
var hello = welcome();
assert.equal("Hello Ms Alice", hello("Ms"));

// Module Pattern: Simulating Encapsulation
var Person = function(name){
	var obj = {};

	obj.getName = function() {
		return name;
	}

	obj.setName = function(theName) {
		name = theName
	}

	return obj;	
}
var p = Person("Bob");		// p does not contain the property name
assert.ok(!p.hasOwnProperty("name"));
assert.equal("Bob", p.getName());
p.setName("Steven");
assert.equal("Steven", p.getName());

// An example: define a function that print out 1 at first time, prints out 2 at second time, etc...
var counter = (function(){
	var c = 0;
	return function(){
		c++;
		console.log(c);
		//return c;
	}
})();

counter(); // 1
counter(); // 2

// Dynamic naming space
var cal = {}; 	// cal is a naming space
(function(context){
	var p = 2;
	context.power = function(base){
		return Math.pow(base, p);
	}
})(cal);
assert.equal(9, cal.power(3));

// *First application: Singleton Pattern
var Singleton = (function(){
	var instance;
	return{
		getInstance: function(){
			if(!instance) instance = new Object();
			return instance;
		}
	};
})();

var s1 = Singleton.getInstance();
var s2 = Singleton.getInstance();
assert.ok(s1 == s2);
//var s3 = Singleton.getInstance;

// Second Application: a typical error in the js project
// settimeout: delay function, setinterval
for(var i = 0; i < 5; i++){
	// setTimeout(function(){
	// 	console.log("Index " + i);
	// }, 100);
	setTimeout(handleIndex(i),1000 * 1 / i);
}
console.log("End of for loop");

//synchrous asychrous
//gof: command pattern
//SPA single page application RIA
function handleIndex(index){
	return function(){
		console.log("Index: " + index);
	}
}

console.log(1/0);
console.log(typeof(Infinity));
//assert.ok(Infinity === Infinity);
//assert.ok(Infinity < 1);

function f1(a){
	console.log(a);
};

