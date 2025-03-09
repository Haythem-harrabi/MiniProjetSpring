package com.example.springminiproject.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre TypeC;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> Reservations;

    @ManyToOne
    private Bloc bloc;


    public void setIdChambre(long idChambre) {
        idChambre = idChambre;
    }

    public void setNumeroChambre(long numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public void setTypeC(TypeChambre typeC) {
        TypeC = typeC;
    }

    public void setReservations(List<Reservation> reservations) {
        Reservations = reservations;
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

    public TypeChambre getTypeC() {
        return TypeC;
    }

    public List<Reservation> getReservations() {
        return Reservations;
    }

    public Bloc getBloc() {
        return bloc;
    }
}
