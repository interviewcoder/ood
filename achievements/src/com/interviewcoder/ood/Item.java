package com.interviewcoder.ood;

public class Item {
    
    public enum ItemType {
        PIG, TIGER, PARRIOT
    }
    
    private ItemType _type;

    /**
     * @return the _type
     */
    public ItemType getItemType() {
        return _type;
    }

}
