package com.example.jobflow.repository;

import com.example.jobflow.model.Website;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WebsiteRepository extends CrudRepository<Website,Integer> {

    // nativequery - użyj SQL zamiast HQSL
    @Query(value = "SELECT * FROM website WHERE name=71 LIMIT 1", nativeQuery = true)
    Optional<Website> findWebPage(String name);
}
