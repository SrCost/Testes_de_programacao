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


//funcao para compra de passagem e atualização da quantidade de assentos em determinado voo, atendendo o item 3
function comprarPassagem(event, callback){
    adicionarPassagem(event,callback);
    /*
    atualizarAssentos(event,callback);
    atualizarAssentoslivres(event,callback);
    returnResponse(callback);
    */
  }
  
  function adicionarPassagem(event, callback){
    var d = new Date, dformat = [d.getFullYear(),d.getMonth()+1,d.getDate()].join('-')+' '+[d.getHours(),d.getMinutes(),d.getSeconds()].join(':');
    var tabelas = "voo_id, assento, passageiro, cliente_id, data_compra";
    var sqlValues = "VALUES ";
    for (var i = 0; i < event.assentos.length; i++){
      sqlValues += "("+event.voo_id+",'"+event.assentos[i]+"','"+event.passageiro[i]+"',"+event.cliente_id+",'"+dformat+"'),";
    }
    sqlValues = sqlValues.slice(0, -1);
    
    const sql = "INSERT INTO passagem ("+tabelas+") "+sqlValues;
    mysqlConnection.query(sql, (err, res) => {
      if (err) {
        throw err;
      }
      resultReturn = "{ 'status':'ok', 'id': [";
      for (var i = 0; i < res.affectedRows; i++) {
        resultReturn += (res.insertId-i) + "," ;
      }
      resultReturn = resultReturn.slice(0,-1);
      resultReturn += "]}";
      //callback(null,resultReturn);
      atualizarAssentos(event,callback);
    });
  }


  // funcao de atualização dos assentos relacionando com o banco de dados e subtração com as informações ja colhetadas na tabela -voo-
  function atualizarAssentos(event,callback){
    var sqlUpdate = "UPDATE ";
    var sqlUpdateOn = "ON ";
    var sqlUpdateSet = "SET ";
    
    for (var i = 0; i < event.assentos.length; i++){
      sqlUpdate += "assento "+event.assentos[i]+" join ";
      sqlUpdateOn += event.assentos[i]+".colunaFileira = '"+event.assentos[i]+"' and "+event.assentos[i]+".voo_id = "+event.voo_id+" and ";
      sqlUpdateSet += event.assentos[i]+".passageiro='"+event.passageiro[i]+"', "+event.assentos[i]+".cliente_id="+event.cliente_id+", ";
    }
    sqlUpdate = sqlUpdate.slice(0, -5);
    sqlUpdateOn = sqlUpdateOn.slice(0, -4);
    sqlUpdateSet = sqlUpdateSet.slice(0, -2);
    
    var sqlUpdateQuery = sqlUpdate + sqlUpdateOn + sqlUpdateSet;
  
    mysqlConnection.query(sqlUpdateQuery, (err, res) => {
      if (err) {
        throw err;
      }
      atualizarAssentoslivres(event,callback);
    });
  }
  
  function atualizarAssentoslivres(event,callback){
    
    var sqlUpdate = "UPDATE voo set assentos = ((SELECT abs(quantAssento) where id = "+event.voo_id+") - (SELECT COUNT(id) from passagem where voo_id = "+event.voo_id+")) where id = "+event.voo_id;
    mysqlConnection.query(sqlUpdate, (err, res) => {
      if (err) {
        throw err;
      }
      returnResponse(callback);
    });
  }
  
  function returnResponse(callback){
    callback(null, resultReturn);
  }

  //estrutura de rotas
  app.post('/buypass', (req,res) => {
    mysqlConnection.query('SELECT * FROM passagem where id ?' ,[req.params.id],(err,rows,fields)=> {
      if(!err)
      res.send(rows);
      else
      console.log(err);
    })
  });

  app.get('/buypass/:id', (req,res) => {
    mysqlConnection.query('SELECT * FROM passagem where id ?' ,[req.params.id],(err,rows,fields)=> {
      if(!err)
      res.send(rows);
      else
      console.log(err);
    })
  });

  //Porta local de acesso
  app.listen(8081, function(){console.log("servidor rodando");});
  