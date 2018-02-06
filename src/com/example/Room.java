package com.example;
import java.io.IOException;
import java.util.List;

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

    public Direction[] getDirectionList() throws IOException {
        return directions;
    }

    public String[] getItemsInString() throws IOException {
            return items;
    }
}
