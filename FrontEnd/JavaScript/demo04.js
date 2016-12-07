// Attributes of properties and Status of Object
var assert = require("assert");

// Three attributes: enumerable, writable, configurable
var person = {
	name: "Bob"
};

person.salary = 1000;		// In this way, salary is default to be enumerable, writable and configurable
console.log(Object.keys(person));
person.salary = 2000;		// It's writable
assert.equal(2000, person.salary);
console.log("********************************");
Object.defineProperty(person, "sex", {
	value: "male"			// If you do not specify, then all three attributes of sex are false;
});
assert.equal("male", person.sex);
console.log(Object.keys(person)); 	// "sex" is NOT enumerable
person.sex = "female";
assert.equal("male", person.sex);	// "sex" is NOT writable
console.log(Object.getOwnPropertyNames(person));
console.log("********************************");
Object.defineProperty(person, "age", {
	value: 30,
	writable: true,
	enumerable: true,
	configurable: false
});
assert.equal(30, person.age);
console.log(Object.keys(person));
person.age = 40;
assert.equal(40, person.age);
Object.defineProperty(person, "salary", {writable: false}); // Make salary not writable , means we can still can change
person.salary = 5000;
assert.equal(2000, person.salary);

/**
Object.defineProperty(person, "sex", {writable: true}); // get Error
person.sex = "female"; // configurable controls writable and enumerable
*/

// Three status of objects: extensible, sealed, frozen
var obj = {
	x : 100
};
//By default, an object is extensible that means it can add additional properties
obj.y = "abc";
assert.equal("abc", obj.y);		// obj can add a new property y and thus is extensible
assert.ok(Object.isExtensible(obj));
Object.preventExtensions(obj); 	// obj is NOT extensible any more
assert.ok(!Object.isExtensible(obj));
obj.z = 200;
assert.equal(undefined, obj.z);
// At this time, obj is not sealed and we can delete its properties
assert.ok(!Object.isSealed(obj));
delete obj.y;
assert.equal(undefined, obj.y); // obj.y is successfully deleted
Object.seal(obj);	// cannot add or deleted new and old properties, but we can still update current property
delete obj.x;
assert.equal(100, obj.x);

delete obj;			// var定义的是variable是无法删掉的
console.log(obj);

obj.x = 200;
assert.equal(200, obj.x);
assert.ok(!(Object.isFrozen(obj)));
Object.freeze(obj);		//Now obj is frozen and its properties cannot be changed, (add and deleted?)
obj.x = 300;
assert.equal(200, obj.x);

// All primitive values are frozen
var str = "abc";
assert.ok(Object.isFrozen(str));
Object.prototype.value = 100;
assert.equal(100, str.value);		// A frozen object might obtain new property through inheritance
