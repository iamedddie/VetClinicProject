package com.example.VetClinic.repository;

import com.example.VetClinic.model.Enquiry;
import com.example.VetClinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnquiryRepository extends CrudRepository<Enquiry,Long> {
    List<Enquiry> findAll();

    Enquiry searchEnquiryByName(@Param("name") String name);
}
