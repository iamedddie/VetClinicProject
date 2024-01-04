package com.example.VetClinic.model;

import com.example.VetClinic.model.enums.Category;
import com.example.VetClinic.model.enums.Species;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private Category category;
    private String name;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name ="owner_id", referencedColumnName = "id")
    private  Owner owner;
    @OneToOne
    private Health_Info info;
    private String breed;
    private Species species;
    @Id
    private Long id;

}
