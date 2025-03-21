package com.example.springminiproject.services;

import com.example.springminiproject.entities.Foyer;
import com.example.springminiproject.entities.Universite;
import com.example.springminiproject.repositories.IFoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface IServiceFoyer {

   public Foyer findByidFoyer(long id);
   public List<Foyer> findAll();
   public Foyer save(Foyer foyer);
   public void delete(Long id);
   public Foyer updateFoyer (Foyer f);

   public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);







}
