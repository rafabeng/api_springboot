/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api_springboot.Repository;

import com.example.api_springboot.Entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rafael Barro
 */
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

    public Iterable<Pessoa> findAllById(Long id);
}
