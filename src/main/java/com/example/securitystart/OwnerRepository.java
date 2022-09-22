package com.example.securitystart;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    //List<Owner> findByName(String name);

}
