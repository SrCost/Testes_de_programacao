//-------> Conexao com o banco de dados
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


//função para cadastro de clientes relacinando com o banco de dados atendendo o item 2.
function cadastrarCliente(event, callback){
    var tabelas = "nome";
    var sqlValues = "VALUES ";
    for (var i = 0; i < event.nome.length; i++){
      sqlValues += "('"+event.nome[i]+"'),";
    }
    sqlValues = sqlValues.slice(0, -1);
    const sql = "INSERT INTO clientes ("+tabelas+") "+sqlValues;
    
    mysqlConnection.query(sql, (err, res) => {
      if (err) {
        throw err;
      }
      var resultReturn = "{ 'status':'ok', 'id': [";
      for (var i = 0; i < res.affectedRows; i++) {
        resultReturn += (res.insertId-i) + "," ;
      }
      resultReturn = resultReturn.slice(0,-1);
      resultReturn += "]}";
      callback(null, resultReturn);
    });
  }


  //estrutura das rotas.
  app.post('/adduser/:id', (req,res) => {
    mysqlConnection.query('SELECT * FROM clientes where id ?' ,[req.params.id],(err,rows,fields)=> {
      if(!err)
      res.send(rows);
      else
      console.log(err);
    })
  });

  app.get('/adduser/:id', (req,res) => {
    mysqlConnection.query('SELECT * FROM clientes where id ?' ,[req.params.id],(err,rows,fields)=> {
      if(!err)
      res.send(rows);
      else
      console.log(err);
    })
  });


  //Porta local de acesso
  app.listen(8081, function(){console.log("servidor rodando");});