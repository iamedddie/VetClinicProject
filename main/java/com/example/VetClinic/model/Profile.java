package com.example.VetClinic.model;

import com.example.VetClinic.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq_gen")
    @SequenceGenerator(name = "profile_seq_gen",
            sequenceName = "profile_seq",
            initialValue = 1,
            allocationSize = 50)
    private Long id;
    private double weight;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String appearance;
    private String med_History;
    private boolean isHealthy;
    @Enumerated(EnumType.STRING)
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List <Vaccine> vaccines;

}



