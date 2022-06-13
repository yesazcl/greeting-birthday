package com.test.cleanarchitecture.usercases.Mails;


import com.test.cleanarchitecture.entity.Mail;
import com.test.cleanarchitecture.model.MailInputModel;

public class V1Mail implements Mail {

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
        return String.format("Happy birthday, dear %s!", mailInputModel.getFirstName());
    }
}
