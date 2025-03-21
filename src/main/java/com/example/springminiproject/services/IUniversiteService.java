package com.example.springminiproject.services;

import com.example.springminiproject.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);

    public Universite findByNomUniversite(String nom);

    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite);
    public Universite desaffecterFoyerAUniversite (long idUniversite) ;
}
