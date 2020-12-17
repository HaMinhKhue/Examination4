package com.codegym.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;

    public Country() {
    }

    public Country(String country) {
        this.country = country;
    }

    public Country(Long id, String country) {
        this.id = id;
        this.country = country;
    }
}
