define(function(){
	var foo = function(){
		console.log("Hello" + this.name);
	};
	foo.call(person);
});