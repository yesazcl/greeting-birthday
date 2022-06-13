package com.test.cleanarchitecture.database;

import com.test.cleanarchitecture.model.UserDsRequestModel;
import com.test.cleanarchitecture.model.UserDsResponseModel;

import java.util.List;

public interface UserDsGateway {
    void save(UserDsRequestModel requestModel);

    List<UserDsResponseModel> findBirthdayByDate(String birthMonth, String birthDay);

    List<UserDsResponseModel> findAll();

}
