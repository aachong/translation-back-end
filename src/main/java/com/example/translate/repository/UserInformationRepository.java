package com.example.translate.repository;

import com.example.translate.entity.UserInformation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInformationRepository extends CustomizedRepoistory<UserInformation, Integer> {
    @Query("SELECT u FROM UserInformation u WHERE u.phone=:name AND u.password=:up")
    List<UserInformation> findByPhoneAndPassword(@Param("name")String name, @Param("up")String password);
    @Query("SELECT u FROM UserInformation u WHERE u.name=:name AND u.password=:up")
    List<UserInformation> findByNameAndPassword(@Param("name")String name, @Param("up")String password);
    @Query("SELECT u FROM UserInformation u WHERE u.name=:name OR u.phone=:phone")
    List<UserInformation> findByNameOrPhone(@Param("name")String name, @Param("phone")String phone);

}
