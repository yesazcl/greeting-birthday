package com.test.cleanarchitecture.process


import com.test.cleanarchitecture.database.UserDsGateway
import com.test.cleanarchitecture.factory.BirthdayGreetingMailFactory
import com.test.cleanarchitecture.factory.FormatFactory
import com.test.cleanarchitecture.factory.MailFactory
import com.test.cleanarchitecture.factory.MailFormatFactory
import com.test.cleanarchitecture.model.UserDsResponseModel
import com.test.cleanarchitecture.model.UserRequestModel
import com.test.cleanarchitecture.model.UserResponseModel
import com.test.cleanarchitecture.usercases.MailNotificationInteractor

import spock.lang.Specification

import java.time.LocalDate

class MailNotificationInteractorTest extends Specification {
    UserDsGateway userRegisterDfGateway = Mock(UserDsGateway)
    MailFactory mailFactory = new BirthdayGreetingMailFactory()
    FormatFactory formatFactory = new MailFormatFactory();

    def "test get greeting message"() {

        UserRequestModel requestModel = new UserRequestModel()
        requestModel.setBirthDay("08")
        requestModel.setBirthMonth("08")
        String version = "v1"
        String format = ""
        List<UserDsResponseModel> responseModels = new ArrayList<>()
        UserDsResponseModel userDsResponseModel = new UserDsResponseModel("L", "F", "Male", LocalDate.parse("1985-08-08"), "robert.yen@linecorp.com")
        responseModels.add(userDsResponseModel)

        given:
        MailNotificationInteractor mailNotificationInteractor = new MailNotificationInteractor(userRegisterDfGateway, mailFactory, formatFactory)
        userRegisterDfGateway.findBirthdayByDate("08", "08") >> responseModels
        when:

        String result = mailNotificationInteractor.findByBirthday(requestModel, version, format)
        then:
        result != ""
        result.contains("Happy birthday, dear F")
    }

    def "test no one is on birthday"() {

        UserRequestModel requestModel = new UserRequestModel()
        requestModel.setBirthDay("08")
        requestModel.setBirthMonth("08")
        String version = "v1"
        String format = ""
        List<UserDsResponseModel> responseModels = new ArrayList<>()

        given:
        MailNotificationInteractor mailNotificationInteractor = new MailNotificationInteractor(userRegisterDfGateway, mailFactory, formatFactory)
        userRegisterDfGateway.findBirthdayByDate("08", "08") >> responseModels
        when:

        UserResponseModel userResponseModel = mailNotificationInteractor.findByBirthday(requestModel, version, format)
        then:
        result == ""

    }
}
