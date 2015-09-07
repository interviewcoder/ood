package com.interviewcoder.ood;

import java.util.HashMap;
import java.util.Map;

public class AchieveManager {

    private Map<Integer, Badge> badges = new HashMap<>();
    
    public AchieveManager() {

    }
    
    public void award(Player player, Badge badge) {
        Map<Item, Integer> requires = badge.getRequirement();
    }


}
