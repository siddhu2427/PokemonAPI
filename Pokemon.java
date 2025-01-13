package com.impact.pokemon;

public class Pokemon {

    private String name;
    private String type;
    private int hitPoints;
    private int attack;
    private int defense;
    private int speed;

    public Pokemon(String name, String type, int hitPoints, int attack, int defense, int speed) {
        this.name = name;
        this.type = type;
        this.hitPoints = hitPoints;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }
}
