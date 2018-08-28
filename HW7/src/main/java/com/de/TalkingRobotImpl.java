package com.de;

import java.util.List;

public class TalkingRobotImpl implements TalkingRobot {
    List<Quoter> quoters;

    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    public void talk() {
        quoters.forEach(Quoter::say);
    }
}
