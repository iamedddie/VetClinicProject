package com.example.VetClinic.model;

import com.example.VetClinic.model.enums.Gender;
import com.example.VetClinic.model.enums.Species;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vaccines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
   String name;
   String targetDisease;
   String meansOfAdmin;
    @Enumerated(EnumType.STRING)
   Species targetAnimal;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "vaccine_seq_gen")
    @SequenceGenerator(name = "vaccine_seq_gen",
            sequenceName = "vaccine_seq",
            initialValue = 1,
            allocationSize = 50)
    private Long id;
}
