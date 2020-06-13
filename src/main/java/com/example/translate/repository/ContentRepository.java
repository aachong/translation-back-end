package com.example.translate.repository;

import com.example.translate.entity.Content;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends CustomizedRepoistory<Content, Integer>  {
    @Query("SELECT c FROM Content c WHERE c.topic.id=:id")
    List<Content> findByTopicId(@Param("id") int id);
}
