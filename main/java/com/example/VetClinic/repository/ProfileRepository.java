package com.example.VetClinic.repository;

import com.example.VetClinic.model.Owner;
import com.example.VetClinic.model.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends CrudRepository<Profile,Long> {

}
