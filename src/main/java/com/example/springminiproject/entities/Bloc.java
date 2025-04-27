package com.example.springminiproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Bloc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bloc")
    private List<Chambre> chambres;

    @ManyToOne(cascade = CascadeType.ALL)
    private Foyer foyerBloc;

    public long getIdBloc() {
        return idBloc;
    }

    public String getNomBloc() {
        return nomBloc;
    }

    public long getCapaciteBloc() {
        return capaciteBloc;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public Foyer getFoyerBloc() {
        return foyerBloc;
    }

    public void setIdBloc(long idBloc) {
        this.idBloc = idBloc;
    }

    public void setNomBloc(String nomBloc) {
        this.nomBloc = nomBloc;
    }

    public void setCapaciteBloc(long capaciteBloc) {
        this.capaciteBloc = capaciteBloc;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }

    public void setFoyerBloc(Foyer foyerBloc) {
        this.foyerBloc = foyerBloc;
    }
}
