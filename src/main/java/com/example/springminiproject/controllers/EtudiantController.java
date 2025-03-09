package com.example.springminiproject.controllers;

import com.example.springminiproject.entities.Etudiant;
import com.example.springminiproject.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantController {
    IEtudiantService etudiantService;

    @GetMapping("/getAllEtudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }


    @PostMapping("/addEtudiant")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return (etudiantService.addEtudiants(etudiants));
    }

    // Mettre à jour un étudiant
    @PutMapping("/updateEtudiant/{id}")
    public Etudiant updateEtudiant(@PathVariable("id") long idEtudiant, @RequestBody Etudiant etudiant) {

        return etudiantService.updateEtudiant(etudiant);
    }

    // Récupérer un étudiant par ID
    @GetMapping("/getById/{id}")
    public Etudiant retrieveEtudiant(@PathVariable("id") long idEtudiant) {
        return etudiantService.retrieveEtudiant(idEtudiant);
    }

    // Supprimer un étudiant
    @DeleteMapping("/deleteEtudiant/{id}")
    public void removeEtudiant(@PathVariable("id") long idEtudiant) {
        etudiantService.removeEtudiant(idEtudiant);
    }
}
