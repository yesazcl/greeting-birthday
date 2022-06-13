package com.test.cleanarchitecture.mailformat;

import com.test.cleanarchitecture.entity.Mail;

public interface MailFormat {
    String getResult(Mail mail);
}
