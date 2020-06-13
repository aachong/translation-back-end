package com.example.translate.repository;

import com.example.translate.entity.UserInformation;
import com.example.translate.entity.Vip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VipRepository extends CustomizedRepoistory<Vip, Integer> {
    @Query("SELECT u FROM Vip u WHERE u.userInformation.id=:id AND u.status=1")
    List<Vip> findByUserId(@Param("id")int id);
    @Query("SELECT u FROM Vip u WHERE u.userInformation.id=:id")
    List<Vip> findByUserID(@Param("id")int id);
}
