package com.example.springminiproject.services;

import com.example.springminiproject.entities.Foyer;
import com.example.springminiproject.entities.Reservation;
import com.example.springminiproject.entities.Universite;
import com.example.springminiproject.repositories.IFoyerRepository;
import com.example.springminiproject.repositories.IReservationRepository;
import com.example.springminiproject.repositories.IUniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceUniversite implements  IUniversiteService {

    @Autowired
    private IUniversiteRepository UniversiteRepo;
    @Autowired
    private IFoyerRepository FoyerRepo;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return UniversiteRepo.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return UniversiteRepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        Universite uni = UniversiteRepo.findByIdUniversite(u.getIdUniversite());
        if (uni != null) {
            return UniversiteRepo.save(u);
        }
        return null;
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return UniversiteRepo.findByIdUniversite(idUniversite);
    }

    @Override
    public Universite findByNomUniversite(String nom) {
        return UniversiteRepo.findByNomUniversite(nom);
    }

    @Override
    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite){
        Universite univ = this.findByNomUniversite(nomUniversite);
        univ.setFoyer(FoyerRepo.findByIdFoyer(idFoyer));
        return univ;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite univ = UniversiteRepo.findByIdUniversite(idUniversite);
        univ.setFoyer(null);
        return univ;
    }
}
