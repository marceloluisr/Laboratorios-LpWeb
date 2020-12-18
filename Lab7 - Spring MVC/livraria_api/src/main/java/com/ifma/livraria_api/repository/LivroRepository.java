package com.ifma.livraria_api.repository;

import com.ifma.livraria_api.models.Livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long>  {
    Iterable<Livro> findByNomeLivroContaining(String nome);    
}
