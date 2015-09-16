package com.interviewcoder.ood;

public class ReqLevel implements Requirement {
    
    // required level for player
    private int _level;
    
    public ReqLevel(int level) {
        this._level = level;
    }

    @Override
    public boolean isReqMet(Player player) {
        return player.getLevel() >= _level;
    }

}
