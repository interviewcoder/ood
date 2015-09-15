package com.interviewcoder.ood;

import java.util.HashMap;
import java.util.Map;

public class AchieveManager {

    private Map<Integer, Achievement> achievements = new HashMap<>();
    
    public AchieveManager() {

    }
    
    public void checkAchievement(Player player) {
        for (Integer aid : achievements.keySet()) {
            if (!player.hasAchievement(aid) && achievements.get(aid).checkRequirements(player)) {
                achievements.get(aid).rewardPlayer(player);
            }
        }
    }

}
