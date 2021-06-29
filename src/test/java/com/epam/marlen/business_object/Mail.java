package com.epam.marlen.business_object;

public class Mail {

    private static final String MAIL_SUBJECT = "Hello";
    private static final String MAIL_TEXT = "Hello World!";

    public String getLetterSubject() {
        return MAIL_SUBJECT;
    }

    public String getLetterText() {
        return MAIL_TEXT;
    }
}
