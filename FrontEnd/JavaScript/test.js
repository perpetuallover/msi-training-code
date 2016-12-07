for(var i = 1; i < 11; i++){
	setTimeout(printIndex(i), 200 * i);
}

function printIndex(i){
	return function(){
		console.log(i);
	}
}