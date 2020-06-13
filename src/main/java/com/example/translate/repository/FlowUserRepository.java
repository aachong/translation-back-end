package com.example.translate.repository;

import com.example.translate.entity.FlowUser;
import com.example.translate.entity.History;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowUserRepository extends CustomizedRepoistory<FlowUser, Integer> {
    @Query("SELECT c FROM FlowUser c WHERE c.userInformation.id=:id")
    List<FlowUser> findByUserId(@Param("id") int id);
}
