package com.example.springminiproject.services;

import com.example.springminiproject.entities.Etudiant;
import com.example.springminiproject.entities.Foyer;
import com.example.springminiproject.repositories.IEtudiantRepository;
import com.example.springminiproject.repositories.IFoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceEtudiant implements IEtudiantService {

    @Autowired
    private IEtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        Etudiant et = etudiantRepository.findByIdEtudiant(e.getIdEtudiant());
        if (et != null) {
            return etudiantRepository.save(e);
        }
        return null;
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.findByIdEtudiant(idEtudiant);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.delete(etudiantRepository.findByIdEtudiant(idEtudiant));
    }


}
