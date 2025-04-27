package com.example.springminiproject.repositories;

import com.example.springminiproject.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation,String> {
    public Reservation findByIdReservation(String id);

    //JPQL
    @Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire = :annee ")
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(@Param("annee") Date anneeUniversite, @Param("nomUniversite") String nomUniversite);

}
