package com.pj.service;

import com.pj.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService
{
    Admin findByFirstName(String firstName);
    Optional<Admin> findByCin(Long Cin);
     List<Admin> findAll();
    List<Admin> findByLastName(String lastName);
    Admin insert(Admin customer);
     void delete(Admin student);
}
