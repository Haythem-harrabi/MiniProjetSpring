package com.example.springminiproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Foyer implements Serializable {
    @Id
    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;

    @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;
    @OneToOne(mappedBy = "foyer")
    private Universite universite;
}
