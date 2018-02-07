package com.example;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.deploy.util.ArrayUtil;

import java.rmi.server.ExportException;
import java.util.LinkedList;
import java.util.List;
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

    /**
     * find the starting room in room array
     * @return starting room
     */
    public Room findStartingRoom(){
        for (int indexRoom = 0; indexRoom < getRooms().length; indexRoom++) {
            if (rooms[indexRoom].getName().equals(startingRoom)) {
                return rooms[indexRoom];
            }
        }
        return null;
    }

    /**
     * find endingRoom in rooms
     * @return endingRoom
     */
    public Room findEndingRoom(){
        for (int indexRoom = 0; indexRoom < getRooms().length; indexRoom++) {
            if (rooms[indexRoom].getName().equals(endingRoom)) {
                return rooms[indexRoom];
            }
        }
        return null;
    }

    /**
     * check if player wants to exit game
     * @return if they want to quit
     * @throws Exception
     */
    public static void quitCases() throws Exception{
        if (getInputFromUser().equals("quit") || getInputFromUser().equals("exit")) {
            System.exit(-1);
        }
    }

    /**
     * check if input format is correct
     * @return if the input format is correct
     * @throws Exception
     */
    public static boolean getCorrectInputFormat() throws Exception{
        Adventure json = Parse.parse();
        Room currentLocation = json.getPlayer().getCurrentLocation();
        boolean correctFormat = false;
        if (json.getInputFromUser().contains("go") && (json.getInputFromUser().contains("east")
                || json.getInputFromUser().contains("west") || json.getInputFromUser().contains("north")
                || json.getInputFromUser().contains("south"))) {
            correctFormat = true;
        } else {
            correctFormat = false;
            System.out.println("I can't go" + getInputFromUser().substring(2));
        }
        return correctFormat;
    }

    /**
     * change the room if the input format is correct
     * @param adventure
     * @return
     * @throws Exception
     */
    public Player changeRoom(Adventure adventure) throws Exception {
        Room currentLocation = adventure.getPlayer().getCurrentLocation();
        if (adventure.getCorrectInputFormat() == true) {
            String inputDirection = getInputFromUser().substring(3);
            for (int indexDirection = 0; indexDirection < getRooms().length; indexDirection++) {
                if (currentLocation.getDirections()[indexDirection].getDirectionName().equals(inputDirection)) {
                    String roomName = currentLocation.getDirections()[indexDirection].getRoom();
                    for (int indexRoom = 0; indexRoom < getRooms().length; indexRoom++) {
                        if (rooms[indexRoom].getName().equals(roomName)) {
                            adventure.setPlayer(new Player(adventure.rooms[indexRoom], adventure));
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * take the matching item with the player
     * @return
     * @throws Exception
     */
    public static boolean ifTakeItem()throws Exception{
        Adventure json = Parse.parse();
        Room currentLocation = json.getPlayer().getCurrentLocation();
        boolean containItem = false;
        boolean correctItemFormat = false;
        for (int i = 0; i < currentLocation.getItems().length; i++) {
            if (json.getInputFromUser().contains(currentLocation.getItems()[i])) {
                containItem = true;
            }
        }
        if (json.getInputFromUser().substring(0,4).equals("take") && containItem == true ) {
            correctItemFormat = true;
        }
        return correctItemFormat;
    }

    
    /**
     * remove an element from array
     * @param arr
     * @param removedIdx
     */
    public void removeItem(String[] arr, int removedIdx) {
        System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    }

    /**
     * if you have items with you, you drop them
     * @return
     * @throws Exception
     */
    public static boolean ifDropItem() throws Exception{
        Adventure json = Parse.parse();
        json.setPlayer(new Player(json.findStartingRoom(), json));
        Room currentLocation = json.getPlayer().getCurrentLocation();
        boolean haveItem = false;
        return haveItem;
    }

    /**
     * get the User's input and toLowerCase them
     * @return User's lowerCased input
     */
    public static String getInputFromUser() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string");
        String playerInput = in.nextLine().toLowerCase();
        return playerInput;
    }

    /**
     * main function which includes both input and output part
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception{
        Adventure json = Parse.parse();
        json.setPlayer(new Player(json.findStartingRoom(), json));

        /* haven't arrived endingRoom*/
        while (!json.getPlayer().getCurrentLocation().equals(json.findEndingRoom())) {
            Room currentLocation = json.getPlayer().getCurrentLocation();
            if (json.getPlayer().getCurrentLocation().equals(json.findStartingRoom())) {
                System.out.println(currentLocation.getDescription() + "\n");
                System.out.println("Your journey begins here\n");
                System.out.println("This room contains" + currentLocation.getItems() + "\n");
                System.out.println("From here you can go");
                for (int i = 0; i < currentLocation.getDirections().length; i++) {
                    System.out.println(currentLocation.getDirections()[i]);
                }
                System.out.println("\n");
                json.quitCases();

                if (json.getCorrectInputFormat() == true) {
                    continue;
                } else {
                    System.out.println("I don't understand" + json.getInputFromUser());
                    System.out.println(currentLocation.getDescription() + "\n");
                    System.out.println("From here you can go");
                    for (int i = 0; i < currentLocation.getDirections().length; i++) {
                        System.out.println(currentLocation.getDirections()[i]);
                    }
                    System.out.println("\n");
                }
                if (ifTakeItem() == true) {
                    for (int i = 0; i < currentLocation.getItems().length; i++) {
                        if (getInputFromUser().equals(currentLocation.getItems()[i])) {
                            json.removeItem(currentLocation.getItems(), i);
                        }
                    }
                } else {
                    System.out.println("I can’t take" + getInputFromUser().substring(5));
                }

            } else {
                System.out.println(currentLocation.getDescription() + "\n");
                System.out.println("This room contains" + currentLocation.getItems() + "\n");
                System.out.println("From here you can go");
                for (int i = 0; i < currentLocation.getDirections().length; i++) {
                    System.out.println(currentLocation.getDirections()[i]);
                }
                System.out.println("\n");
                json.quitCases();
                if (json.getCorrectInputFormat() == true) {
                    continue;
                } else {
                    System.out.println("I don't understand" + json.getInputFromUser());
                    System.out.println(currentLocation.getDescription() + "\n");
                    System.out.println("From here you can go");
                    for (int i = 0; i < currentLocation.getDirections().length; i++) {
                        System.out.println(currentLocation.getDirections()[i]);
                    }
                    System.out.println("\n");
                }
                if (ifTakeItem() == true) {
                    for (int i = 0; i < currentLocation.getItems().length; i++) {
                        if (getInputFromUser().equals(currentLocation.getItems()[i])) {
                            json.removeItem(currentLocation.getItems(), i);
                        }
                    }
                } else {
                    System.out.println("I can’t take" + getInputFromUser().substring(5));
                }
            }
        }
        /* have arrived endingRoom */
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
            json.quitCases();
        }
    }
}
