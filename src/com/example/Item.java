package com.example;

public class Item {
    private String name;
    private Double damage;

    public Item(String name, Double damage) {
        this.name = name;
        this.damage = damage;
    }

    public Double getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}
