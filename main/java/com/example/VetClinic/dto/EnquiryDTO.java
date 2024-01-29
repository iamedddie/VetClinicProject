package com.example.VetClinic.dto;

import com.example.VetClinic.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryDTO {
    private String name;
    private String contact;
    private String email;
    private String message;

}
