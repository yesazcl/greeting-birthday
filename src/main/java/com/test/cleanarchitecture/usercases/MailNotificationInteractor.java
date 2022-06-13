package com.test.cleanarchitecture.usercases;

import com.test.cleanarchitecture.database.UserDsGateway;
import com.test.cleanarchitecture.entity.Mail;
import com.test.cleanarchitecture.factory.FormatFactory;
import com.test.cleanarchitecture.factory.MailFactory;
import com.test.cleanarchitecture.model.UserDsResponseModel;
import com.test.cleanarchitecture.model.UserRequestModel;

import java.util.List;

public class MailNotificationInteractor implements UserInputBoundary {

    private final UserDsGateway userDsGateway;
    private final MailFactory mailFactory;

    private final FormatFactory formatFactory;

    public MailNotificationInteractor(UserDsGateway userRegisterDfGateway,
                                      MailFactory mailFactory,
                                      FormatFactory formatFactory) {
        this.userDsGateway = userRegisterDfGateway;
        this.mailFactory = mailFactory;
        this.formatFactory = formatFactory;
    }


    @Override
    public String findByBirthday(UserRequestModel requestModel, String version, String outputFormat) {


        List<UserDsResponseModel> responseModels = userDsGateway.findBirthdayByDate(requestModel.getBirthMonth(), requestModel.getBirthDay());
        String finalResult = "";
        for (UserDsResponseModel userDsResponseModel : responseModels) {
            Mail mail = mailFactory.create(userDsResponseModel, version);

            String result = formatFactory.create(outputFormat).getResult(mail);
            if (finalResult.equals("")) {
                finalResult = result;
            } else {
                finalResult = result + "\n" + finalResult;
            }
        }
        return finalResult;

    }

    @Override
    public List<UserDsResponseModel> getAllUser() {
        List<UserDsResponseModel> responseModels = userDsGateway.findAll();
        return responseModels;
    }
}