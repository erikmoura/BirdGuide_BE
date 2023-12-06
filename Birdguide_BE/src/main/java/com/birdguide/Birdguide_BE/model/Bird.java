package com.birdguide.Birdguide_BE.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String nome;

    private String local;

    @Lob // super large string
    private String description;


    



}
