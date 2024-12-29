package com.Aditya.CrudApi.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection="Student_Entry")
public class Student {

    @Id
    private String id;
    @NonNull
    private String name;
    private int age;
    private String studentClass;
}
