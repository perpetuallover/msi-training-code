var array = [1, 2, 3, 4, 5];

console.log(Object.getOwnPropertyNames(array));
console.log(JSON.stringify(array));

var person = {
	name: "Lily",
	age: "28"
}

console.log(typeof person);
console.log(typeof array);
console.log(typeof JSON.stringify(person));
console.log(typeof JSON.stringify(array));