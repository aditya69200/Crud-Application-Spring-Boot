package com.Aditya.CrudApi.Service;

import com.Aditya.CrudApi.Entity.Student;
import com.Aditya.CrudApi.Entity.User;
import com.Aditya.CrudApi.Repository.StudentEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class StudentEntityService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private StudentEntryRepository studentEntryRepository;

    @Autowired
    private UserEntityService userEntityService;

    public void saveStudent(Student student,String UserName) {
        User user=userEntityService.Findbyname(UserName);
        studentEntryRepository.save(student);
        String st= student.getId().toString();
        user.getStudentEnteriesx().add(student);
        userEntityService.saveentry(user);
    }

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

    @Transactional
    public void deletebyid(String id,String UserName)
    {
        User user = userEntityService.Findbyname(UserName );

        // Remove the specific student ID from the user's studentEnteriesx
        boolean removed = user.getStudentEnteriesx().removeIf(studentId -> studentId.equals(id));

        // If the entry is removed, update the user entity and delete the student
        if (removed) {
            userEntityService.saveentry(user); // Update the user with modified studentEnteriesx
            studentEntryRepository.deleteById(id); // Delete the student entry from the repository
        } else {
            throw new IllegalArgumentException("Student ID not found in user's entries");
        }
        studentEntryRepository.delete(studentEntryRepository.findById(id).get());
    }
}
