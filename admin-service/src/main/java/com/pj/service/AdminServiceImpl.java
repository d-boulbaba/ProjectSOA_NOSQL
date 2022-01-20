package com.pj.service;

import com.pj.model.Admin;
import com.pj.repo.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService
{
    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository customerRepository)
    {
        this.adminRepository =customerRepository;
    }

    @Override
    public Admin findByFirstName(String firstName)
    {
        return adminRepository.findByFirstName(firstName);
    }

    @Override
    public Optional<Admin> findByCin(Long cin)
    {
        return adminRepository.findByCin(cin);
    }
    @Override
    public List<Admin> findAll()
    {
        return adminRepository.findAll();
    }

    @Override
    public List<Admin> findByLastName(String lastName)
    {
        return adminRepository.findByLastName(lastName);
    }

    @Override
    public Admin insert(Admin customer)
    {
        return adminRepository.insert(customer);
    }
    @Override
    public void delete(Admin student) {
        adminRepository.delete(student);
    }
}
