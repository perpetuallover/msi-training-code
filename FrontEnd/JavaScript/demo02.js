// JS Data Types
var assert = require("assert");

// Keyword: typeof (always return string with lower-case)
//6 types: boolean, number, string, undefined, function, object
//In ES6, it introduced a new type called symbol
assert.ok(typeof true === "boolean");
assert.ok(typeof 100 == "number");
assert.ok(typeof undefined == "undefined");
assert.ok(typeof "abc" == "string");
assert.ok(typeof null == "object");
assert.ok(typeof {} == "object");
assert.ok(typeof [] == "object");
assert.ok(typeof function(){} == "function");
assert.ok(typeof new String("abc") == "object");

// Primitive types: boolean, number, string, undefined, null
// Primitive types are also immutable types
var str1 = "abc"; 				//primitive
var str2 = new String("abc");	//object
assert.ok(str1 == str2); 		// Their values are the same
assert.ok(!(str1 === str2)); 	// They have different types
str1.value = 100;
assert.equal(undefined, str1.value); // An immutable type cannot add additional properties
str2.value = 100;
assert.equal(100, str2.value);		 // An object can always add additional properties


//About Object and NEW keyword
var x = Object(100);			// Without new keyword, Object becomes a function
// As a funtion, Object will return an object that wraps the input parameter
assert.ok(x == 100);
assert.ok(!(x === 100));
assert.ok(typeof x === "object");

var person = {name: "Bob"};
var y = Object(person);  		// If the paremeter is an object, then Object function returns this object
assert.ok(y == person);
assert.ok(y === person);


// We can use this Object funtion to create a funtion to identify objects
function isObject(obj) {
	return obj === Object(obj);
}
assert.ok(isObject(person));
assert.ok(isObject([]));
assert.ok(isObject({}));
assert.ok(!isObject("abc"));
assert.ok(!isObject(123));
assert.ok(!isObject(null));
assert.ok(!isObject(true));
assert.ok(!isObject(undefined));
assert.ok(isObject(function(){}));