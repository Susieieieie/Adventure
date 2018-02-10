package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private Room currentLocation;
    private Adventure adventure;
    private ArrayList<String> itemsInHand;

    public ArrayList<String> getItemsInHand(){
        return itemsInHand;
    }

    public void addItemsInHand(String item) {
        if(itemsInHand==null){
            String[] itemString = {item};
            ArrayList<String> temp = new ArrayList<String>(Arrays.asList(itemString));
            itemsInHand = temp;
            return;
        }
        itemsInHand.add(item);
    }

    public void dropItemsInHand(String item) {
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
