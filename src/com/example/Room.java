package com.example;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Arrays;

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
    public void dropItem(String item) {
        ArrayList<String> myItemArrayList = new ArrayList<String>(Arrays.asList(getItems()));
        myItemArrayList.add(item);
        String[] newItem = myItemArrayList.toArray(new String[myItemArrayList.size()]);
        items = newItem;

    }

    public void takeItem(String item) {
        ArrayList<String> myItemArrayList = new ArrayList<String>(Arrays.asList(getItems()));
        myItemArrayList.remove(item);
        String[] newItem = myItemArrayList.toArray(new String[myItemArrayList.size()]);
        items = newItem;
    }
}
