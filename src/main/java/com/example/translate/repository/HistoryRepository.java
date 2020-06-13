package com.example.translate.repository;

import com.example.translate.entity.Content;
import com.example.translate.entity.History;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends CustomizedRepoistory<History, Integer> {
    @Query("SELECT c FROM History c WHERE c.userInformation.id=:id")
    List<History> findByUserId(@Param("id") int id);
}
