package com.example.translate.repository;

import com.example.translate.entity.History;
import com.example.translate.entity.OrderForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderFormRepository extends CustomizedRepoistory<OrderForm, Integer> {
    @Query("SELECT c FROM OrderForm c WHERE c.userInformation.id=:id")
    List<OrderForm> findByUserId(@Param("id") int id);
    @Query("SELECT c FROM OrderForm c WHERE c.status=0")
    List<OrderForm> findByStatus();
    @Query("SELECT c FROM OrderForm c WHERE c.translator.id=:id")
    List<OrderForm> findByTranslatorId(@Param("id") int id);
}
