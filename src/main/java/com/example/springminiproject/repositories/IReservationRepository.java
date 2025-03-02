package com.example.springminiproject.repositories;

import com.example.springminiproject.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation,String> {
    public Reservation findByIdReservation(String id);
}
