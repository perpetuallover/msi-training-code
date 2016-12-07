// var s = "Marge let's \"went.\" I await news telegram.";
// console.log(s);
// console.log(s.split(""));
// console.log(s.split("").reverse().join(""));
// var s2 = "\"went.\"";
// console.log(s1.split("").reverse().join(""));
// console.log(s2.split("").reverse().join(""));
//console.log("\" w");
// var a = [1, 2];
// console.log(a);
// var b = a;
// b.splice(1,1);
// console.log(a);

//  app.factory("myFactory", ["$http", "$q", function($http, $q){

//  	return{
//  	 getData: function(){
//  	 	var d = $q.defer();
//  	 	$http.get(url).then(function(resp){
// 	 	d.reslove(resp.data);
// 	 	return d.promise;
// 	 }
//  	}
//  }])

// app.controller("mainCtrl", ["myFactory", function(myFactory){

// 	var data = myFactory.getData();
// 	data.then(function(value){

// 	})
// }])
 
 // var digitSum = function(num){
 // 	if(num < 10){
 // 		return num;
 // 	}
 // 	return digitSum(num / 10 | 0) + num % 10;
 // };

 // var sum = digitSum(1234);
 // console.log(sum);

 // var digitSum2 = function(num){
 // 	return num % 9;
 // }
 // console.log(digitSum2(1234));

 // t = "dcbba";
 // s = "abcd";

 // var findDuplicate = function(s, t){
 // 	var cs = 0;
 // 	var ct = 0;
 // 	t.split("").forEach(function(value){
 // 		ct += value.charCodeAt(0);
 // 	});
 // 	s.split("").forEach(function(value){
 // 		cs += value.charCodeAt(0);
 // 	});
 // 	return String.fromCharCode(ct - cs);
 // }

 // console.log(findDuplicate(s, t));

var canConstruct = function(ransomNote, magazine) {
    var characterMap = new Map();
    magazine.split("").forEach(function(key){
        characterMap.set(key, (characterMap.get(key) === undefined) ? 1 : characterMap.get(key) + 1);
    });
    //console.log(characterMap);
    ransomNote.split("").forEach(function(key){
        if(characterMap.get(key) === undefined){
        	console.log("here");
            return false;
        }else{
            if(characterMap.get(key) <= 0){
                return false;
            }else{
                characterMap.set(key, characterMap.get(key) - 1);
            }
        }
    })
    
};

console.log(canConstruct("aaac", "aba"));