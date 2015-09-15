package com.interviewcoder.ood;

public interface Requirement {
    
    /**
     * Returns true if player meets this requirement.
     * 
     * @param player
     * @return
     */
    public boolean isReqMet(Player player);

}
