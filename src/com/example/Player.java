package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private Room currentLocation;
    private Adventure adventure;
    private ArrayList<Item> itemsInHand;
    private String name;
    private Item[] items;
    private Double attack;
    private Double defense;
    private Double health;
    private Integer level;

    public String getName() {
        return name;
    }

    public Double getDefense() {
        return defense;
    }

    public Double getHealth() {
        return health;
    }

    public Double getAttack() {
        return attack;
    }

    public Item[] getItems() {
        return items;
    }

    public Integer getLevel() {
        return level;
    }

    public ArrayList<Item> getItemsInHand(){
        return itemsInHand;
    }

    public void addItemsInHand(Item item) {
        if(itemsInHand==null){
            Item[] itemString = {item};
            ArrayList<Item> temp = new ArrayList<Item>(Arrays.asList(itemString));
            itemsInHand = temp;
            return;
        }
        itemsInHand.add(item);
    }

    public void dropItemsInHand(Item item) {
        itemsInHand.remove(item);
    }

    public void setAdventure(Adventure adventure){
        this.adventure = adventure;
    }

    public Adventure getAdventure(){
        return adventure;
    }

    public void setCurrentLocation(Room location){
        this.currentLocation = location;
    }

    public Room getCurrentLocation(){
        return currentLocation;
    }

    public Player(Room locationName, Adventure adventure) {
        this.setAdventure(adventure);
        Room[] rooms = this.getAdventure().getRooms();
        for (Room room: rooms) {
            if (room.getName().equals(locationName)) {
                this.setCurrentLocation(room);
            }
        }
    }

    public Player(Adventure adventure) {
        this.setAdventure(adventure);
        for (Room room: adventure.getRooms()) {
            if (room.getName().equals(adventure.getStartingRoom())) {
                this.setCurrentLocation(room);
            }
        }
    }
}
