package com.test.cleanarchitecture.usercases.Mails;



import com.test.cleanarchitecture.entity.Mail;
import com.test.cleanarchitecture.model.MailInputModel;

import java.time.LocalDate;
import java.time.Period;

public class V3Mail implements Mail {

    private MailInputModel mailInputModel;

    public MailInputModel getMailInputModel() {
        return mailInputModel;
    }

    public void setMailInputModel(MailInputModel mailInputModel) {
        this.mailInputModel = mailInputModel;
    }

    @Override
    public String getSubject() {
        return "Subject:Happy birthday!";
    }

    @Override
    public String getContent() {

        Period period = Period.between(mailInputModel.getBirthday(), LocalDate.now());
        if (period.getYears() > 49) {
           return String.format("Happy birthday, dear %s!" +
                   " (A greeting picture here)", mailInputModel.getFirstName());
        }

        return String.format("Happy birthday, dear %s!", mailInputModel.getFirstName());


    }
}
