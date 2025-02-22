package com.aspiree.person.aspire.controller;


import com.aspiree.person.aspire.model.Person;
import com.aspiree.person.aspire.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/personService/v1/persons")
public class PersonController {

    @Autowired
    private  PersonService personService;

    @GetMapping
    public List<Person> getAll() {
        System.out.println("GET ALL");
        return personService.getAllPersonsList();
    }

    @GetMapping("/{id}")
    public Person getOneById(@PathVariable int id) {

        System.out.println("GET BY ID ===" + id);
        return personService.getPersonById(id);
    }

    @PostMapping
    public  Person create(@RequestBody Person person) {
        System.out.println("CREATE " + person);
        return personService.createPerson(person);
    }

    @PutMapping
    public  Person update(@RequestBody Person person) {
        System.out.println("UPDATE " + person);
        return  personService.updatePerson(person);
    }

    @DeleteMapping("/api/personService/v1/persons/{id}")
    public  void delete(@PathVariable int id) {
        personService.deletePerson((id));
    }
}

