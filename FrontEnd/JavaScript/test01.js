var x = 10;
x = "abb";
/* C
console.log(arguments);
*/
console.log("++++++++++++++++++++++++++++++++++++");
console.log(Array.prototype);
console.log("++++++++++++++++++++++++++++++++++++");
f1("a", "b", "c");
function f1(nums){
	console.log("f1 arguments: " + arguments);
	var array = [].slice.call(arguments);
	/*
		var array = Array.from(arguments);
	*/
	array.forEach(function(value, index, array){
		console.log("value: " + value + " index: " + index + " array: " + array);
	});
};
console.log("++++++++++++++++++++++++++++++++++++");

//f2();
var f2 = function(){
	console.log("f2");
	console.log("++++++++++++++++++++++++++++++++++++");
}
f2();

console.log(x1);
//console.log(x2);

var x1 = 10;
x2 = 20;
console.log("++++++++++++++++++++++++++++++++++++");

var a = [1, 2, 3, 4, 5, 6, 7, 8, 9];
console.log(a.slice(2, 5));
console.log(a.slice(-3, -1));
console.log(a);
console.log(a.splice(7));
console.log(a);
console.log(a.splice(-2));
console.log(a.splice(2, 2));
console.log(a);
console.log(a.splice(2, 0));
console.log(a);
console.log(a.splice(1, 1, 88));
console.log(a);
console.log(a.splice(1, 0, 99));
console.log(a);
console.log("++++++++++++++++++++++++++++++++++++");

console.log(undefined == undefined);
console.log(undefined === undefined);
console.log(null == null);
console.log(null === null);
console.log(NaN == NaN);
console.log("++++++++++++++++++++++++++++++++++++");
console.log(typeof x1);
console.log(typeof x2);
console.log(typeof x3);
var x1 = 10;
x2 = 20;