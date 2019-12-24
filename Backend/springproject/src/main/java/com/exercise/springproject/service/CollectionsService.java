package com.exercise.springproject.service;

import com.exercise.springproject.domain.collections;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollectionsService {
    public collections save(collections collections);
    public void deleteCollectionsById(int id);
    public List<Integer> findCollectionsByid(int id);
    List<collections> findAll();
}
