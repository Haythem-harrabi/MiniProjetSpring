package com.example.springminiproject.services;

import com.example.springminiproject.entities.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveBlocs();
    Bloc updateBloc (Bloc bloc);
    Bloc addBloc (Bloc bloc);
    Bloc retrieveBloc (long idBloc);
    void removeBloc (long idBloc);

    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;
}
