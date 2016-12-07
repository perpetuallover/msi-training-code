// Use express.js to create a server
// Jquery is the selector based technology: can select tag, class, id
var express = require("express");//found in the node_moudles: if not found locally then find remotely

// Specify the public folder is the default folder of the frontend files
// In node.js, it has two constant: __dirname:current dir of the current folder, __filename

var app = express();
var cal = require("./routes/cal");
var bodyParser = require('body-parser');

console.log(__dirname);
console.log(__filename);
app.use(express.static(__dirname + "/public"));
app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());


app.use("/rest/cal", cal);
app.get("/", function(req, res){
	console.log("11");
	res.end("Hello World");
});
//routing system
// app.get("/peter", function(req,resp){
// 	resp.end("<h1>Hello Peter</h1>")
// });


// app.get("/:name", function(req, resp){
// 	var name = req.params.name;
// 	resp.end("<h1> Hello " + name + "</h1>");
// });

app.get("/:filename", function(req, resp){
	var filename = req.params.filename;
	resp.sendFile(__dirname + "/public/" + filename + ".html");

});

app.listen(3000);
console.log("The server is started");