var A = function(){
	this.name = "A";
	this.price = "100";
};
A.prototype.city = "Princeton";
var B = function(){};
var C = function(){};
var D = function(){};
var E = function(){};

B.prototype = new A();
C.prototype = Object.create(A.prototype);
C.prototype.constructor = C;
D.__proto__ = new A();

var b = new B();
var c = new C();
var d = new D();

console.log(b.name);
console.log(c.name);
console.log(d.name);

console.log("+++++++++++++++++++++++++++++++++++++");

console.log(b.city);
console.log(c.city);
console.log(d.city);

console.log("+++++++++++++++++++++++++++++++++++++");

var a = new A();
E.__proto__ = a;
var e = new E();
var e2 = new E();
e2.__proto__ = new A();
console.log(e.name);
console.log(e.city);
console.log(e2.name);
console.log(e2.city);

console.log(Object.getOwnPropertyNames(e2));

console.log("+++++++++++++++++++++++++++++++++++++");
a.name = "AAA";
console.log(b.name);
console.log(c.name);
console.log(e2.name);

console.log("+++++++++++++++++++++++++++++++++++++");

console.log(b.__proto__);
console.log(c.__proto__);

console.log("+++++++++++++++++++++++++++++++++++++");
var A1 = function(){
	this.name = "A1";
	console.log("Create A1");
};
A1.prototype.sayHello = function(){
	 console.log("A1 say Hello!");
};

var B1 = function(){
	console.log("Create B1");
};

var B2 = function(){
	console.log("Create B2");
};

var B3 = function(){
	this.base = A1;
	this.base();
	console.log("Create B3");
};

B1.prototype = new A1();
B2.prototype = Object.create(A1.prototype);
B2.prototype.constructor = B2;

B3.prototype = Object.create(A1.prototype);
B3.prototype.constructor = B3;

var b1 = new B1();
var b2 = new B2();
var b3 = new B3();

console.log(b1.name);
console.log(b2.name);
console.log(b3.name);

console.log(b1 instanceof A1);
console.log(b2 instanceof A1);
console.log(b3 instanceof A1);

console.log(b1.sayHello());
b2.sayHello();
b3.sayHello();

console.log("+++++++++++++++++++++++++++++++++++++");
var AA = function(){
	this.name = "AA";
}
var BB = function(){
	this.value = "1000";
}

var CC = function(){
	AA.call(this);
	BB.call(this);
}

var cc = new CC();
console.log(cc.name);
console.log(cc.value);

console.log(cc instanceof AA);