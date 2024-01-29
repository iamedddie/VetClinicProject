package com.example.VetClinic.service;

import com.example.VetClinic.dto.PetDTO;
import com.example.VetClinic.model.Pet;
import com.example.VetClinic.model.Profile;
import com.example.VetClinic.model.enums.Category;
import com.example.VetClinic.model.enums.Species;

import java.util.List;

public interface PetService {
    List<Pet> searchPetByName(String name);

    List<Pet> findAllPet();
    List<Pet> findBySpecie(Species species);


    List<Pet> findByBreed(String breed, Species specie);

    List<Pet> searchPetByCategory(Category category);


    Pet add(PetDTO petDTO);

    void remove(Long id);

    List<Pet> findPetsByOwnerName(String name);
    List<Profile> sortPetsByWeightAsc(Species species);
    List<Profile> sortPetsByWeighDes(Species species);
    List<Pet> sortPetsByAge(Species species,double weight);
}
