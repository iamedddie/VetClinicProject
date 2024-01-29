package com.example.VetClinic.service;

import com.example.VetClinic.model.Owner;
import com.example.VetClinic.model.Pet;
import com.example.VetClinic.repository.OwnersRepository;
import com.example.VetClinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService {
    private OwnersRepository ownersRepository;


    @Autowired
    public OwnerServiceImpl(OwnersRepository ownersRepository){
        this.ownersRepository = ownersRepository;

    }

    @Override
    public Owner searchOwnerByName(String name) {
        return ownersRepository.searchOwnerByName(name);
    }

    @Override
    public List<Owner> findAllOwner() {
        return ownersRepository.findAll();
    }



}
