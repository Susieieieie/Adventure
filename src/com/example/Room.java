package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private String name;
    private String description;
    private Direction[] directions;
    private Item[] items;
    private String[] monstersInRoom;

    public Room(String name, String description,Direction[] direction, Item[] items, String[] monstersInRoom) {
        this.name = name;
        this.description = description;
        this.directions = direction;
        this.items = items;
        this.monstersInRoom = monstersInRoom;
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

    public Item[] getItems() {
            return items;
    }

    public String[] getMonstersInRoom(){
        return monstersInRoom;
    }

    public void dropItem(Item item) {
        ArrayList<Item> myItemArrayList = new ArrayList<Item>(Arrays.asList(getItems()));
        myItemArrayList.add(item);
        Item[] newItem = myItemArrayList.toArray(new Item[myItemArrayList.size()]);
        items = newItem;
    }

    public void takeItem(Item item) {
        ArrayList<Item> myItemArrayList = new ArrayList<Item>(Arrays.asList(getItems()));
        myItemArrayList.remove(item);
        Item[] newItem = myItemArrayList.toArray(new Item[myItemArrayList.size()]);
        items = newItem;
    }
}
