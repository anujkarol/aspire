package com.aspiree.person.aspire.controller;


import com.aspiree.person.aspire.dto.PersonDto;
import com.aspiree.person.aspire.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/personService/v1/persons")
public class PersonController {

    @Autowired
    private  PersonService personService;

    @GetMapping
    public ResponseEntity <List<PersonDto>> getAll() {
        System.out.println("GET ALL");
//        return ResponseEntity.ok(personService.getAllPersonsList());

        return new ResponseEntity<>(personService.getAllPersonsList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getOneById(@PathVariable int id) {
        final PersonDto response = personService.getPersonById(id);
        if(response==null){
            return ResponseEntity.notFound().build();
        }
        System.out.println("GET BY ID ===" + id);
        return ResponseEntity.ok(response);


    }

    @PostMapping
    public  ResponseEntity<PersonDto> create(@RequestBody PersonDto person) {
        final PersonDto response = personService.createPerson(person);
        System.out.println("CREATE " + person);
        if(response==null){
            return ResponseEntity.notFound().build();
        }
        System.out.println("GET BY ID ===" + response);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public  ResponseEntity<PersonDto> update(@RequestBody PersonDto person) {
        final PersonDto response = personService.updatePerson(person);
        System.out.println("UPDATE " + person);
        if(response==null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(response);
    }

    @DeleteMapping("/api/personService/v1/persons/{id}")
    public  ResponseEntity<Void> delete(@PathVariable int id) {

        personService.deletePerson((id));
        return ResponseEntity.noContent().build();
    }
}

