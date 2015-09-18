package com.pocketgems.zoo;

import java.util.HashSet;
import java.util.Set;

public class AchieveManager {

    // Set of Achievement
    private Set<Achievement> _achievements = new HashSet<>();
    
    public AchieveManager() { 
        learnAchievements();
    }

    private void learnAchievements() {
        // TODO Auto-generated method stub
    }

    /**
     * Adds a new achievement to existing achievements.
     * 
     * @param achievement
     * @return
     */
    public boolean addAchievement(Achievement achievement) {
        return _achievements.add(achievement);
    }
    
    /**
     * Checks player whether meets achievements. If player succeeds in achieving
     * some achievement, then adds that achievement to player.
     * 
     * @param player
     */
    public void checkAchievements(Player player) {
        for (Achievement achievement : _achievements) {
            if (!player.hasAchievement(achievement) && achievement.checkRequirements(player)) {
                player.addAchievement(achievement);
                achievement.rewardPlayer(player);
            }
        }
    }

}
