package com.example.VetClinic.service;

import com.example.VetClinic.dto.PetDTO;
import com.example.VetClinic.exceptions.InvalidEntryException;
import com.example.VetClinic.exceptions.PetNotFoundException;
import com.example.VetClinic.model.Owner;
import com.example.VetClinic.model.Profile;
import com.example.VetClinic.model.Pet;
import com.example.VetClinic.model.enums.Category;
import com.example.VetClinic.model.enums.Species;
import com.example.VetClinic.repository.OwnersRepository;
import com.example.VetClinic.repository.PetRepository;
import com.example.VetClinic.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class PetServiceImpl implements PetService {
    ProfileRepository profileRepository;
    PetRepository petRepository;
    OwnersRepository ownersRepository;


    @Autowired
    public PetServiceImpl(ProfileRepository profileRepository, PetRepository petRepository, OwnersRepository ownersRepository) {
        this.profileRepository = profileRepository;
        this.petRepository = petRepository;
        this.ownersRepository = ownersRepository;
    }


    @Override
    public List<Pet> searchPetByName(String name) {
        return petRepository.searchPetByName(name);
    }

    @Override
    public List<Pet> findAllPet() {
        return petRepository.findAll();
    }

    @Override
    public List<Pet> findBySpecie(Species Species) {
        return petRepository.searchPetBySpecies(Species);
    }


    @Override
    public List<Pet> findByBreed(String breed, Species specie) {
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
    public List<Pet> searchPetByCategory(Category category) {
        List<Pet> pets = petRepository.searchPetByCategory(category);
        if (pets.isEmpty())
            throw new InvalidEntryException("Invalid Category Entry");
        return pets;

    }


    @Override
    public Pet add(PetDTO petDTO) {
        Profile info = new Profile();
        info.setAge(petDTO.getInfo().getAge());
        info.setAppearance(petDTO.getInfo().getAppearance());
        info.setGender(petDTO.getInfo().getGender());
        info.setMed_History(petDTO.getInfo().getMed_History());
        info.setWeight(petDTO.getInfo().getWeight());
        info.setVaccines(petDTO.getInfo().getVaccines());
        info.setHealthy(petDTO.getInfo().isHealthy());
        Profile newInfo = profileRepository.save(info);
        Pet pet = new Pet();
        pet.setBreed(petDTO.getBreed());
        pet.setName(petDTO.getName());
        pet.setCategory(petDTO.getCategory());
        pet.setOwner(petDTO.getOwner());
        pet.setSpecies(petDTO.getSpecies());
        pet.setProfile(newInfo);
        return petRepository.save(pet);
    }

    @Override
    public void remove(Long id) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new PetNotFoundException("Pet not found"));
        petRepository.deleteById(pet.getId());
    }

    @Override
    public List<Pet> findPetsByOwnerName(String name) {
        Owner owner = ownersRepository.searchOwnerByName(name);
        return owner.getPets();
    }



    @Override
    public List<Profile> sortPetsByWeighDes(Species species) {
        return null;
    }

    //    @Override
//    public List<Pet> sortPetsByWeight(Species species, double weight) {
//        List<Pet> pets = petRepository.findAll();
//        List<Profile> profileList = new ArrayList<>();
//        for (Pet p : pets) {
//            if (species.equals(p.getSpecies())) {
//                profileList.add(p.getProfile());
//            }
//        }
//
//        return profileList.stream().sorted((p1,p2)->(p1.getWeight()))
//    }
    @Override
    public List<Profile> sortPetsByWeightAsc(Species species) {
        List<Pet> pets = petRepository.findAll();
        List<Profile> profileList = new ArrayList<>();

        for (Pet pet : pets) {
            if (species.equals(pet.getSpecies()) && pet.getProfile() != null) {
                profileList.add(pet.getProfile());
            }
        }

        return profileList.stream()
                .sorted(Comparator.comparingDouble(Profile::getWeight))
                .collect(Collectors.toList());
    }


    @Override
    public List<Pet> sortPetsByAge(Species species, double weight) {
        return null;
    }

}
