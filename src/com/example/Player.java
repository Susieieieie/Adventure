package com.example;

public class Player {
    private Room currentLocation;
    private Adventure adventure;

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
            if (room.getName().equals(adventure.getRooms())) {
                this.setCurrentLocation(room);
            }
        }
    }
}
