var MongoClient = require("mongodb").MongoClient;
var assert = require("assert");

var url = "mongodb://localhost:27017/mercury";

var findByName = function(db, name, callback){
	var collection = db.collection("emp").find({name: name});
	collection.each(function(err, doc){
		if(doc !== null){
			console.log(doc);
		}else{
			callback();
		}
	});
};

var findByAge = function(db, age, callback){
	var collection = db.collection("emp").find({age: {$gt: age}});
	collection.each(function(err, doc){
		if(doc !== null){
			console.log(doc);
		}else{
			callback();
		}
	});
}

var findByState = function(db, state, callback){
	var collection = db.collection("emp").find({"address.state" : state});
	collection.each(function(err, doc){
		if(doc !== null){
			console.log(doc);
		}else{
			callback();
		}
	});
}

MongoClient.connect(url, function(err, db){
	assert.equal(null, err);
	// findByName(db, "Alice", function(){
	// 	db.close();
	// });
	// findByAge(db, 40, function(){
	// 	db.close();
	// });
	findByState(db, "NJ", function(){
		db.close();
	});

});

// check how to write complex logic