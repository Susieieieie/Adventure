package com.example;

public class Direction {
    private String directionName;
    private String room;

    public Direction(String directionName, String room) {
        super();
        this.directionName = directionName;
        this.room = room;
    }

    public String getDirectionName() {
        return directionName;
    }

    public String getRoom() {
        return room;
    }
}
