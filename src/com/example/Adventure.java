package com.example;

import java.util.Scanner;

public class Adventure {
    private String startingRoom;
    private String endingRoom;
    private Room[] rooms;
    private Player player;

    public String getStartingRoom() {
        return startingRoom;
    }

    public String getEndingRoom() {
        return endingRoom;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Room findStartingRoom(){
        for (int indexRoom = 0; indexRoom < getRooms().length; indexRoom++) {
            if (rooms[indexRoom].getName().equals(startingRoom)) {
                return rooms[indexRoom];
            }
        }
        return null;
    }
    public Room findEndingRoom(){
        for (int indexRoom = 0; indexRoom < getRooms().length; indexRoom++) {
            if (rooms[indexRoom].getName().equals(endingRoom)) {
                return rooms[indexRoom];
            }
        }
        return null;
    }

    public String getInputFromUser(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string");
        String playerInput = in.nextLine().toLowerCase();
        return playerInput;
    }

    public static void main(String[] arg) throws Exception{
        Adventure json = Parse.parse();
        json.setPlayer(new Player(json.findStartingRoom(), json));

        /**
         * output part: using while loop.
         */
        while (!json.getPlayer().getCurrentLocation().equals(json.findEndingRoom())) {
            Room currentLocation = json.getPlayer().getCurrentLocation();
            if (json.getPlayer().getCurrentLocation().equals(json.findStartingRoom())) {
                if (json.getInputFromUser().equals("quit") || json.getInputFromUser().equals("exit")) {
                    break;
                }
                System.out.println(currentLocation.getDescription() + "\n");
                System.out.println("Your journey begins here\n");
                System.out.println("This room contains" + currentLocation.getItems() + "\n");
                System.out.println("From here you can go");
                for (int i = 0; i < currentLocation.getDirections().length; i++) {
                    System.out.println(currentLocation.getDirections()[i]);
                }
                System.out.println("\n");
            } else {
                if (json.getInputFromUser().equals("quit") || json.getInputFromUser().equals("exit")) {
                    break;
                }
                System.out.println(currentLocation.getDescription() + "\n");
                System.out.println("This room contains" + currentLocation.getItems() + "\n");
                System.out.println("From here you can go");
                for (int i = 0; i < currentLocation.getDirections().length; i++) {
                    System.out.println(currentLocation.getDirections()[i]);
                }
                System.out.println("\n");
            }
        }
        if (json.getPlayer().getCurrentLocation().equals(json.findEndingRoom())) {
            Room currentLocation = json.getPlayer().getCurrentLocation();
            System.out.println(currentLocation.getDescription() + "\n");
            System.out.println("You have reached your final destination\n");
            System.out.println("This room contains" + currentLocation.getItems() + "\n");
            System.out.println("From here you can go" );
            for (int i = 0; i < currentLocation.getDirections().length; i++) {
                System.out.println(currentLocation.getDirections()[i]);
            }
            System.out.println("\n");
        }
    }
}
