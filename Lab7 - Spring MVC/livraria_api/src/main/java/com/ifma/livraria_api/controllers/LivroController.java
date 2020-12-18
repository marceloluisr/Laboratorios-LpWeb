package com.ifma.livraria_api.controllers;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import com.ifma.livraria_api.models.Livro;
import com.ifma.livraria_api.services.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
/*
TODO Professor, para facilitar o CRUD de dados através do Postman. 
     Segue o JSON do corpo da rquisição:
{
    "isbn": "<digite algo>",
    "nomeLivro":"<digite algo>",
    "editoraLivro":"<digite algo>",
    "anoPublicacaoLivro":"<digite algo>",
    "assunto":"<digite algo>"
}
*/

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> cadastro(@RequestBody @Valid Livro Livro, UriComponentsBuilder builder) {
        final Livro livroSalvo = livroService.salva(Livro);

        final URI uri = builder.path("/livros/{id}").buildAndExpand(livroSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(livroSalvo);
    }

    @GetMapping
    public Page<Livro> lista(@RequestParam(required = false) String nome,
            @PageableDefault(sort = "nomeLivro", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao) {
        if (nome == null) {
            return livroService.buscaCom(paginacao);
        } else {
            return livroService.buscarPor(nome, paginacao);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscaPor(@PathVariable Long id) {
        Optional<Livro> optional = livroService.buscarPor(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get()); // retorna codigo 200
        } else {
            return ResponseEntity.notFound().build(); // retorna codigo 400
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualiza(@RequestBody Livro Livro, @PathVariable Long id) {
        Optional<Livro> optional = livroService.buscarPor(id);
        if (optional.isPresent()) {
            Livro.setId(id);
            Livro LivroAtualizado = livroService.salva(Livro);
            return ResponseEntity.ok(LivroAtualizado); // retorna codigo 200
        } else {
            return ResponseEntity.notFound().build(); // retorna codigo 400
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Livro> optional = livroService.buscarPor(id);

        if (optional.isPresent()) {
            livroService.removePelo(id);
            return ResponseEntity.noContent().build(); // retorna codigo 204
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
