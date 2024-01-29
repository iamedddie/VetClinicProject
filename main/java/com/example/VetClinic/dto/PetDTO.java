package com.example.VetClinic.dto;

import com.example.VetClinic.model.Profile;
import com.example.VetClinic.model.Owner;
import com.example.VetClinic.model.enums.Category;
import com.example.VetClinic.model.enums.Species;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

    private Category category;
    private String name;

    private Owner owner;
    private Profile info;
    private String breed;
    private Species species;
}
