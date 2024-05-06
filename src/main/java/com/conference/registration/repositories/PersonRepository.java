package com.conference.registration.repositories;

import com.conference.registration.models.PersonModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<PersonModel, Long>{
    public Optional<ArrayList<PersonModel>> findPersonModelByEmail(String email);
    public Optional<ArrayList<PersonModel>> findPersonModelByName(String name);
}
