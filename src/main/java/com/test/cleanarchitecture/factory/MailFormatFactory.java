package com.test.cleanarchitecture.factory;

import com.test.cleanarchitecture.mailformat.JsonMailFormat;
import com.test.cleanarchitecture.mailformat.MailFormat;
import com.test.cleanarchitecture.mailformat.RawStringMailFormat;
import com.test.cleanarchitecture.mailformat.XMLMailFormat;

public class MailFormatFactory implements FormatFactory {


    @Override
    public MailFormat create(String format) {
        if ("json".equalsIgnoreCase(format)) {
            return new JsonMailFormat();
        }
        else if ("xml".equalsIgnoreCase(format)) {
            return new XMLMailFormat();
        }

        return new RawStringMailFormat();
    }
}
