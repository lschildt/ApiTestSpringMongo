package org.schildt.ApiTestSpringMongo.model;

import javax.persistence.Id;
import org.bson.types.ObjectId;

public class Person {

    @Id
    public ObjectId _id;

    private String name;
    private int age;

    public Person(ObjectId _id, String name, int age) {
        this._id = _id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
