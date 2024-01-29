package com.example.VetClinic.controller;


import com.example.VetClinic.model.Owner;
import com.example.VetClinic.model.Pet;
import com.example.VetClinic.model.Vaccine;
import com.example.VetClinic.model.enums.Species;
import com.example.VetClinic.service.OwnerService;
import com.example.VetClinic.service.VaccineService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VaccineController {
    VaccineService vaccineService;
    @Autowired
    private VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping("/all_vaccines")
    public List<Vaccine> getAllVaccines() {
        return vaccineService.findAllVaccine();
    }

    @GetMapping("/searchVaccineByName")
    public Vaccine getVaccineByName(@PathParam("name") String name){
        return vaccineService.searchVaccineByName(name);
    }
    @GetMapping("/vaccineByTargetDisease")
    public Vaccine getVaccineByTargetDisease(@PathParam("disease") String disease){
        return vaccineService.searchVaccineByTargetDisease(disease);
    }

    @GetMapping("vaccines/{specie}")
    public List<Vaccine> getVaccineByTargetAnimal(@PathVariable Species specie) {
        return vaccineService.searchVaccineByTargetAnimal(specie);}
}