package com.test.cleanarchitecture.repository;


import com.test.cleanarchitecture.entity.UserDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaUserRepository extends JpaRepository<UserDataMapper, String> {

    @Query("SELECT p " +
            "FROM UserDataMapper p " +
            "WHERE SUBSTRING(CONCAT(p.birthday, ''), 6, 2) = :birthMonth " +
            "AND SUBSTRING(CONCAT(p.birthday, ''), 9, 2) = :birthDay ")
    List<UserDataMapper> findBirthdayByDate(@Param("birthMonth") String birthMonth, @Param("birthDay") String birthDay);
}
