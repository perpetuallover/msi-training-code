// Use express.js to create a server
// Jquery is the selector based technology: can select tag, class, id
var express = require("express");//found in the node_moudles: if not found locally then find remotely
var bodyParser = require("body-parser");
var person = require("./routes/person");

// Specify the public folder is the default folder of the frontend files
// In node.js, it has two constant: __dirname:current dir of the current folder, __filename

var app = express();


var bodyParser = require('body-parser');



app.use(express.static(__dirname + "/public"));
app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());
app.use("/rest/person", person);



app.get("/:filename", function(req, resp){
	var filename = req.params.filename;
	resp.sendFile(__dirname + "/public/" + filename + ".html");
});

app.listen(5000);
console.log("The server is started");