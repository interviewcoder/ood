package com.pocketgems.zoo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.pocketgems.zoo.Item.ItemType;

public class Player {
    
    private int _pid;         // player's id
    
    private String _username; // player's user name 
    
    private int _level;       // player's level
 
    private int _coins;       // player's coins
    
    private boolean _fbconnected; // whether player has connected facebook account
    
    // items that player has so far
    private Map<ItemType, Item> _items = new HashMap<>();
    
    // a set of achievements' id that player has earned
    private Set<Achievement> _claimedAchievements = new HashSet<>();
    
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
    
    /**
     * Returns true if this player has connected Facebook account.
     * 
     * @return true if this player has connected Facebook account
     */
    public boolean isFbConnected() {
        return _fbconnected;
    }

    /**
     * Returns true if player has achieved this achievement.
     * 
     * @param achievement achievement
     * @return true if player has achieved this achievement
     */
    public boolean hasAchievement(Achievement achievement) {
        return _claimedAchievements.contains(achievement);
    }

    /**
     * Adds the achievement id to this player.
     * 
     * @param achievement 
     * @return true if this achievement is successfully added to player
     */
    public boolean addAchievement(Achievement achievement) {
        return _claimedAchievements.add(achievement);
    }

    /**
     * Adds the quantity of given of type of item.
     * 
     * @param type
     * @param quantity
     */
    public void addItemQuantity(ItemType type, int quantity) {
        if (hasItem(type)) {
            int q = _items.get(type).getQuantity() + quantity;
            _items.get(type).setQuantity(q);
        } else {
            Item item = new Item(type, quantity);
            _items.put(type, item);
        }
    }

}
