package com.memory;

public class Reward{
    private String type;
    private String name;
    private int amount;

    public Reward(String type, String name, int amount) {
        this.type = type;
        this.name = name;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Reward {" +
                "type = '" + type + '\'' +
                ", name = '" + name + '\'' +
                ", amount = " + amount +
                '}';
    }
}