package com.interviewcoder.ood;

import java.util.HashMap;
import java.util.Map;

public class Badge {
    
    private int id;
    
    private Map<Item, Integer> requirements = new HashMap<>();

    private Map<Item, Integer> rewards = new HashMap<>();

    public Map<Item, Integer> getRequirement() {
        return requirements;
    }
    
    public Map<Item, Integer> getRewards() {
        return rewards;
    }
    
    
}
