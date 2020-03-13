package org.schildt.ApiTestSpringMongo.repositories;

import org.bson.types.ObjectId;
import org.schildt.ApiTestSpringMongo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

    Person findBy_id(ObjectId id);
}
