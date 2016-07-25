var express = require('express')
  , routes = require('./routes')
  , user = require('./routes/user')
  , http = require('http')
  , path = require('path');

var xml = require('xml');
var bodyParser = require('body-parser');
var Client = require('node-rest-client').Client;
var client = new Client();
//var argv = require('minimist')(process.argv.slice(2));
var swagger = require('swagger-node-express');
var app = express();
//var subpath = express();

//app.use('/v1', subpath);
//swagger.setAppHandler(subpath);

app.use(express.static('dist'));
// all environments
app.set('port', process.env.PORT || 3000);
app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(app.router);
app.use(bodyParser());

app.use(express.static(path.join(__dirname, 'public')));

/*swagger.setApiInfo({
	title : 'Driver Connectivity',
	description : "This App is used to capture the driver actions.",
	termsOfServiceUrl : "",
	contact : "avishwakarma@deloitte.com",
	license : "Deloitte.",
	licenseUrl : ""
});*/
// development only
if ('development' == app.get('env')) {
  app.use(express.errorHandler());
}

//app.get('/', routes.index);
app.get('/users', user.list);

//---------------------------------------------------
app.get("/", function(req, res){
	res.sendFile(__dirname +'/dist/index.html');
});

/*swagger.configureSwaggerPaths('','api-docs','');

var domain = 'localhost';

if(argv.domain !== undefined){
    domain = argv.domain;
}else{
    console.log("No domain specified!\n'localhost' will be used as default domain");
}

var port = app.get('port');

if(argv.port !== undefined){
    port = argv.port;
}else{
    console.log("No port specified!\n'port "+port+" will be used as default port'");
}

var applicationUrl = "http://" + domain + ":" + port;

console.log("SnapJob is running on Url : "+applicationUrl);

swagger.configure(applicationUrl, '1.0.0');*/

var port = app.get('port');

app.listen(port, function(){
    console.log('Express server listening on port ' + app.get('port'));
});

//------------------------------------------------------
app.get("/user", function(req, res){
	handleError(req);
	
	client.get("http://localhost:8080/greeting", function(data, response){
		//console.log(data);
		console.log("Request Message : "+res.statusCode);
		console.log(data);
		//res.set('Content-Type', 'application/xml');
		res.send(data);
	});
});
app.get("/persons", function(req, res){
	
	handleError(req);
	
	client.get("http://localhost:8080/person", function(data, response){
		console.log(data);
		res.json(data);
	});
});
app.get("/persons/11", function(req, res){
	
	handleError(req);
	
	client.get("http://localhost:8080/person/11", function(data, response){
		console.log(data);
		res.json(data);
	});
});

function handleError(req){
	req.on("error", function(e) {
		console.log("Error Occured... "+e);
	})
}
/*
http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
*/




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
