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
    database: 'db_companhiaaerea',
    multipleStatements: true
});


//Logica para adionar voo vinculados aos assentos, atendendo o item 1.
function adicionarVoo(event, callback){
    var tabelas = "saida, chegada, origem, destino, quantAssento, preco";
    
    const quantAssent = event.quantidadeColuna * event.quantidadeFileira;
    
    var dadosDoVoo = "'"+event.saida+"','"+event.chegada+"','"+event.origem+"','"+event.destino+"',"+quantAssento+","+event.preco;
    const sql = "insert into voo ("+tabelas+") values ("+dadosDoVoo+");";
    
    var vooID = 0;
    
    mysqlConnection.query(sql, (err, res) => {
      if (err) {
        throw err
      }
      vooID = res.insertId;
      adicionarAssentos(vooID, event, callback);
    });
  }
  
  function adicionarAssentos(vooID, event, callback){
      var sqlValues = "VALUES ";
      var assentoTable = "voo_id";
      
      for (var i = 0; i < event.quantidadeColuna; i++){
        var letraColuna = String.fromCharCode(97 + i);
          for (var j = 1; j <= event.quantidadeFileira; j++){
            sqlValues += "("+vooID+",'"+letraColuna+j+"'),";
          }
      }
      sqlValues = sqlValues.slice(0,-1);
      
      
      const sqlAssentos = "insert into assento ("+assentoTable+") "+sqlValues+";";
      
      mysqlConnection.query(sqlAssentos, (err, res) => {
        if (err) {
          throw err
        }
        var resultReturn = "{ 'status':'ok', 'id': "+vooID+" }";
        callback(null, resultReturn, callback);
      });
  }
  
  //estrutura das rotas, da qual a funçao put/post foram usados procedimentos armazenados (Stored Procedures) para validação, controle e execução das declarações com o banco de dados.
  app.get('/addvoo/:id', (req,res) => {
    mysqlConnection.query('SELECT * FROM clientes where id ?' ,[req.params.id],(err,rows,fields)=> {
      if(!err)
      res.send(rows);
      else
      console.log(err);
    })
  });

  app.delete('/addvoo/:id', (req,res) => {
    mysqlConnection.query('DELETE FROM clientes where id ?' ,[req.params.id],(err,rows,fields)=> {
      if(!err)
      res.send('Deleted successfully');
      else
      console.log(err);
    })
  });

  app.post('/addvoo', (req,res) => {
    let emp = req.body;
    var sql = "SET @id = ?; SET @saida = ?; SET @chegada = ?; SET @origem = ?; SET @destino = ?; SET @quantAssento = ?; SET @preco = ?; \
    CALL vooAddOrEdit (@id,@saida,@chegada,@origem,@destino,@quantAssento,@preco);";
    mysqlConnection.query(sql, [emp.empid, emp.saida, emp.chegada, emp.origem, emp.destino, emp.quantAssento, emp.preco] ,[req.params.id],(err,rows,fields)=> {
      if(!err)
        rows.forEach(element => {
          if(element.construtor == Array)
          res.send('Inserted voo id : '+element[0].empid);
        });
          else
      console.log(err);
    })
  });

  app.put('/addvoo', (req,res) => {
    let emp = req.body;
    var sql = "SET @id = ?; SET @saida = ?; SET @chegada = ?; SET @origem = ?; SET @destino = ?; SET @quantAssento = ?; SET @preco = ?; \
    CALL vooAddOrEdit (@id,@saida,@chegada,@origem,@destino,@quantAssento,@preco);";
    mysqlConnection.query(sql, [emp.empid, emp.saida, emp.chegada, emp.origem, emp.destino, emp.quantAssento, emp.preco] ,[req.params.id],(err,rows,fields)=> {
      if(!err)
        res.send('Updated successfully');
          else
      console.log(err);
    })
  });

//Porta local de acesso 
  app.listen(8081, function(){console.log("servidor rodando");});