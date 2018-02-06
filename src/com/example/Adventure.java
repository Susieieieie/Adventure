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

    public void output(){
        for (int indexRoom = 0; indexRoom < rooms.length; indexRoom++) {
            if (rooms[indexRoom].getName().equals(startingRoom)) {
                System.out.println(rooms[indexRoom].getDescription() + "\n");
                System.out.println("Your journey begins here\n");
                System.out.println("This room contains" + rooms[indexRoom].getItems() + "\n");
                System.out.println("From here you can go" + rooms[indexRoom].getDirections()[indexRoom].getDirectionName() + "\n");
            } else if (rooms[indexRoom].getName().equals(endingRoom)) {
                System.out.println(rooms[indexRoom].getDescription() + "\n");
                System.out.println("You have reached your final destination\n");
                System.out.println("This room contains" + rooms[indexRoom].getItems() + "\n");
                System.out.println("From here you can go" + rooms[indexRoom].getDirections()[indexRoom].getDirectionName() + "\n");
            } else {
                System.out.println(rooms[indexRoom].getDescription()+ "\n");
                System.out.println("This room contains" + rooms[indexRoom].getItems() + "\n");
                System.out.println("From here you can go" + rooms[indexRoom].getDirections()[indexRoom].getDirectionName() + "\n");
            }
        }
    }

    public String getInputFromUser(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string");
        String playerInput = in.nextLine();
        return playerInput;
    }

    public void input(){
        if (getInputFromUser() == "quit" || getInputFromUser() == "exit") {

        }
        if (getInputFromUser() == "go")
    }
}
