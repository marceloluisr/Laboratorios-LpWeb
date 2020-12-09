const mysql = require('mysql');
const express = require('express');
const bodyparser = require('body-parser');

var app = express();
app.use(bodyparser.json());

var conn = mysql.createConnection({
    'host':'localhost',
    'user':'root',
    'password':'root',
    'database':'livraria'
});

conn.connect((err) => {
    if (!err) {
        console.log("Conexão com o database sucedida!");
    } else {
        console.log("Falha na conexão com o database. \n Erro: " + JSON.stringify(err, undefined, 2));
    }
});



app.listen(3000,() => console.log("Servidor express executando na porta 3000."));

// >> 1) Create
app.post('/livros', (req, res) => {
    livro = req.body;

    conn.query('insert into livro(nome, editora, autor, ano_pub, assunto) values(?,?,?,?,?)',
    [livro.nome, livro.editora, livro.autor, livro.ano_pub, livro.assunto], 
    (err, rows, fields) => {
        if(!err){
            res.send('Livro inserido com sucesso.');
        } else {
            console.log(JSON.stringify(err));
        }
    }) 
});

// >> 2) Read 

// 2.1) Get todos os livros
app.get('/livros', (req, res) => {
    conn.query('select * from livro', (err, rows, fields) => {
        if(!err){
            //console.log(rows[0].nome);
            res.send(rows);
        } else {
            console.log(JSON.stringify(err));
        }
    }) 
});

// 2.2) Get todos os livros por 'id'
app.get('/livros/:id', (req, res) => {
    conn.query('select * from livro where id = ?',[req.params.id], (err, rows, fields) => {
        if(!err){
            //console.log(rows[0].nome);
            res.send(rows);
        } else {
            console.log(JSON.stringify(err));
        }
    }) 
});

// >> 3) Update

app.put('/livros', (req, res) => {
    livro = req.body;

    conn.query('update livro set id = ?, nome = ?, editora = = ?, autor = ?, ano_pub = ?, assunto = ? where id = ?',
    [livro.id, livro.nome, livro.editora, livro.autor, livro.ano_pub, livro.assunto, livro.id], 
    (err, rows, fields) => {
        if(!err){
            res.send('Livro alterado com sucesso.');
        } else {
            console.log(JSON.stringify(err));
        }
    }) 
});

// >> 4) Delete

// 4.1) Delete por nome do livro
app.delete('/livros/:nome', (req, res) => {
    conn.query('delete from livro where nome = ?',[req.params.nome], (err, rows, fields) => {
        if(!err){
            res.send('Livro apagado.');
        } else {
            console.log(JSON.stringify(err));
        }
    }) 
});



