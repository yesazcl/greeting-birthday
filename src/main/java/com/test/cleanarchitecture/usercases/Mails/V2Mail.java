package com.test.cleanarchitecture.usercases.Mails;


import com.test.cleanarchitecture.entity.Mail;
import com.test.cleanarchitecture.model.MailInputModel;

public class V2Mail implements Mail {

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
        if ("Male".equals(mailInputModel.getGender())) {
            return String.format("Happy birthday, dear %s!\n", mailInputModel.getFirstName()) +
                    "We offer special discount 20% off for the following items:\n" +
                    "White Wine, iPhone X";
        } else if ("Female".equals(mailInputModel.getGender())) {
            return String.format("Happy birthday, dear %s!\n", mailInputModel.getFirstName()) +
                    "We offer special discount 50% off for the following items:\n" +
                    "Cosmetic, LV Handbags";

        }

        return "";

    }
}
