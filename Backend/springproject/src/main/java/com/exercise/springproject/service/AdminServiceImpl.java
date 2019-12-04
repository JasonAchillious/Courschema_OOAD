package com.exercise.springproject.service;


import com.exercise.springproject.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements  AdminService{

    @Autowired
    private AdminService adminService;
    @Override
    public Admin findAdminByIdAdmin(int id) {
        return adminService.findAdminByIdAdmin(id);
    }
}
