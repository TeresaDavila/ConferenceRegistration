package com.conference.registration.services;

import com.conference.registration.models.PersonModel;
import com.conference.registration.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    //CRUD
    public PersonModel savePerson(PersonModel person){
        if(repository.findPersonModelByEmail(person.getEmail()).toString().equals("Optional[[]]")){
            return repository.save(person);
        }else{
            PersonModel personError = new PersonModel();
                personError.setId(-1L);
            return personError;
        }
    }

    public ArrayList<PersonModel> getAllPersons(){ return (ArrayList<PersonModel>) repository.findAll();}
    public Optional<PersonModel> findPersonById(Long id){ return repository.findById(id); }

    public PersonModel editPerson(PersonModel person) {return repository.save(person); }
    public String deletePersonById(Long id){
        if(findPersonById(id).isPresent()){
            repository.deleteById(id);
            return "Deleted sccessfully";
        }else{
            return "The id "+id+" was not found";
        }
    }

    public Optional<ArrayList<PersonModel>> findPersonByEmail(String email){
        return repository.findPersonModelByEmail(email);
    }
    public Optional<ArrayList<PersonModel>> findPersonByName(String name){
        return repository.findPersonModelByName(name);
    }
}
