# Teste prático
Repositório contendo o código fonte do desafio da NOVA XS - Criação de pokedex utilizando Java puro e conexao com banco de dados.


##### Pokedex - Tecnologias
*	JDK 8 ou superior;
*	Editor de texto ou IDE de sua preferência; --> Eclipse
*	Banco de dados a sua escolha (SQL ou NoSql); --> MySQL
*	Plugin MySQL


###### Rodar Localmente
  -Realizar o fork entao baixar a pasta com todas as dependencias. Ao abrir a IDE, busque o projeto. 
  
  Descrição dos pacotes para realização do CRUD utilizando apenas logica.
  
  *pokedex.dao
  -Classe responsavel por todo o processamento de dados com conexão ao banco e procedimento de C.R.U.D.
  
  *pokedex.factory
  -Classe responsavel pela conexão com o banco de dados, fazendo uso do referido plugin.
  
  *pokedex.model
  -Classe com toda assimilação de informação para com uso da pokedex na aplicação.
  
  *pokedex.aplication
  -Classe PRINCIPAL para uso da aplicação e efeito/manipulação das informação junto ao banco de dados.
   
   
### Como utilizar a aplicação

Ao executar a classe principal, antes se faz necessario comentar -//- as funções que não serão necessarias, pois pode dar conflito ja que aplicação realiza uma função
por vez. Assim para o metodo de CREATE, a informação será inserida conforme exemplo ja preenchido. O mesmo se aplica para os outros metodos, pois esta será a unica classe que será usada para as funções.

*A Aplicação possui comentarios em algumas linhas para melhor interpretação da logica.

```
RESSALTO que a instrução foi que fosse utilizado apenas JAVA puro, contradizendo o template do desafio, que solicita uma API RES com retorno JSON junto com o banco de dados (Exemplo utilizado em desafio Pamcary)


*Os arquivos de Plugin MySQL e Database ja se encontram na pasta para facilitar os testes.


