package never_use_switch;

import java.lang.annotation.Repeatable;


@Repeatable(MailCodes.class)
public @interface MailCode {
    int value();
}


