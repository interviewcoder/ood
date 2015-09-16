package com.interviewcoder.ood;

public abstract class Item implements Requirement {
    
    public enum ItemType {
        ANIMAL, PIG
    }
   
    // item type
    protected ItemType _type;

    // quantity of this type of item
    protected int _quantity;

    public Item(int quantity) {
        _quantity = quantity;
    }

    /**
     * Gets quantity of this kind of item.
     * 
     * @return
     */
    public int getQuantity() {
        return _quantity;
    }
    
    @Override
    public boolean isReqMet(Player player) {
        return player.hasItem(_type) && player.getItemQuantity(_type) >= _quantity;
    }

}
