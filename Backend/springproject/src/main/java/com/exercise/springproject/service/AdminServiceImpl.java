package com.exercise.springproject.service;


import com.exercise.springproject.api.AdminRepository;
import com.exercise.springproject.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements  AdminService{

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public Admin findAdminByIdAdmin(int id) {
        return adminRepository.findAdminByIdAdmin(id);
    }
}
