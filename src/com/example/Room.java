package com.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private List<Direction> directions;
    private List<String> items;

    public Room(String name, String description, List<Direction> direction, List<String> iterms) {
        super();
        this.name = name;
        this.description = description;
        this.directions = direction;
        this.items = iterms;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Direction> getDirectionList() throws IOException {
        Gson json = new Gson();
        List<Direction> directionList = json.fromJson(Parse.getRootobj().get("Direction"),Direction.class);
        return directionList;
    }


    public String getItemsInString() {
        if (items.isEmpty()) {
            return "No item.";
        } else {
            StringBuffer
        }
        return items;
    }
}
