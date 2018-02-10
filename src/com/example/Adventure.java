package com.example;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class Adventure {
    private String startingRoom;
    private String endingRoom;
    private Room[] rooms;

    public String getStartingRoom() {
        return startingRoom;
    }

    public String getEndingRoom() {
        return endingRoom;
    }

    public Room[] getRooms() {
        return rooms;
    }

    /**private boolean addItem(String item, Player player) {
        ArrayList<String> itemArrayList = new ArrayList<String>(Arrays.asList(player.getCurrentLocation().getItems()));
        itemArrayList.add(item);
        player.getCurrentLocation().setItems(itemArrayList.toArray(new String[itemArrayList.size()]));
        return true;
    }
     */


    /**
     * find the starting room in room array
     *
     * @return starting room
     */
    public Room findStartingRoom() {
        for (int indexRoom = 0; indexRoom < getRooms().length; indexRoom++) {
            if (rooms[indexRoom].getName().equals(startingRoom)) {
                return rooms[indexRoom];
            }
        }
        return null;
    }

    /**
     * find endingRoom in rooms
     *
     * @return endingRoom
     */
    private Room findEndingRoom() {
        for (int indexRoom = 0; indexRoom < getRooms().length; indexRoom++) {
            if (rooms[indexRoom].getName().equals(endingRoom)) {
                return rooms[indexRoom];
            }
        }
        return null;
    }

    /**
     * remove an element from array
     *
     * @param arr
     * @param removedIdx
     */
    public void removeItem(String[] arr, int removedIdx) {
        System.out.println(arr.length);
        System.out.println(removedIdx);
        System.out.println(arr.length-1-removedIdx);
        System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    }

    /**
     * get the User's input and toLowerCase them
     *
     * @return User's lowerCased input
     */
    public static String getInputFromUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string");
        String playerInput = in.nextLine().toLowerCase();
        return playerInput;
    }

    /**
     * print out information
     *
     * @param player
     * @throws Exception
     */
    private void output(final Player player) {
        Room currentLocation = player.getCurrentLocation();
        System.out.println(currentLocation.getDescription());
        if (currentLocation.getName().equals(player.getAdventure().getStartingRoom())) {
            System.out.println("Your journey begins here");
        }
        if (currentLocation.getName().equals(player.getAdventure().getEndingRoom())) {
            System.out.println("You have reached your final destination");
        }
        if (currentLocation.getName() != null) {

            if (currentLocation.getItems() == null || currentLocation.getItems().length == 0) {
                System.out.println("This room contains nothing");

            } else {
                System.out.print("This room contains: ");
                if (currentLocation.getItems() != null && currentLocation.getItems().length > 0) {
                    for (String item : currentLocation.getItems()) {
                        System.out.print(item + ", ");
                    }
                    System.out.println();
                }
            }

            if (currentLocation.getDirections().length > 0) {
                System.out.print("From here you can go: ");
                for (Direction direction : currentLocation.getDirections()) {
                    System.out.print(direction.getDirectionName() + ", ");
                }
                System.out.println();
            } else {
                System.out.println("From here you can go nowhere.");
            }
        }
    }

    /**
     * main function which includes both input and output part
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Adventure adventure = Parse.parse();
        Player player = new Player(adventure);
        adventure.output(player);

        while (!player.getCurrentLocation().equals(adventure.findEndingRoom())) {
            String firstInput = getInputFromUser();
            Room currentLocation = player.getCurrentLocation();
            /**
             * check if player wants to exit game
             */
            if (firstInput.equals("quit") || firstInput.equals("exit")) {
                System.exit(-1);
            }
            /**
             * check if input format is correct
             */
            if (firstInput.contains("go")) {
                if (firstInput.contains("east")
                        || firstInput.contains("west") || firstInput.contains("north")
                        || firstInput.contains("south") || firstInput.contains("up") || firstInput.contains("down")) {
                    boolean hasMoved = false;
                    for (int i = 0; i < player.getCurrentLocation().getDirections().length; i++) {
                        if (player.getCurrentLocation().getDirections()[i].getDirectionName().equalsIgnoreCase(firstInput.substring(3))) {
                            for (int j = 0; j < adventure.getRooms().length; j++) {
                                if (adventure.getRooms()[j].getName().equals(player.getCurrentLocation().getDirections()[i].getRoom())) {
                                    player.setCurrentLocation(adventure.getRooms()[j]);
                                    adventure.output(player);
                                    hasMoved = true;
                                    break;
                                }
                            }
                        }
                        if (hasMoved) {
                            break;
                        }
                    }
                    if (hasMoved == false) {
                        System.out.println("You can't " + getInputFromUser());
                    }
                } else {
                    System.out.println("I don't understand: " + firstInput);
                    System.out.println(currentLocation.getDescription());
                    System.out.println("From here you can go: ");
                    for (int i = 0; i < currentLocation.getDirections().length; i++) {
                        System.out.print(currentLocation.getDirections()[i].getDirectionName());
                    }
                    System.out.println();
                }
            }

            /**
             * take the matching item with the player
             */
            else if (firstInput.startsWith("take")) {
                boolean hasTaken = false;
                for (int i = 0; i < currentLocation.getItems().length; i++) {
                    if (firstInput.substring(5).equalsIgnoreCase(currentLocation.getItems()[i])) {
                        player.addItemsInHand(currentLocation.getItems()[i]);
                        currentLocation.takeItem(currentLocation.getItems()[i]);
                        adventure.output(player);
                        hasTaken = true;
                        break;
                    }
                }
                if (hasTaken == false) {
                    System.out.println("You can't " + firstInput);
                }
            }

            /**
             * drop the item to another room
             */
            else if (firstInput.startsWith("drop")) {
                boolean hasDropped = false;
                for (String item: player.getItemsInHand()) {
                    if (firstInput.substring(5).equalsIgnoreCase(item)) {
                        System.out.println(player.getItemsInHand().toString());
                        currentLocation.dropItem(item);
                        player.dropItemsInHand(item);
                        System.out.println(player.getItemsInHand().toString());
                        adventure.output(player);
                        hasDropped = true;
                        break;
                    }
                }
                if (hasDropped == false) {
                    System.out.println("You can't " + firstInput);
                }
            }
            /**
             * output a item list
             */
            else if (firstInput.equals("list")) {
                if (player.getItemsInHand() != null) {
                    System.out.print("You are carrying: ");
                    for (String item : player.getItemsInHand()) {
                        System.out.print(item + ", ");
                    }
                    System.out.println();
                } else {
                    System.out.println("You have nothing.");
                }
            } else {
                System.out.println("I cannot understand.");
            }
        }
    }
}
