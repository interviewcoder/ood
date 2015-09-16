package com.interviewcoder.ood;

import java.util.HashMap;
import java.util.Map;

public class AchieveManager {

    // Map of <AchievementID, Achievement>
    private Map<Integer, Achievement> _achievements = new HashMap<>();
    
    //TODO
    public AchieveManager() { }

    /**
     * Adds a new achievement to existing achievements.
     * 
     * @param achievement
     * @return
     */
    public boolean addAchievement(Achievement achievement) {
        int aid = achievement.getId();
        if (_achievements.containsKey(aid)) {
            return false;
        } else {
            _achievements.put(aid, achievement);
            return true;
        }
    }
    
    /**
     * Checks player whether meets achievements. If player succeeds in achieving
     * some achievement, then adds that achievement to player.
     * 
     * @param player
     */
    public void checkAchievements(Player player) {
        for (int aid : _achievements.keySet()) {
            if (!player.hasAchievement(aid) && _achievements.get(aid).checkRequirements(player)) {
                player.addAchievement(aid);
                _achievements.get(aid).rewardPlayer(player);
            }
        }
    }

}
