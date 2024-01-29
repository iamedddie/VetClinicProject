package com.example.VetClinic.controller;


import com.example.VetClinic.dto.EnquiryDTO;
import com.example.VetClinic.model.Enquiry;
import com.example.VetClinic.model.Owner;
import com.example.VetClinic.service.EnquiryService;
import com.example.VetClinic.service.OwnerService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnquiryController {
    EnquiryService enquiryService;
    @Autowired
    private EnquiryController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }

    @GetMapping("/all_enquiries")
    public List<Enquiry> getAllEnquiries() {
        return enquiryService.findAll();
    }

    @GetMapping("/searchEnquiryByName")
    public Enquiry getEnquiryByName(@PathParam("name") String name){
        return enquiryService.searchEnquiryByName(name);
    }

    @PostMapping("/saveEnquiry")
    public Enquiry saveEnquiry (@RequestBody EnquiryDTO enquiryDTO){
        return enquiryService.saveEnquiry(enquiryDTO);
    }

}