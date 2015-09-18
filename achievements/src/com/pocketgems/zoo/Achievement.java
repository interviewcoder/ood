package com.pocketgems.zoo;

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
     * Gets the description of this achievement.
     * 
     * @return the description of this achievement
     */
    public String getDescription() {
        return _description;
    }
    
    /**
     * Returns true if two achievements have the same achievement id.
     * 
     * @param obj
     * @return true if two achievements have the same achievement id
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Achievement) || obj == null) {
            return false;
        } else if (this == obj) {
            return true;
        } else {
            return _aid == ((Achievement)obj).getId();
        }
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
}
