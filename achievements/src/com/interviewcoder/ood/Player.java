package com.interviewcoder.ood;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.interviewcoder.ood.Item.ItemType;

public class Player {
    
    private int _id;
    
    private String _name; 
    
    private int _level;  // player's level
 
    private int _coins;  // player's coins
    
    private Map<Item, Integer> _items = new HashMap<>();
    
    private Set<Integer> _claimedAchievements = new HashSet<>();
    
    public Player(int id, String name) {
        this._id = id;
        this._name = name;
        this._level = 0;
        this._coins = 0;
    }

    public String getName() {
        return _name;
    }

    public int getLevel() {
        return _level;
    }

    public boolean hasItem(Item item) {
        return _items.containsKey(item);
    }
    
    /**
     * 
     * @param item
     * @return
     */
    public int getItemQuantity(Item item) {
        return hasItem(item) ? _items.get(item) : 0;
    }

    public boolean hasAchievement(Integer aid) {
        return false;
    }

}
