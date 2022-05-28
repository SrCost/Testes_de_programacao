//---Conexao com o banco de dados e teste
const mysql = require('mysql');
const express = require('express');
var app = express();
const bodyparser = require('body-parser');

app.use(bodyparser.json());

const mysqlConnection = mysql.createConnection({
    host:'localhost',
    user:'root',
    password: 'root',
    database: 'db_companhiaaerea'
});

mysqlConnection.connect((err) => {
 if(!err)
 console.log('DB connection succeded.');
 else
 console.log('DB connetion failed \n Error : ' + JSON.stringify(err, undefined, 2));
});

app.listen(3000), ()=> console.log('Express server is running at port no : 3000');

/*app.get('/clientes',(res,req) => {
  mysqlConnection.query('SELECT * FROM clientes',(err, rows, fields) =>{
    if(!err)
    console.log(rows);
    else console.log(err);
  })
});*/