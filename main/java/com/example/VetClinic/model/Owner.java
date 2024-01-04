package com.example.VetClinic.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "owner_t")
@Data
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_seq_Gen")
    @SequenceGenerator(name = "owner_seq_Gen",
                        sequenceName = "owner_seq",
                        initialValue = 1,
                        allocationSize = 50)
    Long id;
    private String contact;
    private String name;
    private String email;

    @OneToMany
    private List<Pet> pets;
}
