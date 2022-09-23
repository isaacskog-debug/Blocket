package com.example.securitystart;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdvertRepository extends CrudRepository<Advert, Long> {

    @Query(value = "SELECT * FROM ADVERT ORDER BY ?1", nativeQuery = true)
    List<Advert> filter(String selected);

    @Query(value = "SELECT * FROM ADVERT ORDER BY PRICE", nativeQuery = true)
    List<Advert> sortByPrice();

    @Query(value = "SELECT * FROM ADVERT ORDER BY NAME", nativeQuery = true)
    List<Advert> sortByName();
}
