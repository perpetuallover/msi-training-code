var obj = {
	name: "Alice",
	age: 39
}

Object.observe(obj, function(changes){
	changes.forEach(function(change){
		console.log(change.type, change.name, change.oldValue);
	})
})

obj.name = "Lily";
delete obj.age;
obj.city = "Princeton";

console.log("++++++++++++++++++++++++++++");

var f1 = function(){
	setTimeout(function(){
		console.log("f1");
	}, 1000);
}

var f2 = function(){
	setTimeout(function(){
		console.log("f2");
	}, 500);
}

f1();
f2();

console.log("++++++++++++++++++++++++++++");
var f3 = function(value){
	return new Promise(function(resolve, reject){
		if(value > 99){
			resolve(value);
		}else{
			reject(value * 2);
		}
	});
}
var promise = f3(999);
var p2 = f3(90);

promise.then(function(value){
	console.log(value);
})

p2.then(function(){}, function(value){
	return f3(value);
}).then(function(value){
	console.log(value);
})

// var asyncTask = function(args, callback){
// 	console.log("asYncTask#: " + args);
// 	setTimeout(function(){
// 		callback(args);
// 	}, 1000)
// }

// asyncTask(1, 3, asyncTask(2, 2, function(){
// 	console.log("End");
// }))