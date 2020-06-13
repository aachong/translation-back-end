package com.example.translate.repository;

import com.example.translate.entity.FlowTranslator;
import com.example.translate.entity.FlowUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowTranslatorRepository extends CustomizedRepoistory<FlowTranslator, Integer> {
    @Query("SELECT c FROM FlowTranslator c WHERE c.translator.id=:id")
    List<FlowTranslator> findByTranslatorId(@Param("id") int id);

}
