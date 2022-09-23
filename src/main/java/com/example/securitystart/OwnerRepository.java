package com.example.securitystart;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    //List<Owner> findByName(String name);

    @Query(value = "select * from owner where firstname = ?1", nativeQuery = true)
    List<Owner> findOwner(String name);

   // @Query(value = "select * from advert join owner on advert.id = owner.id where owner.id = ?1", nativeQuery = true)
   // List<Advert> join(int id);

}
