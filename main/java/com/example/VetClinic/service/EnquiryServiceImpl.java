package com.example.VetClinic.service;

import com.example.VetClinic.dto.EnquiryDTO;
import com.example.VetClinic.model.Enquiry;
import com.example.VetClinic.model.Owner;
import com.example.VetClinic.repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiryServiceImpl implements EnquiryService {
    EnquiryRepository enquiryRepository;
    @Autowired
    public EnquiryServiceImpl(EnquiryRepository enquiryRepository) {
        this.enquiryRepository = enquiryRepository;
    }

    @Override
    public List<Enquiry> findAll() {
        return enquiryRepository.findAll();
    }

    @Override
    public Enquiry searchEnquiryByName(String name) {
        return enquiryRepository.searchEnquiryByName(name);
    }

    @Override
    public Enquiry saveEnquiry(EnquiryDTO enquiryDTO) {
        Enquiry enquiry= new Enquiry();
        enquiry.setName(enquiryDTO.getName());
        enquiry.setEmail(enquiryDTO.getEmail());
        enquiry.setContact(enquiryDTO.getContact());
        enquiry.setMessage(enquiryDTO.getMessage());
        return enquiryRepository.save(enquiry);
    }
}
