package com.exercise.springproject.service;

import com.exercise.springproject.api.CollectionsRepository;
import com.exercise.springproject.domain.collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CollectionsServiceImpl implements CollectionsService{
    @Autowired
    private CollectionsRepository collectionsRepository;

    @Override
    public List<collections> findAll() {
        return collectionsRepository.findAll();
    }

    @Override
    public collections save(collections collections) {
        return collectionsRepository.save(collections);
    }

    @Override
    public List<Integer> findCollectionsByid(int id){
        return collectionsRepository.findCollectionsByid(id);
    }

    @Override
    public void deleteCollectionsById(int id, int courschema) {
        collectionsRepository.deleteById(id, courschema);
    }
}
