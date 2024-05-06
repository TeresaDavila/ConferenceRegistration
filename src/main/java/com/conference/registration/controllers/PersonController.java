package com.conference.registration.controllers;

import com.conference.registration.models.PersonModel;
import com.conference.registration.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService service;

    @PostMapping()
    public PersonModel savePerson(@RequestBody PersonModel person) { return service.savePerson(person); }

    @PutMapping()
    public PersonModel editPerson(@RequestBody PersonModel student){
        return service.editPerson(student);
    }

    @GetMapping()
    public ArrayList<PersonModel> getAllPersons(){
        return service.getAllPersons();
    }

    @GetMapping("/findPersonById/{id}")
    public Optional<PersonModel> findPersonById(@PathVariable Long id){
        return service.findPersonById(id);
    }

    @GetMapping("/findPersonByEmail/{email}")
    public Optional<ArrayList<PersonModel>> findPersonByEmail(@PathVariable String email){
        return service.findPersonByEmail(email);
    }

    @GetMapping("/findPersonByName/{name}")
    public Optional<ArrayList<PersonModel>> findPersonByName(@PathVariable String name){
        return service.findPersonByName(name);
    }
    @DeleteMapping("/delete-person-by-id")
    public String deletePersonById(@RequestParam("id") Long id){
        return service.deletePersonById(id);
    }
}

