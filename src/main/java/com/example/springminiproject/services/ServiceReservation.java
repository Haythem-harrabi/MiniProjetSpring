package com.example.springminiproject.services;

import com.example.springminiproject.entities.*;
import com.example.springminiproject.repositories.IBlocRepository;
import com.example.springminiproject.repositories.IChambreRepository;
import com.example.springminiproject.repositories.IEtudiantRepository;
import com.example.springminiproject.repositories.IReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceReservation implements IReservationService{

    @Autowired
    private IReservationRepository ReservationRepo;
    @Autowired
    private IBlocRepository blocRepo;
    @Autowired
    private IEtudiantRepository etudiantRepo;
    @Autowired
    private IChambreRepository chambreRepo;
    @Autowired
    private IReservationRepository reservationRepo;
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

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        return ReservationRepo.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite);
    }

    @Override
    public Reservation ajouterReservation (long idBloc, long cinEtudiant){
        Bloc bloc = blocRepo.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc non trouvé"));

        Etudiant etudiant = etudiantRepo.findById(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));

        List<Chambre> chambres = chambreRepo.findByBlocIdBloc(idBloc);

        for (Chambre chambre : chambres) {
            int maxCapacite = getCapaciteMaximale(chambre.getTypeC());
            int currentCount = reservationRepo.countByChambre_Id(chambre.getIdChambre());

            if (currentCount < maxCapacite) {

                Reservation reservation = new Reservation();
                reservation.setChambre(chambre);
                reservation.setEtudiants(List.of(etudiant));
                reservation.setEstValide(true);
                reservation.setAnneeUniversitaire(getAnneeUniversitaireActuelle());

                reservation.setIdReservation(
                        chambre.getNumeroChambre() + "-" + bloc.getNomBloc() + "-" + reservation.getAnneeUniversitaire()
                );

                return reservationRepo.save(reservation);
            }
        }

        throw new RuntimeException("Aucune chambre disponible dans le bloc");

    }

    private int getCapaciteMaximale(TypeChambre type) {
        return switch (type) {
            case SIMPLE -> 1;
            case DOUBLE -> 2;
            case TRIPLE -> 3;
        };
    }

    private Date getAnneeUniversitaireActuelle() {
        LocalDate today = LocalDate.now();
        int year = today.getMonthValue() >= 9 ? today.getYear() : today.getYear() - 1;
        LocalDate startOfAcademicYear = LocalDate.of(year, 9, 1);
        return java.sql.Date.valueOf(startOfAcademicYear);
    }
}
