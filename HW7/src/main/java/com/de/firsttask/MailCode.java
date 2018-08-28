package com.de.firsttask;

import java.lang.annotation.Repeatable;


@Repeatable(MailCodes.class)
public @interface MailCode {
    int value();
}


