package com.goks.dbconnectivity.Service;

import com.goks.dbconnectivity.Model.Student;
import com.goks.dbconnectivity.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student save(Student s) {
        return repo.save(s);
    }

    public Student getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void assignPassToExistingOnes(String s) {
        List<Student> students = repo.findAll();
        for (Student student : students) {
            if(student.getPassword() == null || student.getPassword().isBlank()){
                student.setPassword(passwordEncoder.encode(s));
            }
        }
        repo.saveAll(students);
    }

    public void updatePassword(Long id, String rawPassword) {
        Student student = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setPassword(passwordEncoder.encode(rawPassword)); // ✅ BCrypt hash
        repo.save(student);
    }

}
