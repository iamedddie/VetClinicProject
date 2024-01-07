package com.example.VetClinic.repository;

import com.example.VetClinic.model.pet_health_Info;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends CrudRepository<pet_health_Info,Long> {
    List<pet_health_Info> findAll();
}
