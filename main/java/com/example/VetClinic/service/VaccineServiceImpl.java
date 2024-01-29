package com.example.VetClinic.service;

import com.example.VetClinic.model.Vaccine;
import com.example.VetClinic.model.enums.Species;
import com.example.VetClinic.repository.VaccineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

    VaccineRepository vaccineRepository;

    public VaccineServiceImpl(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public Vaccine searchVaccineByName(String name) {
        return vaccineRepository.searchVaccineByName(name);
    }

    @Override
    public List<Vaccine> findAllVaccine() {
        return vaccineRepository.findAll();
    }

    @Override
    public Vaccine searchVaccineByTargetDisease(String name) {
        return vaccineRepository.searchVaccineByTargetDisease(name);
    }

    @Override
    public List<Vaccine> searchVaccineByTargetAnimal(Species species) {
        return vaccineRepository.searchVaccineByTargetAnimal(species);
    }
}
