package com.interviewcoder.ood;

public class ItemAnimalPig extends ItemAnimal {
    
    private static final ItemType TYPE = ItemType.PIG;

    public ItemAnimalPig(int quantity) {
        super(quantity);
    }
    
    public ItemType geItemType() {
        return TYPE;
    }

}
