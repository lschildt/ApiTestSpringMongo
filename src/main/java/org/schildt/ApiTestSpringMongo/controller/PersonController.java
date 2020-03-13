package org.schildt.ApiTestSpringMongo.controller;


import java.util.List;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.schildt.ApiTestSpringMongo.model.Person;
import org.schildt.ApiTestSpringMongo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPersonById(@PathVariable("id") ObjectId id, @Valid @RequestBody Person person) {
        person.set_id(id);
        repository.save(person);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Person createPerson(@Valid @RequestBody Person person) {
        person.set_id(ObjectId.get());
        repository.save(person);
        return person;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}
