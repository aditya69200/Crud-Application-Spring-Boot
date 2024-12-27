package com.Aditya.CrudApi.Repository;


import com.Aditya.CrudApi.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntryRepository extends MongoRepository<User, ObjectId> {

}
