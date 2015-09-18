package com.pocketgems.zoo;

import java.util.HashSet;
import java.util.Set;

/**
 * This is a zoo gaming system. There is an achievement manager who will
 * give player achievements and rewards when player is qualified for some achievements.
 * 
 * @author Steven Cooks
 */
public class Zoo {
    // map of <player id, player>
    Set<Player> _players = new HashSet<>();

    // achievement manager of this zoo
    AchieveManager _AM = new AchieveManager();

    public Zoo() {
        run();
    }

    private void run() {
        for (Player player : _players) {
            _AM.checkAchievements(player);
        }
    }
    
}
