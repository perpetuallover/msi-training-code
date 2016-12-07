var MongoClient = require("mongodb").MongoClient;
var assert = require("assert");

var url = "mongodb://localhost:27017/mercury";

var replaceByName = function(db, name, callback){
	var collection = db.collection("emp");
	collection.replaceOne({
		name : name
	}, {
		name: "David",
		address : {
			city: "Metuchen",
			state: "NJ"
		},
		age : 21
	}, function(err, result){
		assert.equal(null, err);
		callback();
	});
};

MongoClient.connect(url, function(err, db){
	assert.equal(null, err);
	replaceByName(db, "Bob", function(){
		db.close();
	});
});