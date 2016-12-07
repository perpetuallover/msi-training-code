//empservice.js

var express = require("express");
var router = express.Router();
var MongoClient = require("mongodb").MongoClient;
var ed = require("./empdao");

var url = "mongodb://localhost:27017/mercury";

//same url is Rest service
router.get("/", function(req, resp){
	MongoClient.connect(url, function(err, db){
		ed.findAll(db, function(result){
			resp.json(result);
			db.close();
		});
	});
});

router.post("/", function(req, resp){
	var emp = req.body;
	MongoClient.connect(url, function(err, db){
		ed.insert(db, emp, function(){
			resp.end("Done");
			db.close();
		})
	})
}) 

router.get("/:name", function(req, resp){
	var name = req.params.name;
	MongoClient.connect(url, function(err, db){
		ed.findByName(db, name, function(result){
			resp.json(result);
			db.close();
		})
	})
})

router.put("/", function(req, resp){
	var emp = req.body;
	console.log(emp);
	MongoClient.connect(url, function(err, db){
		ed.update(db, emp, function(){
			resp.end("Done");
			db.close();
		});
	})
})


router.delete("/:name", function(req, resp){
	var name = req.params.name;
	MongoClient.connect(url, function(err, db){
		ed.delete(db, name, function(){
			resp.end("Done");
			db.close();
		})
	})
})

module.exports = router;