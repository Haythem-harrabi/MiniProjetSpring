package com.example.springminiproject.repositories;

import com.example.springminiproject.entities.Etudiant;
import com.example.springminiproject.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {

    Etudiant findByIdEtudiant(long id);
}
