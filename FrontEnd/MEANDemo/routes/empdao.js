// empdao.js

var ed = {};
ed.findAll = function(db, callback){
	var collection = db.collection("emp").find();
	var result = [];
	collection.each(function(err, doc){
		if(doc !== null){
			result.push(doc);
		}else{
			callback(result);
		}
	});
};

ed.findByName = function(db, name, callback){
	var collection = db.collection("emp").find({name: name});
	var result;
	collection.each(function(err, doc){
		if(doc !== null){
			result = doc;
		}else{
			callback(result);
		}
	})
}

ed.delete = function(db, name, callback){
	var collection = db.collection("emp");
	collection.deleteOne({
		name: name
	}, function(err, result){
		callback();
	})
}

ed.insert = function(db, emp, callback){
	var collection = db.collection("emp");
	collection.insertOne(emp, function(err, result){
		callback();
	});
}

ed.update = function(db, emp, callback){
	var collection = db.collection("emp");
	delete emp._id;
	collection.replaceOne({
		name: emp.name
	}, emp, function(err, result){
		callback();
	})
	// collection.updateOne({
	// 	name: emp.name
	// }, {
	// 	$set: {address: emp.address, age: emp.age},
	// 	$currentDate: {"lastModified": true}
	// }, function(err, result){
	// 	callback();
	// });
}

module.exports = ed;