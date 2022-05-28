//----conexao com o banco de dados
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

//Funcao na tentativa de atender o pedido de recolhimento/mostragem das informações de voo de acordo com a escolha do usuario (metodo switch) passagem e cliente, conforme pedido nos itens 4, 5, 6 e 7..mas sem exito
function Comandos (event, callback) {
switch (event.function) {
    case 'assentosDisponiveis':
      listaVooAssentosLivres(event,callback);
      break;
      
    case 'passagemCliente':
      passagensPorCliente(event, callback);
      break;
      
    case 'passagemVoo':
      passagensPorVoo(event, callback);
      break;
    
    default:
      callback(null, "{'status':400,'error':'function name not match'}")
  }
};


  function listaVooAssentosLivres(event, callback){
    const sql = "select * from voo where assentos > 0;";
    mysqlConnection.query(sql, (err, res) => {
      if (err) {
        throw err
      }
      callback(null, res);
    });
  }
  
  function passagensPorCliente(event, callback){
    const sql = "select * from passagem where cliente_id = "+event.targetId;
    mysqlConnection.query(sql, (err, res) => {
      if (err) {
        throw err
      }
      callback(null, res);
    });
  }
  
  function passagensPorVoo(event, callback){
    const sql = "select * from passagem where voo_id = "+event.targetId;
    mysqlConnection.query(sql, (err, res) => {
      if (err) {
        throw err
      }
      callback(null, res);
    });
  }