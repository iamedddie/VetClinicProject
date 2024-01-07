package com.example.VetClinic.service;

import com.example.VetClinic.dto.OwnerDTO;
import com.example.VetClinic.dto.PetDTO;
import com.example.VetClinic.exceptions.InvalidEntryException;
import com.example.VetClinic.exceptions.PetNotFoundException;
import com.example.VetClinic.model.pet_health_Info;
import com.example.VetClinic.model.Pet;
import com.example.VetClinic.model.enums.Category;
import com.example.VetClinic.repository.InfoRepository;
import com.example.VetClinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PetServiceImpl implements PetService {
    InfoRepository infoRepository;
    PetRepository petRepository;

    @Autowired
    public PetServiceImpl(InfoRepository infoRepository, PetRepository petRepository) {
        this.infoRepository = infoRepository;
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> searchPetByName(PetDTO petDTO) {
        return petRepository.searchPetByName(petDTO.getName());
    }

    @Override
    public List<Pet> findAllPet() {
        return petRepository.findAll();
    }

    @Override
    public List<Pet> searchByOwner(OwnerDTO ownerDTO) {
      return   petRepository.searchByOwner(ownerDTO.getName());

    }

    @Override
    public List<Pet> searchBySpecies(String breed, String specie) {
        List<Pet> pets = petRepository.searchPetBySpecies(specie);
        if (pets.isEmpty())
            throw new InvalidEntryException("Invalid Species Entry");
        List<Pet> petList = new ArrayList<>();
        for (Pet p : pets) {
            if (p.getBreed().equals(breed)) {
                petList.add(p);
            }
        }
        if (petList.isEmpty())
            throw new InvalidEntryException("Invalid Breed Entry");
        return petList;
    }

    @Override
    public List<Pet> searchByBreed(String breed) {
        return petRepository.searchPetByBreed(breed);
    }

    @Override
    public List<Pet> searchPetByCategory(Category category) {
        List<Pet> pets = petRepository.searchPetByCategory(category);
        if (pets.isEmpty())
            throw new InvalidEntryException("Invalid Category Entry");
        return pets;

    }


    @Override
    public Pet add(PetDTO petDTO) {
        pet_health_Info info = new pet_health_Info();
        info.setAge(petDTO.getInfo().getAge());
        info.setAppearance(petDTO.getInfo().getAppearance());
        info.setGender(petDTO.getInfo().getGender());
        info.setMed_History(petDTO.getInfo().getMed_History());
        info.setWeight(petDTO.getInfo().getWeight());
        info.setVaccines(petDTO.getInfo().getVaccines());
        info.setHealthy(petDTO.getInfo().isHealthy());
        pet_health_Info newInfo = infoRepository.save(info);
        Pet pet = new Pet();
        pet.setBreed(petDTO.getBreed());
        pet.setName(petDTO.getName());
        pet.setCategory(petDTO.getCategory());
        pet.setOwner(petDTO.getOwner());
        pet.setSpecies(petDTO.getSpecies());
        pet.setInfo(newInfo);
        return petRepository.save(pet);
    }

    @Override
    public void remove(Long id) {
    Pet pet = petRepository.findById(id).orElseThrow(()-> new PetNotFoundException("Pet not found"));
    petRepository.deleteById(pet.getId());
    }
}
