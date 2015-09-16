package com.interviewcoder.ood;

public class ReqFBConn implements Requirement {

    @Override
    public boolean isReqMet(Player player) {
        return player.isFbConnected();
    }

}
