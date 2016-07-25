var request = require('request');

var base_url = "http://localhost:3000";

describe("Person GET server", function(){
	
	describe("Test GET Server", function(){
		
		/*beforeEach(function(){
			nock('https://en.wikipedia.org')
			.get('/wiki/Abraham_Lincoln')
			.reply(200, "Mock Abraham Lincoln Page");
		});*/
		
		it("Return Status code 200", function(done){
			
			request.get(base_url, function(err, res, body){
				expect(res.statusCode).toBe(200);
				done();
			});
		});
		
		it("Return Status code 200 for /persons/11 URL", function(done){
			request.get(base_url+"/persons/11", function(err, res, body){
				expect(res.statusCode).toBe(200);
				done();
			});
		});
		
		it("Return JSON reponse for person from /persons/11 URL", function(done){
			request.get(base_url+"/persons/11", function(err, res, body){
				var jsonObj = JSON.parse(body);
				console.log(jsonObj);
				expect(jsonObj).toMatch(/[\s]+/);
				expect(jsonObj.length).toBeUndefined();
				done();
			});
		});
		
	});
});