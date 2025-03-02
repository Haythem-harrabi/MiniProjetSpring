package com.example.springminiproject.controllers;

import com.example.springminiproject.entities.Foyer;
import com.example.springminiproject.services.IServiceFoyer;
import com.example.springminiproject.services.ServiceFoyer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerController {


    @Autowired
    private IServiceFoyer serviceFoyer;

    @PostMapping("/postfoyer")
    public Foyer saveFoyer(@RequestBody Foyer foyer){
       return  serviceFoyer.save(foyer);
    }
    @GetMapping("/getAll")
    public List<Foyer> getAllFoyer (){
        return serviceFoyer.findAll();
    }

   @DeleteMapping("/delete/{id}")
    public void DeleteFoyer (@PathVariable Long id){
        serviceFoyer.delete(id);
    }

    @GetMapping("/getFoyer/{id}")
    public Foyer getFoyer(@PathVariable long id){
        return serviceFoyer.findByidFoyer(id);
    }

    @PutMapping("/updateFoyer")
    public Foyer updateFoyer(@RequestBody Foyer foyer){
        return serviceFoyer.updateFoyer(foyer);
    }





}
