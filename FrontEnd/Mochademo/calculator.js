// Define class calculator

var Calculator = function(){
	if(!(this instanceof Calculator)){
		return new Calculator();
	}
};
Calculator.prototype.add = function(a, b){
	return a + b;
};
Calculator.prototype.subtract = function(a, b){
	return a - b;
};
Calculator.prototype.multiply = function(a, b){
	return a * b;
};
Calculator.prototype.divide = function(a, b){
	if (b == 0) return NaN;
	return a / b;
};

var ScientificCalculator = function(){};
ScientificCalculator.prototype = Object.create(Calculator.prototype);
ScientificCalculator.prototype.constructor = ScientificCalculator;
ScientificCalculator.prototype.sin =  function(x){
	return Math.sin(x);
}
ScientificCalculator.prototype.cos =  function(x){
	return Math.cos(x);
}
ScientificCalculator.prototype.tan =  function(x){
	return Math.tan(x);
}
ScientificCalculator.prototype.log =  function(x){
	return Math.log(x);
}

function withExponents(){
	this.pow = function(base, exp){
		return Math.pow(base, exp);
	};
	this.multiplyExp = function(array1, array2){
		return this.multiply(this.pow.apply(null, array1), this.pow.apply(null, array2));
	};
	this.divideExp = function(array1, array2){
		return this.divide(this.pow.apply(null, array1), this.pow.apply(null, array2));
	};
}

function delay(ms, obj, method, params){
	return new Promise(function(resolve, reject){
		if(typeof obj[method] === "function"){
			setTimeout(function(){
				var result = obj[method].apply(null, params);
				resolve(result);
			}, ms)
		}else{
			reject("error");
		}
	})
}

module.exports = {
	Calculator: Calculator,
	ScientificCalculator : ScientificCalculator,
	withExponents : withExponents,
	delay : delay
};
