define(["module2"], function(module2){
	var foo = function(a, b){
		return 2 * module2.multiply(a, b);
	};
	return{
		foo: foo
	};
});