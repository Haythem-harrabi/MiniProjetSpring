package com.example.springminiproject.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;
    private long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Reservation> reservations;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE} )
    private Bloc bloc;

    public TypeChambre getTypeC() {
        return typeC;
    }

    public void setTypeC(TypeChambre typeC) {
        this.typeC = typeC;
    }

    public void setIdChambre(long idChambre) {
        idChambre = idChambre;
    }

    public void setNumeroChambre(long numeroChambre) {
        this.numeroChambre = numeroChambre;
    }



    public void setReservations(List<Reservation> reservations) {
        reservations = reservations;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

    public long getIdChambre() {
        return idChambre;
    }

    public long getNumeroChambre() {
        return numeroChambre;
    }



    public List<Reservation> getReservations() {
        return reservations;
    }

    public Bloc getBloc() {
        return bloc;
    }
}
