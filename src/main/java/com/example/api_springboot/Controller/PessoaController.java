/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api_springboot.Controller;

import com.example.api_springboot.Entity.Pessoa;
import com.example.api_springboot.Repository.PessoaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Rafael Barro
 */
@RestController

public class PessoaController{

    @Autowired
    private PessoaRepository repository;

    //LISTAR TODOS OS REGISTROS 
    @RequestMapping(path = "/pessoas")
    public Iterable<Pessoa> listar() {
            return repository.findAll();
    }
    //BUSCA POR ID
    @RequestMapping(path = "/pessoas/{id}")
    public Iterable<Pessoa> getId(@PathVariable(value = "id") Long id) {
            return repository.findAllById(id);
    }
    
    
}

