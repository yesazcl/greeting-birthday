package com.test.cleanarchitecture.factory;

import com.test.cleanarchitecture.model.UserDsResponseModel;
import com.test.cleanarchitecture.usercases.Mails.V1Mail;
import com.test.cleanarchitecture.usercases.Mails.V2Mail;
import com.test.cleanarchitecture.usercases.Mails.V3Mail;
import com.test.cleanarchitecture.usercases.Mails.V4Mail;
import com.test.cleanarchitecture.entity.Mail;
import com.test.cleanarchitecture.model.MailInputModel;


public class BirthdayGreetingMailFactory implements MailFactory {
    @Override
    public Mail create(UserDsResponseModel userDsResponseModel, String version) {

        if ("V1".equalsIgnoreCase(version) || null == version) {
            V1Mail v1Mail = new V1Mail();
            v1Mail.setMailInputModel(new MailInputModel(userDsResponseModel.getFirstName(), userDsResponseModel.getLastName(), userDsResponseModel.getGender(), userDsResponseModel.getBirthday()));
            return v1Mail;
        }

        if ("V2".equalsIgnoreCase(version)) {
            V2Mail v2Mail = new V2Mail();
            v2Mail.setMailInputModel(new MailInputModel(userDsResponseModel.getFirstName(), userDsResponseModel.getLastName(), userDsResponseModel.getGender(), userDsResponseModel.getBirthday()));
            return v2Mail;
        }

        if ("V3".equalsIgnoreCase(version)) {
            V3Mail v3Mail =  new V3Mail();
            v3Mail.setMailInputModel(new MailInputModel(userDsResponseModel.getFirstName(), userDsResponseModel.getLastName(), userDsResponseModel.getGender(), userDsResponseModel.getBirthday()));
            return v3Mail;
        }

        if ("V4".equalsIgnoreCase(version)) {
            V4Mail v4Mail =  new V4Mail();
            v4Mail.setMailInputModel(new MailInputModel(userDsResponseModel.getFirstName(), userDsResponseModel.getLastName(), userDsResponseModel.getGender(), userDsResponseModel.getBirthday()));
            return v4Mail;
        }

        return null;
    }
}
