package com.interviewcoder.ood;

import java.util.HashSet;
import java.util.Set;

public class Player {
    
    private int id;
    
    private String name; 
    
    private int points;
    
    private int level;
    
    private Set<Badge> bages = new HashSet<>();
    
    public Player() {
        // TODO Auto-generated constructor stub
    }

    public String getName() {
        return name;
    }

}
