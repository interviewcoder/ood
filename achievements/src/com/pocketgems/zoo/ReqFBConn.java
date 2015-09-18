package com.pocketgems.zoo;

public class ReqFBConn implements Requirement {

    @Override
    public boolean isReqMet(Player player) {
        return player.isFbConnected();
    }

}
