package com.example.VetClinic.repository;

import com.example.VetClinic.model.Vaccine;
import com.example.VetClinic.model.enums.Species;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccineRepository extends CrudRepository<Vaccine,Long> {
    List<Vaccine> findAll();
    Vaccine searchVaccineByName(@Param("name") String name);
    Vaccine searchVaccineByTargetDisease(@Param("name") String name);
    List<Vaccine> searchVaccineByTargetAnimal(@Param("name") Species species);
}
