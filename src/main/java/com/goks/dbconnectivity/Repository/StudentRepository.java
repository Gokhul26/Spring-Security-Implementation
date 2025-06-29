package com.goks.dbconnectivity.Repository;

import com.goks.dbconnectivity.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // You get basic CRUD methods out of the box
}
