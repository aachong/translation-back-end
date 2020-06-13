package com.example.translate.repository;

import com.example.translate.entity.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends CustomizedRepoistory<Topic, Integer>  {
    @Query("SELECT t FROM Topic t WHERE t.title Like :name")
    List<Topic> findByTitle(@Param("name") String name);

    @Query("SELECT t FROM Topic t WHERE t.who Like :name")
    List<Topic> findByWho(@Param("name") String name);
}
