// Methods in Object
var assert = require("assert");

//How traverse an object
var person = {
	firstName: "Bruce",
	lastName: "Lee",
	age: 38
};

var keys = Object.keys(person);
console.log(keys);
keys.forEach(function(key) {
	console.log(key + " " + person[key]);
});
console.log("********************************");

var props = Object.getOwnPropertyNames(person);
console.log(props);
props.forEach(function(prop) {
	console.log(prop + "---" + person[prop]);
});
console.log("********************************");
console.log(JSON.stringify(person)); 				// Convert the person into a (JSON)string format


//Difference between keys and getOwnPropertyNames
var array = [3, 2, 5, 1, 4];
console.log(Object.keys(array));
console.log(Object.getOwnPropertyNames(array));		// "length" is NOT an enumerable property
// getOwnProperfsdfdsftyNames is much stronger than keys



// Accessors and Mutators
var obj = {
	__value : 100,
	get value() {
		return this.__value;
	},
	set value(v) {
		this.__value = v;
	}
};
assert.equal(100, obj.value); 		//getter
obj.value(200);					//setter

//obj.value(200);

assert.equal(200, obj.value);	

