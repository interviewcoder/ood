package com.pocketgems.zoo;

public interface Requirement {
    
    /**
     * Returns true if player meets this requirement.
     * 
     * @param player
     * @return true if player meets this requirement
     */
    public boolean isReqMet(Player player);

}
