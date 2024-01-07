package com.example.VetClinic.dto;

import com.example.VetClinic.model.enums.Species;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineDTO {

    String name;
    String targetDisease;
    String meansOfAdmin;
    Species targetAnimal;
}
