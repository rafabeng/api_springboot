/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api_springboot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Rafael Barro
 */

@Entity(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nome;


    public Long getId() {
            return id;
    }

    public void setId(final Long id) {
            this.id = id;
    }

    public String getNome() {
            return nome;
    }

    public void setNome(final String nome) {
            this.nome = nome;
    }

}
    

