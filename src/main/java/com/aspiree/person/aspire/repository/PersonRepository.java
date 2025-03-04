package com.aspiree.person.aspire.repository;

import com.aspiree.person.aspire.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    // QueryBy
    List<Person> findByFirstName(String firstName);
    Person findByLastName(String lastName);
    Person findByFirstNameAndLastName(String firstName, String lastName);

}
