package com.example.springminiproject.repositories;

import com.example.springminiproject.entities.Chambre;
import com.example.springminiproject.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChambreRepository extends JpaRepository<Chambre,Long> {
    Chambre findByIdChambre(long id);
}
