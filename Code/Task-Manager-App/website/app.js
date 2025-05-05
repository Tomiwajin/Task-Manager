//setup express to handle routing and rendering
var express = require('express');
var app = express();
app.set('view engine', 'ejs');

//setup bodyparser to extra data from form posts
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true })); 

// route to index page
app.get('/', function(req, res) {
    res.render('page/index');
});

// route to about page
app.get('/downlad', function(req, res) {
	res.render('page/download');
});

//start the web app
app.listen(8080, function () {
	console.log('App listening on port 8080!');
});

