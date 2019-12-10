package com.exercise.springproject.service;

import com.exercise.springproject.api.XianXiuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XianxiuServiceImpl implements XianxiuService{
    @Autowired
    private XianXiuRepository xianXiuRepository;
}
