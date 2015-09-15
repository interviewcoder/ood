package com.interviewcoder.ood;

import java.util.ArrayList;
import java.util.List;

public class Achievement {
    
    private int id;
    
    private String description;
    
    private List<Requirement> reqs = new ArrayList<>();
    
    private List<Reward> rewards = new ArrayList<>();
    
    public Achievement(int id, String description) {
        this.id = id;
        this.description = description;
    }
    
    //TODO: API, add or set?
    public void setRequirements(List<Requirement> reqs) {
        this.reqs = reqs;
    }
    
    /**
     * Returns true if player meets all the requirements for this achievement.
     * 
     * @param player
     * @return true if player meets all the requirements for this achievement
     */
    public boolean checkRequirements(Player player) {
        for (Requirement req : reqs) {
            if (!req.isReqMet(player)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * If player meets all the requirements, then rewards this player.
     * 
     * @param player
     */
    public void rewardPlayer(Player player) {
        for (Reward reward : rewards) {
            reward.reward(player);
        }
    }

}
