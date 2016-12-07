// Use express.js to create a server
// Jquery is the selector based technology: can select tag, class, id
var express = require("express");//found in the node_moudles: if not found locally then find remotely
var bodyParser = require("body-parser");

// Specify the public folder is the default folder of the frontend files
// In node.js, it has two constant: __dirname:current dir of the current folder, __filename

var app = express();
var es = require("./routes/empservice")

app.use(express.static(__dirname + "/public"));
app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());
app.use("/rest/es", es);

app.get("/", function(req, resp){
	var filename = req.params.filename;
	resp.sendFile(__dirname + "/public/" + "main.html");
});

app.listen(3000);
console.log("The server is started");