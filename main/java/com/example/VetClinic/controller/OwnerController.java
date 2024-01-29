package com.example.VetClinic.controller;


import com.example.VetClinic.model.Owner;
import com.example.VetClinic.model.Pet;
import com.example.VetClinic.service.OwnerService;
import com.example.VetClinic.service.PetService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerController {
    OwnerService ownerService;
    @Autowired
    private OwnerController( OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/all_owners")
    public List<Owner> getAllOwners() {
        return ownerService.findAllOwner();
    }

    @GetMapping("/searchOwnerByName")
    public Owner getOwnerByName(@PathParam("name") String name){
        return ownerService.searchOwnerByName(name);
    }

    //@PutMapping("/save")

}