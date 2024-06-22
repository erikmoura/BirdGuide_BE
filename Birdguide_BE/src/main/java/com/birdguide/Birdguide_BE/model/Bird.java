package com.birdguide.Birdguide_BE.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "birds")
@Entity
@Getter
@Setter
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String nome;

    private String local;

    @Lob // super large string
    private String description;

    public Bird(){
    }

    public Bird(String nome, String local, String description) {
        this.nome = nome;
        this.local = local;
        this.description = description;
    }
}
