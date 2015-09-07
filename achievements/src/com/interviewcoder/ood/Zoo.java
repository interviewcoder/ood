package com.interviewcoder.ood;

import java.util.HashMap;
import java.util.Map;

public class Zoo {
    
    private Map<String, Player> players = new HashMap<>();
    
    private AchieveManager manager;
    
    public Zoo() {
        manager = new AchieveManager();
    }
    
    public void addPlayer(Player player) {
        if (!players.containsKey(player.getName())) {
            players.put(player.getName(), player);
        }
    }
    
    public static void main(String[] args) {
        
    }

}
