package com.test.cleanarchitecture.mailformat;


import com.test.cleanarchitecture.entity.Mail;
import org.json.JSONObject;

public class JsonMailFormat implements MailFormat {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String getResult(Mail mail) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", mail.getSubject());
        jsonObject.put("content", mail.getContent());
        return jsonObject.toString();
    }
}
