var f1 = (function(){
	var count = 0;
	return function(){
		console.log(++count);
	}
})()

for(var i = 0; i < 3; i++){
	f1();
}

console.log("+++++++++++++++++++++++");

var count2 = 0;
var f11 = function(){
	console.log(++count2);
};

f11();
f11();
f11();

console.log("+++++++++++++++++++++++");
ns = {};

var f2 = function(context){
	var p = 3;
	context.cube = function(base){
		return Math.pow(base, p);
	};
};
f2(ns);
console.log(ns.cube(4));

console.log("+++++++++++++++++++++++");
ns.square = function(base){
	return Math.pow(base, 2);
};

console.log(ns.square(5));
console.log(typeof ns);

var ns2 = [];
console.log(typeof ns2);
ns2.add = function(a, b){
	return a + b;
};
console.log(ns2.add(7, 10));

console.log(Object.keys(ns2));
console.log(Object.getOwnPropertyNames(ns2));

console.log("+++++++++++++++++++++++");

var Singleton = function(){
	var singleton;
	return{
		getInstance: function(){
			if(!singleton){
				singleton = new Object();
			}
			return singleton;
		}
	}
}

var s1 = Singleton().getInstance();
var s2 = Singleton().getInstance();

console.log(s1 === s2);

var RealSingleton = (function(){
	var s;
	return{
		getInstance: function(){
			if(!s){
				s = new Object();
			}
			return s;
		}
	}
})()

var rs1 = RealSingleton.getInstance();
var rs2 = RealSingleton.getInstance();
console.log(rs1 === rs2);

console.log("+++++++++++++++++++++++");

// for(var i = 0; i < 10; i++){
// 	setTimeout(function(){
// 		console.log(i);
// 	}, 1000);
// }

var printIndex = function(i){
	return function(){
		console.log(i);
	}
}
for(var i = 0; i < 10; i++){
	setTimeout(printIndex(i), 2000 / i);
}

console.log("+++++++++++++++++++++++");

if(!null){
	console.log("if condition");
}
if(null){
	console.log("null");
}