package com.example.VetClinic.repository;

import com.example.VetClinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnersRepository extends CrudRepository<Owner,Long> {
    List<Owner> findAll();
}
