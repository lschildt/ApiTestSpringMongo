package org.schildt.ApiTestSpringMongo.repositories;

import org.schildt.ApiTestSpringMongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
