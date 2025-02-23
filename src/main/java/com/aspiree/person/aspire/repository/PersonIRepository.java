package com.aspiree.person.aspire.repository;

import com.aspiree.person.aspire.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonIRepository extends JpaRepository<Person, Integer> {

}
