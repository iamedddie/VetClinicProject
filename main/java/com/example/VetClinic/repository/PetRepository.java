package com.example.VetClinic.repository;

import com.example.VetClinic.model.Pet;
import com.example.VetClinic.model.enums.Category;
import com.example.VetClinic.model.enums.Species;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet,Long> {
    List<Pet> findAll();


    @Query("SELECT new Pet(p.id,p.name, p.owner, p.profile, p.breed,p.species,p.category) FROM Pet p WHERE p.category = :category")
    List<Pet> searchPetByCategory(@Param("category") Category category);
    @Query("SELECT new Pet(p.id, p.name, p.owner, p.profile, p.breed,p.species,p.category) FROM Pet p WHERE p.species = :species")
    List<Pet> searchPetBySpecies(@Param("species") Species species);

    @Query("SELECT new Pet(p.id,p.name, p.owner, p.profile, p.breed,p.species,p.category) FROM Pet p WHERE p.name LIKE %:name%")
    List<Pet> searchPetByName(@Param("name") String name);


}
