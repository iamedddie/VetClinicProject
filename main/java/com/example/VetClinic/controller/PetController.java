package com.example.VetClinic.controller;


import com.example.VetClinic.model.Pet;
import com.example.VetClinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {
    PetService petService;
    @Autowired
    private PetController(PetService petService){this.petService=petService;}


    @GetMapping("/pets")
    public List<Pet> getAllPets(){
        return  petService.findAllPet();
    }
}
