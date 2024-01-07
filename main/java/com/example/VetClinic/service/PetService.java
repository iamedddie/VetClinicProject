package com.example.VetClinic.service;

import com.example.VetClinic.dto.OwnerDTO;
import com.example.VetClinic.dto.PetDTO;
import com.example.VetClinic.model.Pet;
import com.example.VetClinic.model.enums.Category;

import java.util.List;

public interface PetService {
    List<Pet> searchPetByName(PetDTO petDTO);

    List<Pet> findAllPet();

    List<Pet> searchByOwner(OwnerDTO ownerDTO);
    List<Pet> searchBySpecies(String breed,String specie);
    List<Pet> searchByBreed(String breed);

    List<Pet> searchPetByCategory(Category category);


    Pet add(PetDTO petDTO);

    void remove(Long id);
}
