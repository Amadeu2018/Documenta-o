package com.bullesoft.utilizador.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "utilizadores")
@Data
public class Utilizador {

    public Utilizador(String nome, String sobreNome, String email) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long    id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobre_nome")
    private String sobreNome;

    @Column(name = "email")
    private String email;

    public Utilizador() {
    }


}
