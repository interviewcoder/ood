package com.interviewcoder.ood;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a zoo gaming system. There is an achievement manager who will
 * give player achievements and rewards if player is qualified.
 */
public class Zoo {
    
    // map of <player id, player>
    Map<Integer, Player> _players = new HashMap<>();
    
    // achievement manager of this zoo
    AchieveManager _AM = new AchieveManager();

    public Zoo() {
        run();
    }

    private void run() {
        for (Player player : _players.values()) {
            _AM.checkAchievements(player);
        }
    }
    
}
