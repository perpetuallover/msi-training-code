var MongoClient = require("mongodb").MongoClient;
var assert = require("assert");

var url = "mongodb://localhost:27017/mercury";

var insertOneRecord = function(db, callback){ 
	var collection = db.collection("emp");
	collection.insertOne({ // API insert multiple
		name : "Steven", // js obj will auto convert to JSON format
		address : {
			city: "Greenbelt",
			state: "MD"
		},
		age: 51
	}, function(err, result){
		assert.equal(null, err);
		console.log("Insert a record");
		callback(result);
	});
};

MongoClient.connect(url, function(err, db){
	assert.equal(null, err);
	insertOneRecord(db, function(result){
		console.log(result); //using .something to get small collection of info
		db.close();
	});
})