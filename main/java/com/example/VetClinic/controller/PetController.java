package com.example.VetClinic.controller;


import com.example.VetClinic.model.Pet;
import com.example.VetClinic.model.Profile;
import com.example.VetClinic.model.enums.Category;
import com.example.VetClinic.model.enums.Species;
import com.example.VetClinic.service.PetService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {
    PetService petService;

    @Autowired
    private PetController(PetService petService) {
        this.petService = petService;
    }


    @GetMapping("/all_pets")
    public List<Pet> getAllPets() {
        return petService.findAllPet();
    }

    @GetMapping("species/{specie}")
    public List<Pet> getPetsBySpecie(@PathVariable Species specie) {
        return petService.findBySpecie(specie);
    }@GetMapping("category/{category}")
    public List<Pet> getPetsByCategory(@PathVariable Category category) {
        return petService.searchPetByCategory(category);
    }

    @GetMapping("/search/{species}/{breed}")
    public List<Pet> getPetsByBreed( @PathVariable String breed, @PathVariable String species) {
        return petService.findByBreed(breed, Species.valueOf(species));
    }

    @GetMapping("/searchPetByName")
    public List<Pet> getPetByName(@PathParam("name") String name){
        return petService.searchPetByName(name);
    }
    @GetMapping("/searchPetByOwner")
    public List<Pet> getPetByOwnerName(@PathParam("name") String name){
        return petService.findPetsByOwnerName(name);
    }
    @GetMapping("/sortPetsByWeight")
    public List<Profile> sortPetsByWeight(Species species, double weight) {return null;}
}