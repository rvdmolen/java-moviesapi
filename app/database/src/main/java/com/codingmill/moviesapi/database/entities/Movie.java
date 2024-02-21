package com.codingmill.moviesapi.database.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "Movies")
public class Movie {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)

    @Id
    @UuidGenerator
    @Column(length = 36, nullable = false, updatable = false)
    public String movieId;

    public String name;
}
