package com.Aditya.CrudApi.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="Student_Entry")
public class Student {

    @Id
    private String id;
    private String name;
    private int age;
    private String studentClass;
}
