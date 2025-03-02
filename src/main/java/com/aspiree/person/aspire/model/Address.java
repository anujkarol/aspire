package com.aspiree.person.aspire.model;

import jakarta.persistence.*;

@Entity
public class Address {


    // Creating auto sql table
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "city", length = 20, nullable = true)
    private String city;

    @Column(name = "state", length = 20, nullable = true)
    private  String state;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private  Person person;

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
