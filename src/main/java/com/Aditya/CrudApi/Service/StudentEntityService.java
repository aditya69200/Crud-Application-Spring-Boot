package com.Aditya.CrudApi.Service;

import com.Aditya.CrudApi.Entity.Student;
import com.Aditya.CrudApi.Repository.StudentEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class StudentEntityService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private StudentEntryRepository studentEntryRepository;

    public void SaveEntry(Student student)
    {
        studentEntryRepository.save(student);
    }

    public List<Student> getall()
    {
        return studentEntryRepository.findAll();
    }

    public void deleteone(@PathVariable String id)
    {
        studentEntryRepository.deleteById(id);

    }
}
