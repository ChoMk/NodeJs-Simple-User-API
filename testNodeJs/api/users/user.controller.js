var mysql = require('mysql');
var dbconfig = require('../../config/database');
var connection = mysql.createConnection(dbconfig);
var uuid = require('uuid');

exports.index = (req, res) => {

  connection.query('SELECT * from Persons', function (err, rows) {
    if (err) throw err;
    return res.json(rows);
  });
};

exports.show = (req, res) => {
  const id = req.params.id;
  if (id.length === 0) {
    return res.status(400).json({ error: 'Incorrect id' });
  }
  console.log(id);
  connection.query('SELECT * FROM Persons WHERE id = ?', id, function (err, rows) {
    if (err) throw err;
    console.log(rows);
    
    if(rows.length !== 0)
      return res.json(rows[0]);
    return res.json("fail");
  });

};

exports.destroy = (req, res) => {
  const id = req.params.id;
  if (id.length ===0) {
    return res.json("not id");
  }
  connection.query('SELECT * FROM Persons WHERE id = ?', id.toString(), function (err, rows) {
    if (rows.length !== 0) {

      connection.query('DELETE FROM Persons WHERE id = ?', id.toString(), function (err, rows) {
        if (err) throw err;
        console.log("Number of records deleted: " + rows.affectedRows);
        res.json("success");
      });
    } else {
      return res.json("fail");
    }

  })


};

exports.create = (req, res) => {
  const id = req.body.id;
  const name = req.body.name;
  const age = req.body.age;
  console.log(age);
  console.log(name);
  if (id.length === 0 || name.length === 0 || age.length === 0) {
    return res.status(400).json({ error: 'Incorrenct data' });
  }
  connection.query('SELECT * FROM Persons WHERE id = ?', id, function (err, rows) {
    if (rows.length === 0) {
      console.log(rows.length);
      connection.query('INSERT INTO Persons (id, name, age) VALUES (?, ?, ?)', [id, name, age], function (err, rows) {
        if (err) throw err;
        console.log("insert");
        return res.json("success");
      });
    } else {
      return res.json("fail");
    }

  })

};
