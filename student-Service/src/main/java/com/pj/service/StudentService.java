package com.pj.service;

import com.pj.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService
{
    Student findByFirstName(String firstName);
    Optional<Student> findByCin(Long Cin);
     List<Student> findAll();
    List<Student> findByLastName(String lastName);
    Student    insert(Student customer);
    public void delete(Student student);

}
