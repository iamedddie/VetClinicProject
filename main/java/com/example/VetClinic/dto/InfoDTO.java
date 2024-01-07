package com.example.VetClinic.dto;

import com.example.VetClinic.model.Vaccine;
import com.example.VetClinic.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoDTO {

    private double weight;
    private int age;
    private Gender gender;
    private String appearance;
    private String med_History;
    private boolean isHealthy;
    private List<Vaccine> vaccines;
}
