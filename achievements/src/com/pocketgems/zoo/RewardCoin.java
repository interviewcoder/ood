package com.pocketgems.zoo;

/**
 * Rewards the player some coins.
 */
public class RewardCoin implements Reward {

    // number of coins to be rewarded to player
    private int _coins;
    
    /**
     * Creates a new coin reward.
     * 
     * @param coins number of coins to be rewarded
     */
    public RewardCoin(int coins) {
        this._coins = coins;
    }
    
    @Override
    public void reward(Player player) {
        player.addCoins(_coins);
    }

}
