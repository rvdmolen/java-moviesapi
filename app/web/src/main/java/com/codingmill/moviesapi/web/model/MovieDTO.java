package com.codingmill.moviesapi.web.model;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record MovieDTO(String id, String name) {

    public ResponseEntity<MovieDTO> toResponseEntity() {
        return ResponseEntity.status(HttpStatus.OK).body(this);
    }
}
