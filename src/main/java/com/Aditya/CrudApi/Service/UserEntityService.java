package com.Aditya.CrudApi.Service;

import com.Aditya.CrudApi.Entity.User;
import com.Aditya.CrudApi.Repository.UserEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class UserEntityService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserEntryRepository userEntryRepository;

    public void saveentry(User User)
    {
       userEntryRepository.save(User);
    }
    public  List<User> Alluser()
    {
        return userEntryRepository.findAll();
    }
    public void deleteuser(@PathVariable ObjectId id)
    {
        userEntryRepository.deleteById(id);
    }

    public User Findbyname(String name)
    {
       return userEntryRepository.findByusername(name);
    }
}
