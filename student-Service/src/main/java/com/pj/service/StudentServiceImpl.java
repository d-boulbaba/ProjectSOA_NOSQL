package com.pj.service;

import com.pj.model.Student;
import com.pj.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService
{
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository   customerRepository)
    {
        this.studentRepository=customerRepository;
    }

    @Override
    public Student findByFirstName(String firstName)
    {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public Optional<Student> findByCin(Long cin)
    {
        return studentRepository.findByCin(cin);
    }
    @Override
    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findByLastName(String lastName)
    {
        return studentRepository.findByLastName(lastName);
    }

    @Override
    public Student insert(Student customer)
    {
        return studentRepository.insert(customer);
    }

    @Override
    public void delete(Student student) {
         studentRepository.delete(student);
    }
}
