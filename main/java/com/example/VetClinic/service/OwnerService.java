package com.example.VetClinic.service;

import com.example.VetClinic.dto.PetDTO;
import com.example.VetClinic.model.Owner;
import com.example.VetClinic.model.Pet;
import com.example.VetClinic.model.enums.Category;
import com.example.VetClinic.model.enums.Species;

import java.util.List;

public interface OwnerService {
    Owner searchOwnerByName(String name);
    List<Owner> findAllOwner();



}
