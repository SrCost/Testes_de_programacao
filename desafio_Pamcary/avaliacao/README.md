# Teste prático
Repositório contendo o código fonte do desafio da empresa GPS Pamcary

#### Autor

- [arthurpsena](https://github.com/arthurpsena/avaliacao)


##### Pessoas - GPS Pamcary
API Rest, documentada utilizando o Swagger e 3 testes unitários.

*	Encaminhar o link do seu repositório do Github
*	Explicação de como rodar localmente e também como seria possível realizar o deploy.
*	Testes (Pelo menos 60% de cobertura)
*	Legibilidade
*	Escalabilidade
*	Commits pequenos
*	Ver sua experiência codificando
*	CLEAN CODE
*	Keep it simple =]

###### Rodar Localmente
  -Realizar o fork entao baixar a pasta com todas as dependencias. Executar o spring e acessar o endereço na classe da principal da aplicação
  Obs:O arquivo de banco de dados se encontra na pasta resources, mas o caso nao encontre o programa criara um db novo
       
###### Tecnologias

* Java
* MySQL SQL (arquivo dataBase esta na pasta Resource)
* Spring Boot
* Swagger

### Endereco Controller - http://localhost:8080/swagger-ui/index.html

|Rest | URL |Função |
------ | ------- | ------- |
PUT   | /pessoas | Alteração de informacao da pessoa |
GET   | /nome/{nome} | Busca de pessoa por nome |
GET   | /{id} | Busca de pessoa por id |
GET   | /cpf/{cpf} | Busca de pessoa por cpf |
DELETE   | /{id} | Deletar registro pelo id |

###### Apresentação

1. Cadastro de pessoa
2. Busca de registro
3. Alteração de registro 
4. Exclusão de registro

###### JSON - Cadastros

* Cadastrando Pessoa - 01

```
{
  "id": 0,
  "registraData": "2022-05-28T01:47:59.570Z",
  "nome": "Marivalda de Jesus",
  "cpf": "15689674556",
  "dataNascimento": "2056-05-28"
}
```
* Cadastrando Pessoa - 02

```
{
  "id": 0,
  "registraData": "2022-05-28T01:47:59.570Z",
  "nome": "Rogerio Aparecido joaquim medeiros",
  "cpf": "156.458.789-64",
  "dataNascimento": "2095-09-08"
}
}

```
###### Buscando - Todos

[
  {
    "id": 1,
    "registraData": null,
    "nome": "Jose Arquimedes",
    "cpf": "15523657000",
    "dataNascimento": "1966-02-23"
  },
  {
    "id": 2,
    "registraData": "2022-05-28T00:35:12.926+00:00",
    "nome": "Flavio Augusto da Costa",
    "cpf": "12345678989",
    "dataNascimento": null
  },
  {
    "id": 4,
    "registraData": "2022-05-28T01:47:59.570+00:00",
    "nome": "Marivalda de Jesus",
    "cpf": "15689674556",
    "dataNascimento": "2056-05-28"
  },
  {
    "id": 5,
    "registraData": "2022-05-28T01:47:59.570+00:00",
    "nome": "Rogerio Aparecido joaquim medeiros",
    "cpf": "156.458.789-64",
    "dataNascimento": "2095-09-08"
  }
]
```
###### Buscando - por CPF

{
  "id": 2,
  "registraData": "2022-05-28T00:35:12.926+00:00",
  "nome": "Flavio Augusto da Costa",
  "cpf": "12345678989",
  "dataNascimento": null
}
```
###### Alterando 

* Alterando o registro

```
{
  "id": 2,
  "registraData": "2022-05-28T00:35:12.926+00:00",
  "nome": "Flavio A. Costa",
  "cpf": "123.456.789-89",
  "dataNascimento": "1995-09-19"
}

```
###### Deletando 

```

