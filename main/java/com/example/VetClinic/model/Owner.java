package com.example.VetClinic.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Table(name = "owner")
@Data
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue
    Long id;
    private String contact;
    private String name;
    private String email;

    @OneToMany(mappedBy = "owner" ,cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Pet> pets;
}
