package com.Aditya.CrudApi.Repository;


import com.Aditya.CrudApi.Entity.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentEntryRepository extends MongoRepository<Student, String>
{

}
