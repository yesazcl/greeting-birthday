package com.test.cleanarchitecture.mailformat;


import com.test.cleanarchitecture.entity.Mail;

public class RawStringMailFormat implements MailFormat {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String getResult(Mail mail) {
        return String.format("%s\n%s", mail.getSubject(), mail.getContent());
    }
}
