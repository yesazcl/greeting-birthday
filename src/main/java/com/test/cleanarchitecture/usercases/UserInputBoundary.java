package com.test.cleanarchitecture.usercases;

import com.test.cleanarchitecture.model.UserDsResponseModel;
import com.test.cleanarchitecture.model.UserRequestModel;

import java.util.List;

public interface UserInputBoundary {
    String/*UserResponseModel*/ findByBirthday(UserRequestModel requestModel, String version, String outputFormat);

    List<UserDsResponseModel> getAllUser();
}
