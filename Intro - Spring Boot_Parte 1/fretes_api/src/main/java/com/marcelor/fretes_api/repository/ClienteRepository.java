package com.marcelor.fretes_api.repository;

//The query builder mechanism built into the Spring Data repository infrastructure is useful for building constraining queries over entities of the repository. The mechanism strips the find…By, read…By, query…By, count…By, and get…By prefixes from the method and starts parsing the rest of it. 
import com.marcelor.fretes_api.model.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	Iterable<Cliente> findByNomeContaining(String nome);

    
    
    
}
