package com.example.VetClinic.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enquiry")
@Data
@NoArgsConstructor
public class Enquiry {
    @Id
    @GeneratedValue
    Long id;
    private String contact;
    private String name;
    private String email;
    private String message;
}
