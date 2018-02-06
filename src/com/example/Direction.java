package com.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

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
