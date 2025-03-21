package com.example.springminiproject.services;

import com.example.springminiproject.entities.Bloc;
import com.example.springminiproject.entities.Chambre;
import com.example.springminiproject.repositories.IBlocRepository;
import com.example.springminiproject.repositories.IChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServiceBloc implements IBlocService{
    @Autowired
    private IBlocRepository blocRepo;
    @Autowired
    private IChambreRepository chambreRepo;
    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        Bloc b = blocRepo.findByIdBloc(bloc.getIdBloc());
        if (b != null) {
            return blocRepo.save(bloc);
        }
        return null;
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepo.findByIdBloc(idBloc);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepo.delete(blocRepo.findByIdBloc(idBloc));
    }


    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepo.findByIdBloc(idBloc);
        bloc.getChambres().addAll(numChambre.stream().map(id -> chambreRepo.findByIdChambre(id)).toList());
        return bloc;
    }
}
