package com.example.springminiproject.repositories;

import com.example.springminiproject.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlocRepository extends JpaRepository<Bloc,Long> {
    public Bloc findByIdBloc(long idBloc);
}
