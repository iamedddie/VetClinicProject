package com.example.VetClinic.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Table(name = "owners")
@Data
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_seq_gen")
    @SequenceGenerator(name = "owner_seq_gen",
                        sequenceName = "owner_seq",
                        initialValue = 1,
                        allocationSize = 50)
    Long id;
    private String contact;
    private String name;
    private String email;

    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Pet> petsList;
}
