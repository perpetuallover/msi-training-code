var A = function(){};
var B = function(){};

A.prototype = Object.create(B.prototype);
A.prototype.constructor = A;
// A.prototype = new B();
var a = new A();
console.log(Object.getPrototypeOf(a) == A.prototype);
console.log(Object.getPrototypeOf(A.prototype) == B.prototype);
console.log(Object.getPrototypeOf(B.prototype) == Object.prototype);
console.log(Object.getPrototypeOf(Object.prototype) == null);
console.log("+++++++++++++++++++++++++++++++++++++");
console.log(Object.getPrototypeOf(new B()) == B.prototype);
console.log(Object.getPrototypeOf(new A()) == new B());
console.log(Object.getPrototypeOf(A) == Function.prototype);
console.log(Object.getPrototypeOf(Function.prototype) == Object.prototype);
console.log(Object.getPrototypeOf(Object.prototype) == null);

console.log("+++++++++++++++++++++++++++++++++++++");
var obj = Object();
console.log(Object.getPrototypeOf(Object) === Function.prototype);
console.log(Object.getPrototypeOf(obj) === Object.prototype);
console.log(Object.getPrototypeOf(obj) === Function.prototype);