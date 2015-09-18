package com.pocketgems.zoo;

public class Item implements Requirement, Reward {
    
    public enum ItemType {
        TIGER, PIG, LION
    }
   
    // item type
    private ItemType _type;

    // quantity of this type of item
    private int _quantity;

    /**
     * Creates a new item.
     * 
     * @param type item type
     * @param quantity item quantity
     */
    public Item(ItemType type, int quantity) {
        this._type = type;
        this._quantity = quantity;
    }

    /**
     * Gets quantity of this kind of item.
     * 
     * @return quantity of this kind of item
     */
    public int getQuantity() {
        return _quantity;
    }
    
    /**
     * Sets the quantity of this item.
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        _quantity = quantity;
    }

    @Override
    public boolean isReqMet(Player player) {
        return player.hasItem(_type) && player.getItemQuantity(_type) >= _quantity;
    }

    @Override
    public void reward(Player player) {
        player.addItemQuantity(_type, _quantity);
    }


}
