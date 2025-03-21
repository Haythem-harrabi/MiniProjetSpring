package com.example.springminiproject.services;


import com.example.springminiproject.entities.Bloc;
import com.example.springminiproject.entities.Foyer;
import com.example.springminiproject.entities.Universite;
import com.example.springminiproject.repositories.IFoyerRepository;
import com.example.springminiproject.repositories.IUniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceFoyer implements IServiceFoyer{

    @Autowired
    private IFoyerRepository foyerRepository;
    @Autowired
    private IUniversiteRepository universiteRepo;


    @Override
    public Foyer findByidFoyer(long id) {
        return foyerRepository.findByIdFoyer(id);
    }

    @Override
    public List<Foyer> findAll() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer save(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void delete(Long id) {
        foyerRepository.delete(foyerRepository.findByIdFoyer(id));
    }

    @Override
    public Foyer updateFoyer (Foyer f) {
        Foyer existingFoyer = foyerRepository.findByIdFoyer(f.getIdFoyer());
        if (existingFoyer != null) {
            return foyerRepository.save(f);
        }
     return null;
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite){

        if (foyer.getBlocs() != null) {
            for (Bloc bloc : foyer.getBlocs()) {
                bloc.setFoyerBloc(foyer);
            }
        }
        Foyer savedFoyer = foyerRepository.save(foyer);
        Universite universite = universiteRepo.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée"));

        universite.setFoyer(savedFoyer);
        savedFoyer.setUniversite(universite);

        universiteRepo.save(universite);

        return savedFoyer;

    }


}
