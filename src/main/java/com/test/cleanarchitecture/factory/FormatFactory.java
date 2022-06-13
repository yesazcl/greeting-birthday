package com.test.cleanarchitecture.factory;

import com.test.cleanarchitecture.mailformat.MailFormat;

public interface FormatFactory {
    MailFormat create(String format);
}
