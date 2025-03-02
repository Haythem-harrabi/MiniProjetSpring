package com.example.springminiproject.services;

import com.example.springminiproject.entities.Chambre;
import com.example.springminiproject.entities.Etudiant;
import com.example.springminiproject.repositories.IChambreRepository;
import com.example.springminiproject.repositories.IEtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceChambre implements IChambreService{
    @Autowired
    private IChambreRepository chambreRepo;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        Chambre ch = chambreRepo.findByIdChambre(c.getIdChambre());
        if (ch != null) {
            return chambreRepo.save(c);
        }
        return null;
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepo.findByIdChambre(idChambre);
    }
}
