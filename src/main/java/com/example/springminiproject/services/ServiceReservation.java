package com.example.springminiproject.services;

import com.example.springminiproject.entities.Bloc;
import com.example.springminiproject.entities.Reservation;
import com.example.springminiproject.repositories.IReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceReservation implements IReservationService{

    @Autowired
    private IReservationRepository ReservationRepo;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return ReservationRepo.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        Reservation r = ReservationRepo.findByIdReservation(res.getIdReservation());
        if (r != null) {
            return ReservationRepo.save(res);
        }
        return null;
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return ReservationRepo.findByIdReservation(idReservation);
    }
}
