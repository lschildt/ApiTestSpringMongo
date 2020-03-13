package org.schildt.ApiTestSpringMongo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Id;
import org.bson.types.ObjectId;

public class Product {

    @Id
    public String _id;

    @JsonProperty("ProductName")
    private String name;

    @JsonProperty("ProductDescription")
    private String description;

    @JsonProperty("ProductPrice")
    private Integer price;

    public Product(String _id, String name, String description, Integer price) {
        this._id = _id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String ProductName) {
        this.name = ProductName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String ProductDescription) {
        this.description = ProductDescription;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer ProductPrice) {
        this.price = ProductPrice;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
