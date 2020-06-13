package com.example.translate.repository;

import com.example.translate.entity.Collection;
import com.example.translate.entity.History;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepository extends CustomizedRepoistory<Collection, Integer>{
    @Query("SELECT c FROM Collection c WHERE c.userInformation.id=:id")
    List<Collection> findByUserId(@Param("id") int id);

}
