package com.example.translate.repository;

import com.example.translate.entity.Evaluation;
import com.example.translate.entity.EvaluationT;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends CustomizedRepoistory<Evaluation, Integer>{
    @Query("SELECT u FROM Evaluation u WHERE u.order.userInformation.id=:id")
    List<Evaluation> findByUid(@Param("id")int id);

    @Query("SELECT u  FROM Evaluation u WHERE u.order.translator.id=:id")
    List<Evaluation> findByTid(@Param("id")int id);

    @Query("SELECT u FROM Evaluation u WHERE u.order.id=:id")
    List<Evaluation> findByOid(@Param("id")int id);
}
