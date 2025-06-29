package com.goks.dbconnectivity.Controller;

//import org.springframework.web.bind.annotation.;
import com.goks.dbconnectivity.Model.Student;
import com.goks.dbconnectivity.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/users")
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/users/{id}")
    public Student getOne(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/add")
    public Student create(@RequestBody Student student) {
        return service.save(student);
    }

    @PutMapping("/update/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        Student existing = service.getById(id);
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        return service.save(existing);
    }

    @PutMapping("/update-password/{id}")
    public ResponseEntity<String> updatePassword(
            @PathVariable Long id,
            @RequestBody String newPassword) {
        service.updatePassword(id, newPassword);
        return ResponseEntity.ok("Password updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
