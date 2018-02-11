package com.example;

public class Monster {
    private String name;
    private Double attack;
    private Double defense;
    private Double health;

    public Monster(Double defense, String name, Double attack, Double health) {
        this.defense = defense;
        this.attack = attack;
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public Double getAttack() {
        return attack;
    }

    public Double getDefense() {
        return defense;
    }

    public Double getHealth() {
        return health;
    }
}
