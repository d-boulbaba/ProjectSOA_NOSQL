package com.pj.repo;

import java.util.List;
import java.util.Optional;

import com.pj.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String>
{
    Admin findByFirstName(String firstName);
    List<Admin> findByLastName(String lastName);
    Optional<Admin> findByCin(Long cin);




}
