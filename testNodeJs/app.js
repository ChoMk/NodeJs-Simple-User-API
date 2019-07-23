const express = require('express');
const app = express();


var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));


app.get('/', (req, res) => {
  res.send('Hello World!\n');
});

app.listen(3000, () => {
  console.log('Example app listening on port1!');

});
app.use('/users', require('./api/users/index'));
module.exports = app//테스트를 위하여 이렇게 만들어주자...