package org.schildt.ApiTestSpringMongo.controller;

import java.util.List;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.schildt.ApiTestSpringMongo.model.Person;
import org.schildt.ApiTestSpringMongo.model.Product;
import org.schildt.ApiTestSpringMongo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Product createProduct(@Valid @RequestBody Product product) {
        repository.save(product);
        return product;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") String id) {
        return repository.findById(id).get();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void modifyPersonById(@PathVariable("id") String id, @Valid @RequestBody Product product) {
        product.set_id(id);
        repository.save(product);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deletePerson(@PathVariable String id) {
        repository.delete(repository.findById(id).get());
    }

}
