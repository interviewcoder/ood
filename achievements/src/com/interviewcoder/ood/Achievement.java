package com.interviewcoder.ood;

import java.util.ArrayList;
import java.util.List;

public class Achievement {

    // achievement id
    private int _aid;

    // achievement description text
    private String _description;

    // list of requirements for achieving this achievement
    private List<Requirement> _reqs = new ArrayList<>();

    // list of rewards that will be rewarded to player when requirements are met
    private List<Reward> _rewards = new ArrayList<>();

    /** Initializes a new achievement */
    public Achievement(int id, String description) {
        this._aid = id;
        this._description = description;
    }

    /**
     * Returns true if player meets all the requirements for this achievement.
     * 
     * @param player
     * @return true if player meets all the requirements for this achievement
     */
    public boolean checkRequirements(Player player) {
        for (Requirement req : _reqs) {
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
        if (checkRequirements(player)) {
            for (Reward reward : _rewards) {
                reward.reward(player);
            }
        }
    }

    /**
     * Gets the id of this achievement.
     * 
     * @return id of this achievement
     */
    public int getId() {
        return _aid;
    }
    
    /**
     * 
     * @return
     */
    public String getDescription() {
        return _description;
    }
    
}
