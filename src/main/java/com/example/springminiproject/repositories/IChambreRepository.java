package com.example.springminiproject.repositories;

import com.example.springminiproject.entities.Chambre;
import com.example.springminiproject.entities.Etudiant;
import com.example.springminiproject.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChambreRepository extends JpaRepository<Chambre,Long> {
    Chambre findByIdChambre(long id);

    //JPQL q1
    @Query("SELECT c FROM Chambre c WHERE c.TypeC = :type AND c.bloc.foyerBloc.universite.nomUniversite = :nomUniversite AND c.idChambre NOT IN (SELECT r.chambre.idChambre FROM Reservation r WHERE r.anneeUniversitaire = CURRENT_DATE)")
    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(@Param("nomUniversite") String nomUniversite, @Param("type") TypeChambre type);
    //JPQL q3
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.TypeC = :typeC")
    List<Chambre> getChambresParBlocEtTypeJPQL(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);

    //Keywords q3
    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, TypeChambre typeChambre);

    List<Chambre> findByBlocIdBloc(long idBloc);
}
