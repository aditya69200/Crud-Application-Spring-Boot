package com.Aditya.CrudApi.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="users")
@Data
@NoArgsConstructor
public class User {

    @Id
    private ObjectId id;
    @NonNull
    @Indexed(unique=true)  //username should be unique and searching would be fast
    private String username;
    @NonNull
    private String password;
    @DBRef
    private List<Student> studentEnteriesx = new ArrayList<>();
}
