package ru.tortiki.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.io.Serializable;

@MongoEntity(collection = "posts", database = "tortiki")
public class User extends PanacheMongoEntity implements Serializable {
    public User() {
    }
}
