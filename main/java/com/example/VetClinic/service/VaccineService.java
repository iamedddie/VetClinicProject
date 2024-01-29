package com.example.VetClinic.service;

import com.example.VetClinic.model.Owner;
import com.example.VetClinic.model.Vaccine;
import com.example.VetClinic.model.enums.Species;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VaccineService {
    Vaccine searchVaccineByName(String name);
    List<Vaccine> findAllVaccine();

    Vaccine searchVaccineByTargetDisease(@Param("name") String name);
    List<Vaccine> searchVaccineByTargetAnimal(@Param("name") Species species);



}
