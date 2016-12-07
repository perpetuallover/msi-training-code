// Basic way to create a server
var http = require("http");
http.createServer(function(req,resp){
	//resp.setHeader(200, {"Content-Type" : "text/html"});
	resp.end("<h1>Hello World</h1>");
}).listen(3000);
console.log("The server started!");