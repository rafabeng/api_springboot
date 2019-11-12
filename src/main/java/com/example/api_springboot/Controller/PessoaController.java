/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api_springboot.Controller;

import com.example.api_springboot.Entity.Pessoa;
import com.example.api_springboot.Repository.PessoaRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael Barro
 */
@RestController

public class PessoaController{

    @Autowired
    private PessoaRepository repository;
    
    @RequestMapping(path = "/")
    public String index(){
        return "API DE TESTE";
                
    } 

    //LISTAR TODOS OS REGISTROS 
    @RequestMapping(path = "/pessoas", method = RequestMethod.GET)
    public Iterable<Pessoa> listar() {
            return repository.findAll();
    }
    //BUSCAR REGISTRO POR ID
    @RequestMapping(path = "/pessoas/{id}", method = RequestMethod.GET)
    public Iterable<Pessoa> getId(@PathVariable(value = "id") Long id) {
            return repository.findAllById(id);
    }
    
    //DELETAR REGISTRO POR ID
    @RequestMapping(path = "/pessoas/deletar/{id}", method = RequestMethod.DELETE)
     public void DeleteId(@PathVariable(value = "id") Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    
    }
     
    //INSERIR REGISTRO POR ID
    @RequestMapping(path = "/pessoas/inserir", method = RequestMethod.POST)
     public void InserirId(@Valid Pessoa pessoa) {
        if (!repository.existsById(pessoa.getId())) {
            repository.save(pessoa);
        }
    
    } 
    
    //ALTERAR REGISTRO POR ID
    @RequestMapping(path = "/pessoas/alterar", method = RequestMethod.PUT)
     public void AlterarId(@Valid Pessoa pessoa) {
       if (repository.existsById(pessoa.getId())) {
            repository.save(pessoa);
       }  
    
    }
     
    //CONTAR REGISTROS 
    @RequestMapping(path = "/pessoas/quantidade", method = RequestMethod.GET)
    public long Quantidade() {
            return  repository.count();
    }  
     
}

