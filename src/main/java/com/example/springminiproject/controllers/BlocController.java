package com.example.springminiproject.controllers;

import com.example.springminiproject.entities.Bloc;
import com.example.springminiproject.services.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloc")
@AllArgsConstructor
public class BlocController {
    IBlocService blocService;


    @GetMapping("/getAllBlocs")
    public List<Bloc> retrieveBlocs() {
        return blocService.retrieveBlocs();
    }


    @GetMapping("/getById/{id}")
    public Bloc retrieveBloc(@PathVariable("id") long idBloc) {
        return blocService.retrieveBloc(idBloc);
    }

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }


    @PutMapping("/updateBloc/{id}")
    public Bloc updateBloc(@PathVariable("id") long idBloc, @RequestBody Bloc bloc) {

        return blocService.updateBloc(bloc);
    }


    @DeleteMapping("/deleteBloc/{id}")
    public void removeBloc(@PathVariable("id") long idBloc) {
        blocService.removeBloc(idBloc);
    }
}