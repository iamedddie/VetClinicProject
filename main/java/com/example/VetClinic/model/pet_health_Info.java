package com.example.VetClinic.model;

import com.example.VetClinic.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class pet_health_Info {
    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "info_seq_gen")
    @SequenceGenerator(name = "info_seq_gen",
            sequenceName = "info_seq",
            initialValue = 1,
            allocationSize = 50)
    private Long id;
}
