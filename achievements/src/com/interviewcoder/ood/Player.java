package com.interviewcoder.ood;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.interviewcoder.ood.Item.ItemType;

public class Player {
    
    private int _pid;         // player's id
    
    private String _username; // player's username 
    
    private int _level;       // player's level
 
    private int _coins;       // player's coins
    
    private boolean _fbconnected; 
    
    // items that player has
    private Map<ItemType, Item> _items = new HashMap<>();
    
    // a set of achievements' id that player has earned
    private Set<Integer> _claimedAchievements = new HashSet<>();
    
    /** Creates a new player */
    public Player(int id, String name) {
        this._pid = id;
        this._username = name;
        this._level = 0;
        this._coins = 0;
        this._fbconnected = false;
    }
    
    /**
     * Adds given number of coins to player and returns current number of coins.
     * 
     * @param num number of coins to be added to player
     * @return current number of coins player has
     */
    public int addCoins(int num) {
        _coins += num;
        return _coins;
    }
    
    /**
     * Gets current number of coins player has.
     * 
     * @return current number of coins player has
     */
    public int getCoins() {
        return _coins;
    }
    
    /**
     * Gets player's id.
     * 
     * @return player's id
     */
    public int getId() {
        return _pid;
    }

    /**
     * Gets player's user name.
     * 
     * @return player's user name
     */
    public String getName() {
        return _username;
    }

    /**
     * Gets player's level.
     * 
     * @return player's level
     */
    public int getLevel() {
        return _level;
    }

    /**
     * Returns true if player has given item.
     * 
     * @param item
     * @return true if player has given item
     */
    public boolean hasItem(ItemType type) {
        return _items.containsKey(type);
    }
    
    /**
     * Gets the quantity of given items that player has.
     * 
     * @param item
     * @return
     */
    public int getItemQuantity(ItemType type) {
        return hasItem(type) ? _items.get(type).getQuantity() : 0;
    }
    
    public boolean isFbConnected() {
        return _fbconnected;
    }

    /**
     * Returns true if player has achieved this achievement.
     * 
     * @param aid achievement id
     * @return
     */
    public boolean hasAchievement(int aid) {
        return false;
    }

    /**
     * Adds the achievement id to this player.
     * 
     * @param aid
     * @return
     */
    public boolean addAchievement(int aid) {
        return _claimedAchievements.add(aid);
    }

}
