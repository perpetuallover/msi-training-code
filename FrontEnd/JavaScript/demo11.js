// can write in white sheet
// Promise example

var task = function(arg){
	return new Promise(function(resolve, reject){
		setTimeout(function(){
			console.log("Task " + arg + " is done!");
			resolve(arg);
		}, 100)
	})
}
task(1).then(function(arg){
	return task(arg + 1);
});

task(3).then(function(arg){
	task(arg + 1);
});

//task(1).then(task(1));

// java hard parts: multi-threading and collections system
/*
JS interviews
both hard level and frequency

1. Prototype chain(inheritence)
a. B.prototype = new A();
b. B.prototype = Object.create(A.prototype);
   A.call(this)
   B.prototype.constructor = B;
c. B.__prototype__ = A;

multi-inheritance :
C{
	A.call(this);
	B.call(this);
}

2. Promise(coding) fix time out i = 5 loop

***3. (this) keyword call apply bind

4. closure

======================

5. local and global variables
6. hoisting feature
7. language preference e.g. == === primitive
false...
a. false , 0 , ""
b. null, undefined
*c. NaN
8. API what methods are in...

array is the stack structure
splice read and test(example)

concept is harder than API

jpmc due next Monday

// only + means conjective in string
*/