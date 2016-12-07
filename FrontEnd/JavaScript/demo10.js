// JS promise
var assert = require("assert");

//Callback function: It is a function that will be excecuted in the future
setTimeout(function(){
	console.log("This is a callback function");
}, 0);

console.log("Normal code after callback function");

// callback queue: exceute only after the normal(synchronous) functions

// Object.observe method contains callback funciton
var a = {
	x : 10,
	y: 100
}

Object.observe(a, function(changes){
	changes.forEach(function(change){
		console.log(change.type, change.name, change.oldValue);
	});
});

a.x = 20; // Update a field
a.str = "abc" //Add a new field
delete a.x; // Delete a field

// Asynchronized Task
function asyncTask(arg, callback){
	console.log("Running Task " + arg);
	setTimeout(function(){
		callback(arg + 1);
		console.log("Running callback for task " + arg);
	}, 100);
};

function finalTask(arg){
	console.log("Running final task " + arg);
};

asyncTask(1, function(arg){
	asyncTask(arg, function(arg){
		asyncTask(arg, function(arg){
			asyncTask(arg, function(arg){
				finalTask(arg);
			})
		})
	})
})

// asyncTask(1, 
// 	asyncTask(arg, 
// 		asyncTask(arg, 
// 			asyncTask(arg, 
// 				finalTask(arg)
// 			)
// 		)
// 	)
// )

//Introduce Promise
// Promise object has 3 status: pending, fulfilled(resolve), rejected
// callback and promise to simulate multi-threading

var f1 = function(){
	return new Promise(function(resolve, reject){
		setTimeout(function(){
			console.log("f1 finished running");
			resolve(100); // resolve hold the value
		}, 1000);
	});
};

var f2 = function(value){
	return new Promise(function(resolve, reject){
		console.log("f2 receive " + value);
		setTimeout(function(){
			console.log("f2 finished running");
			if(value > 20) reject(value);
			else resolve(value * 2);
		}, 1000);
	});
};

var f3 = function(value){
	console.log("f3 receives " + value);
};

var promise = f1();
promise.then(function(value){
	return f2(value);
}).then(function(value){
	f3(value);
}, function(value2){/*console.log("Reject value: " + value2);*/
	f3(value2);
});

promise.then(function(value){
	console.log("The value is still " + value);
});
// only reserve the firtst resolve value
// jqure, angular, default is wrapper of promise, promise is wrapper of callback, 