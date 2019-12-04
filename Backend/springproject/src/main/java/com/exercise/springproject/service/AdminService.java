package com.exercise.springproject.service;

import com.exercise.springproject.domain.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    public Admin findAdminByIdAdmin(int id);
}
