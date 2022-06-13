package com.test.cleanarchitecture.factory;

import com.test.cleanarchitecture.model.UserDsResponseModel;
import com.test.cleanarchitecture.entity.Mail;

public interface MailFactory {
    Mail create(UserDsResponseModel userDsResponseModel, String version);
}
