var person = {
	name: "Alice",
	age: 39,
	state: "NJ"
}

person.city = "Princeton";
console.log(person);
Object.defineProperty(person, "name", {
	value : "Bob"
});
console.log(person);
Object.defineProperty(person, "age",{
	writable: false
});
person.age = 40;
console.log(person);
Object.defineProperty(person, "state", {
	enumerable: false
})
console.log(person);
Object.defineProperty(person, "state", {
	enumerable: true,
	//configurable: false
})
console.log(person);
Object.defineProperty(person, "state", {
	configurable: true
})
console.log(person);
console.log("+++++++++++++++++++++++++++++++++");


var p2 = {
	name: "Lily",
	age: "18"
}

console.log(Object.isExtensible(p2));
console.log(Object.isSealed(p2));
console.log(Object.isFrozen(p2));

Object.preventExtensions(p2);
p2.city = "Boston";
delete p2.age;
console.log(p2);

console.log(Object.isExtensible(p2));
console.log(Object.isSealed(p2));
console.log(Object.isFrozen(p2));

Object.seal(p2);
delete p2.name;
p2.name = "Lucy";
console.log(p2);

console.log(Object.isExtensible(p2));
console.log(Object.isSealed(p2));
console.log(Object.isFrozen(p2));

Object.freeze(p2);
p2.name = "Alice";
console.log(p2);

console.log(Object.isExtensible(p2));
console.log(Object.isSealed(p2));
console.log(Object.isFrozen(p2));

console.log("+++++++++++++++++++++++++++++++++");

var p2 = {
	name: "Lucy",
	age: "18"
}

Object.freeze(p2);
Object.seal(p2);
p2.age = "19";
console.log(p2);