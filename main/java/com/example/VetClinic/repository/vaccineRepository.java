package com.example.VetClinic.repository;

import com.example.VetClinic.model.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface vaccineRepository extends CrudRepository<Vaccine,Long> {
    List<Vaccine> findAll();
}
