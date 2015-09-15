package com.interviewcoder.ood;

public class RequirementLevel implements Requirement {
    
    private int _level;
    
    public RequirementLevel(int level) {
        this._level = level;
    }

    @Override
    public boolean isReqMet(Player player) {
        return player.getLevel() >= _level;
    }

}
