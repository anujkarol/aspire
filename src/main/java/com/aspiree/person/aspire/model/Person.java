package com.aspiree.person.aspire.model;

import com.aspiree.person.aspire.dto.AddressDto;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Person {


    // Creating auto sql table
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 20, nullable = false)
    private  String lastName;

    @OneToOne(targetEntity = Project.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private  Set<Address> addresses;

    public Project getProject() {
        return project;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public void setAddresses(Set<Address> addresses) {
       this.addresses = addresses;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }




    public Person(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
