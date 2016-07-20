var express = require('express')
  , routes = require('./routes')
  , user = require('./routes/user')
  , http = require('http')
  , path = require('path');

var xml = require('xml');
var Client = require('node-rest-client').Client;
var client = new Client();

var app = express();

// all environments
app.set('port', process.env.PORT || 3000);
app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(app.router);
app.use(express.static(path.join(__dirname, 'public')));

// development only
if ('development' == app.get('env')) {
  app.use(express.errorHandler());
}

app.get('/', routes.index);
app.get('/users', user.list);


app.get("/user", function(req, res){
	client.get("http://localhost:8080/greeting", function(data, response){
		//console.log(data);
		console.log("Request Message : "+res.statusCode);
		console.log(data);
		//res.set('Content-Type', 'application/xml');
		res.send(data);
	});
});
app.get("/persons", function(req, res){
	client.get("http://localhost:8080/person", function(data, response){
		console.log(data);
		res.json(data);
	});
});
app.get("/persons/11", function(req, res){
	client.get("http://localhost:8080/person/11", function(data, response){
		console.log(data);
		res.json(data);
	});
});

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});




/*var args = {
data: { test: "hello" },
headers: { "Content-Type": "application/xml" }
};*/

/*client.registerMethod("xmlMethod", "http://localhost:8080/greeting", "GET");

client.methods.xmlMethod(function (data, response) {
// parsed response body as js object 
console.log(data);
// raw response 
console.log(response);
});*/
