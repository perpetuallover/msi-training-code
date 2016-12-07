var express = require("express");
var router = express.Router();

router.get("/", function(req, resp){
	resp.json({
		"firstName": "Alice",
		"lastName": "Lee",
		"age": 35
	});
});

module.exports = router;