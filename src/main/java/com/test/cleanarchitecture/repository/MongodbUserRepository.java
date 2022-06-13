package com.test.cleanarchitecture.repository;


import com.test.cleanarchitecture.entity.UserDataMapper;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface MongodbUserRepository extends MongoRepository<UserDataMapper, String> {

    @Query("{'$expr': {'$and': [{'$eq': [{'$dayOfMonth': '$birthday'}, ?1]}, {'$eq': [{ '$month': '$birthday' }, ?0]}]}}")
    List<UserDataMapper> findAllUserById(int month, int day);
}
