### Achievement System

This is a zoo gaming system. In this zoo, player can achieve some achievements.
For each achievement, when a player meets all the requirements required by that achievement, 
player can earn rewards for that achievement.

For example,
Achievement: 
Title: Super Farmer
Requirements: 1) player is at least at level 2
              2) player should have at least 5 pigs
Rewards: 1) add 400 coins to player

Design: more details see [discussion.txt](https://github.com/interviewcoder/ood/blob/master/achievements/src/discussion.txt)

- `class AchievementManager`
   ```java
   // 1) know all achievements: 
   Set<Achievement> _achievements
   ```
   
- `class Achievement`
    ```java
    // 1) Set of requirements
    Set<Requirement> _requirements
    // 2) Set of rewards
    Set<Reward> _rewards
    ```

- `interface Requirement`
    ```java
    boolean isReqMet(Player)
    ```
- `interface Reward`
    ```java
    void rewardPlayer(Player)
    ```
