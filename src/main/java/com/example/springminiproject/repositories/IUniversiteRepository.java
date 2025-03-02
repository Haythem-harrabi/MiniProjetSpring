package com.example.springminiproject.repositories;

import com.example.springminiproject.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUniversiteRepository extends JpaRepository<Universite, Long> {
    public Universite findByIdUniversite(long id);
}
