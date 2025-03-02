package com.aspiree.person.aspire.dto;

import java.util.Set;

public class PersonDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String fullName;

    private ProjectDto projectDto;
    private Set<AddressDto> addressDtoSet; // because a person can be tagged to multiple asdress

    public String getFullName() {
        return fullName;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public ProjectDto getProjectDto() {
        return projectDto;
    }

    public void setProjectDto(ProjectDto projectDto) {
        this.projectDto = projectDto;
    }

    public Set<AddressDto> getAddressDtoSet() {
        return addressDtoSet;
    }

    public void setAddressDtoSet(Set<AddressDto> addressDtoSet) {
        this.addressDtoSet = addressDtoSet;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
