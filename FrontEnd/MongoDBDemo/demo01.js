var MongoClient = require("mongodb").MongoClient;
var assert = require("assert");

var url = "mongodb://localhost:27017/mercury";

MongoClient.connect(url, function(err, db){ //callback function variables are always: err, db
	assert.equal(null, err);
	console.log("Connecting to MongoDB");
	db.close();
});