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
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdChambre;
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre TypeC;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> Reservations;

    @ManyToOne
    private Bloc bloc;
}
