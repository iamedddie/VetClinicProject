package com.example.VetClinic.repository;

import com.example.VetClinic.model.Owner;
import com.example.VetClinic.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnersRepository extends CrudRepository<Owner,Long> {
    List<Owner> findAll();

    Owner searchOwnerByName(@Param("name") String name);
}
