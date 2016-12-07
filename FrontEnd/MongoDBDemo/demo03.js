var MongoClient = require("mongodb").MongoClient;
var assert = require("assert");

var url = "mongodb://localhost:27017/mercury";

var findAll = function(db, callback){
	var collection = db.collection("emp").find(); // find can have condition to filt the result
	var array = [];
	collection.each(function(err, doc){
		assert.equal(null, err);
		if(doc !== null){
			//console.log(doc);
			array.push(doc);
		}else{
			callback(array, collection);
		}
	});

};

MongoClient.connect(url, function(err, db){
	assert.equal(null, err);
	findAll(db, function(result, collection){
		console.log(result);
		// console.log(collection);
		db.close();
	});
});