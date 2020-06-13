package com.example.translate.repository;

import com.example.translate.entity.Translator;
import com.example.translate.entity.UserInformation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslatorRepository extends CustomizedRepoistory<Translator, Integer> {
    @Query("SELECT u FROM Translator u WHERE u.phone=:name AND u.password=:up")
    List<Translator> findByPhoneAndPassword(@Param("name")String name, @Param("up")String password);
    @Query("SELECT u FROM Translator u WHERE u.name=:name AND u.password=:up")
    List<Translator> findByNameAndPassword(@Param("name")String name, @Param("up")String password);
    @Query("SELECT u FROM Translator u WHERE u.name=:name OR u.phone=:phone")
    List<Translator> findByNameOrPhone(@Param("name")String name, @Param("phone")String phone);

}
