package com.example.springminiproject.repositories;

import com.example.springminiproject.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoyerRepository extends JpaRepository<Foyer,Long> {

    Foyer findByIdFoyer(long id);


}
