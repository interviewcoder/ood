package com.interviewcoder.ood;

public class RequirementItem implements Requirement {
    
    private Item _req;
    
    private int _quantity;
    
    public RequirementItem(Item item, int quantity) {
        _req = item;
        this._quantity = quantity;
    }

    @Override
    public boolean isReqMet(Player player) {
        return player.getItemQuantity(_req) >= _quantity;
    }

}
