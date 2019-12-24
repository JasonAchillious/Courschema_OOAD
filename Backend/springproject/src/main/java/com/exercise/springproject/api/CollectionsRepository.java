package com.exercise.springproject.api;

import com.exercise.springproject.domain.collections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CollectionsRepository extends JpaRepository<collections, Integer> {
    //@Query("select p from collections p where p.idStu=?1")
    @Query("select p.courschema from collections p where p.id=?1")
    public List<Integer> findCollectionsByid(int id);

    @Query("select p from collections p")
    public List<collections> findAll();

    @Modifying
    @Transactional
    @Query("delete from collections where id=?1")
    void deleteById(int id, int courschema);
}
