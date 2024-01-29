package com.example.VetClinic.service;

import com.example.VetClinic.dto.EnquiryDTO;
import com.example.VetClinic.model.Enquiry;
import com.example.VetClinic.model.Owner;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnquiryService {
    List<Enquiry> findAll();

    Enquiry searchEnquiryByName(@Param("name") String name);
    Enquiry saveEnquiry(EnquiryDTO enquiryDTO);



}
