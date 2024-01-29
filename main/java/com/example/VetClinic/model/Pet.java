package com.example.VetClinic.model;

import com.example.VetClinic.model.enums.Category;
import com.example.VetClinic.model.enums.Species;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq_gen")
    @SequenceGenerator(name = "pet_seq_gen",
            sequenceName = "pet_seq",
            initialValue = 1,
            allocationSize = 50)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String name;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name ="owner_id", referencedColumnName = "id")
    private  Owner owner;
    @OneToOne
    @JoinColumn(name = "profile_id",referencedColumnName ="id" )
    private Profile profile;
    private String breed;
    @Enumerated(EnumType.STRING)
    private Species species;

    public Pet(String name) {
        this.name = name;
    }


    public Pet(Long id, String name, Owner owner, Profile profile, String breed, Species species , Category category ) {
        this.name = name;
        this.owner = owner;
        this.profile = profile;
        this.species = species;
        this.category = category;
        this.breed = breed;
        this.id = id;
    }




}
