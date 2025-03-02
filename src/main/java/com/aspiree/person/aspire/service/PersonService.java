package com.aspiree.person.aspire.service;

import com.aspiree.person.aspire.dto.AddressDto;
import com.aspiree.person.aspire.dto.PersonDto;

import com.aspiree.person.aspire.dto.ProjectDto;
import com.aspiree.person.aspire.model.Address;
import com.aspiree.person.aspire.model.Person;
import com.aspiree.person.aspire.model.Project;
import com.aspiree.person.aspire.repository.PersonIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.xml.transform.Result;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonIRepository personIRepository;

    @Autowired
    private  ProjectService projectService;

    @Autowired
    private AddressService addressService;

//    private List<Person> persons = new ArrayList<>(Arrays.asList(new Person(101, "Joh", "Doe"), new Person(102, "Anuj", "Sood"),
//            new Person(103, "Neetu", "Sood"),new Person(104, "Ritu", "Karol"),
//            new Person(105, "Neeraj", "Gautam"),new Person(106, "Avinash", "Kandukuri")));


    public List<PersonDto> getAllPersonsList(){
        final List<Person> persons = personIRepository.findAll();
        System.out.println("persons" + persons);
        final List<PersonDto> result = toDto(persons);
        System.out.println("result" + " " + result);
        return  result;
//        System.out.println(dataSource);
//        return persons;
    }

    private List<PersonDto> toDto(List<Person> persons) {
        System.out.println("toDto persons" + " " + persons);
        return persons.stream()
                .map(person -> toDto(person))
                .collect(Collectors.toList());
    }

    private PersonDto toDto(Person person) {
        PersonDto result = new PersonDto();
        result.setId((person.getId()));
        result.setFirstName(person.getFirstName());
        result.setLastName(person.getLastName());
        result.setFullName(person.getFirstName() + " " + person.getLastName());

        final Project project = person.getProject();
        final ProjectDto projectDto = projectService.toDto(project);
        result.setProjectDto(projectDto);

        final Set<Address> addresses = person.getAddresses();
        final Set<AddressDto> addressDtos = addressService.toDto(addresses);
        result.setAddressDtoSet(addressDtos);

        System.out.println("toDto person" + " " + result);
            return result;
    }

    private Person toEntity(PersonDto personDto) {
        Person result = new Person();
        result.setId((personDto.getId()));
        result.setFirstName(personDto.getFirstName());
        result.setLastName(personDto.getLastName());

        final ProjectDto projectDto = personDto.getProjectDto();
        final Project project =  projectService.toEntity(projectDto);

        result.setProject(project);

        // bidirectional relation
        final Set<AddressDto> addressDto = personDto.getAddressDtoSet();
        final Set<Address> addresses =  addressService.toEntity(addressDto);
        result.setAddresses(addresses);


        addresses.forEach(address -> {
            address.setPerson(result);
        });



        return result;
    }

    public PersonDto getPersonById(int id) {
        final Optional<Person> optionalPerson = personIRepository.findById(id);
        final PersonDto result = optionalPerson.map(person -> toDto(person)).orElse((null));
        return result;
//        return optionalPerson.orElse(null);
        //        return persons.stream()
//                .filter(person -> person.getId() == id)
//                .findFirst()
//                .orElse(null);
    }





    public  PersonDto updatePerson(PersonDto personDto) {
        final Person person = toEntity(personDto);
        final Person savedperson = personIRepository.save(person);
        return toDto(savedperson);
//        persons.removeIf((p->p.getId()==person.getId()));
//        persons.add(person);
//        return persons.stream()
//                .filter(p -> p.getId() == person.getId())
//                .findFirst()
//                .orElse(null);
    }


    public  void deletePerson(int id) {
        personIRepository.deleteById(id);
//        persons.removeIf(p->p.getId()== id);
    }


    public  PersonDto createPerson(PersonDto personDto) {
        final Person person = toEntity(personDto);
        final Person savedperson = personIRepository.save(person);
        return toDto(savedperson);
//        persons.add(person);
//        return persons.stream()
//                .filter(p -> p.getId() == person.getId())
//                .findFirst()
//                .orElse(null);
    }


}
