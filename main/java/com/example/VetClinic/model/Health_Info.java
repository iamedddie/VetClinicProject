package com.example.VetClinic.model;

import com.example.VetClinic.model.enums.Gender;
import com.example.VetClinic.model.enums.Vaccine;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Health_Info {
    private double weight;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String appearance;
    private String med_History;
    private boolean isHealthy;
    @Enumerated(EnumType.STRING)
    private List <Vaccine> vaccines;
    @Id
    private Long id;
}
