package com.aspiree.person.aspire.service;

import com.aspiree.person.aspire.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private DataSource dataSource;

    private List<Person> persons = new ArrayList<>(Arrays.asList(new Person(101, "Joh", "Doe"), new Person(102, "Anuj", "Sood"),
            new Person(103, "Neetu", "Sood"),new Person(104, "Ritu", "Karol"),
            new Person(105, "Neeraj", "Gautam"),new Person(106, "Avinash", "Kandukuri")));


    public List<Person> getAllPersonsList(){
        System.out.println(dataSource);
        return persons;
    }

    public  Person getPersonById(int id) {
        return persons.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public  Person updatePerson(Person person) {
        persons.removeIf((p->p.getId()==person.getId()));
        persons.add(person);
        return persons.stream()
                .filter(p -> p.getId() == person.getId())
                .findFirst()
                .orElse(null);
    }


    public  void deletePerson(int id) {
        persons.removeIf(p->p.getId()== id);
    }


    public  Person createPerson(Person person) {
        persons.add(person);
        return persons.stream()
                .filter(p -> p.getId() == person.getId())
                .findFirst()
                .orElse(null);
    }
}
