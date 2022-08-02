package com.example.codeclan.filesandfolders.repository;

import com.example.codeclan.filesandfolders.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
