package com.pj.repo;

import java.util.List;
import java.util.Optional;

import com.pj.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String>
{
    Student findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    Optional<Student> findByCin(Long cin);




}
