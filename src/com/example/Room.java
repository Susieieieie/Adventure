package com.example;
public class Room {
    private String name;
    private String description;
    private Direction[] directions;
    private String[] items;

    public Room(String name, String description,Direction[] direction, String[] items) {
        super();
        this.name = name;
        this.description = description;
        this.directions = direction;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Direction[] getDirections() {
        return directions;
    }

    public String[] getItems() {
            return items;
    }
}
