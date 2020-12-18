package com.ifma.livraria_api.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.ifma.livraria_api.models.Livro;
import com.ifma.livraria_api.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Transactional
    public Livro salva(Livro Livro) {
        return this.livroRepository.save(Livro);
    }

    public Iterable<Livro> todos() {
        return livroRepository.findAll();
    }

    public Iterable<Livro> buscarPor(String nome) {
        return livroRepository.findByNomeLivroContaining(nome);
    }

    public Optional<Livro> buscarPor(Long id) {
        return livroRepository.findById(id);
    }

    @Transactional
    public void removePelo(Long id) {
        livroRepository.deleteById(id);
    }

    public Page<Livro> buscarPor(String nome, Pageable paginacao) {
        return livroRepository.findByNomeLivroContaining(nome, paginacao);
    }

    public Page<Livro> buscaCom(Pageable paginacao) {
        return livroRepository.findAll(paginacao);
    }

}
