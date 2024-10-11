package com.memory;

import com.memory.Reward;

public class Level{
    private int experienceRequired;
    private Reward reward;
    public Level(int experienceRequired, Reward reward) {
        this.experienceRequired = experienceRequired;
        this.reward = reward;
    }
    public int getExperienceRequired(){
        return experienceRequired;
    }
    public Reward getReward(){
        return reward;
    }

    @Override
    public String toString() {
        return "Level {" +
                "experienceRequired = " + experienceRequired +
                ", reward = " + reward +
                '}';
    }
}