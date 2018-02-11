package com.example;

import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class Adventure {
    private String startingRoom;
    private String endingRoom;
    private Room[] rooms;
    private Player player;
    private Monster[] monsters;


    public Player getPlayer() {
        return player;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public String getStartingRoom() {
        return startingRoom;
    }

    public String getEndingRoom() {
        return endingRoom;
    }

    public Room[] getRooms() {
        return rooms;
    }


    /** parse new json file*/
    public static final String JSON_FILE = "{\n" +
            "  \"startingRoom\": \"Room one\",\n" +
            "  \"endingRoom\": \"Room seven\",\n" +
            "  \"player\":\n" +
            "  {\n" +
            "    \"name\": \"Susie\",\n" +
            "    \"items\": [\n" +
            "      {\n" +
            "        \"name\": \"tear\",\n" +
            "        \"damage\": 20.0\n" +
            "      }\n" +
            "    ],\n" +
            "    \"attack\": 40.0,\n" +
            "    \"defense\": 100.0,\n" +
            "    \"health\": 200.0,\n" +
            "    \"level\": 1\n" +
            "  },\n" +
            "  \"monsters\": [\n" +
            "    {\n" +
            "      \"name\": \"Ape\",\n" +
            "      \"attack\": 30.0,\n" +
            "      \"defense\": 50.0,\n" +
            "      \"health\": 80.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Bear\",\n" +
            "      \"attack\": 50.0,\n" +
            "      \"defense\": 80.0,\n" +
            "      \"health\": 100.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Cat\",\n" +
            "      \"attack\": 60.0,\n" +
            "      \"defense\": 30.0,\n" +
            "      \"health\": 50.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Bat\",\n" +
            "      \"attack\": 40.0,\n" +
            "      \"defense\": 80.0,\n" +
            "      \"health\": 80.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Dragon\",\n" +
            "      \"attack\": 90.0,\n" +
            "      \"defense\": 100.0,\n" +
            "      \"health\": 80.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Elephant\",\n" +
            "      \"attack\": 50.0,\n" +
            "      \"defense\": 60.0,\n" +
            "      \"health\": 80.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"MP\",\n" +
            "      \"attack\": 40.0,\n" +
            "      \"defense\": 80.0,\n" +
            "      \"health\": 120.0\n" +
            "    }\n" +
            "  ],\n" +
            "  \"rooms\": [\n" +
            "    {\n" +
            "      \"name\": \"Room one\",\n" +
            "      \"description\": \"You are on Room one, there is trash everywhere\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"apple\",\n" +
            "          \"damage\": 50.0\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"Room two\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\"Ape\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Room two\",\n" +
            "      \"description\": \"You are in the Room two, there is a dead woman\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"honey\",\n" +
            "          \"damage\": 80.0\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"bee\",\n" +
            "          \"damage\": 40.0\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"Room one\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"Room three\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Up\",\n" +
            "          \"room\": \"Room four\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\"Bear\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Room three\",\n" +
            "      \"description\": \"You are in the Room three.  It's very dark there.\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"candle\",\n" +
            "          \"damage\": 40.0\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"Room two\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"Room four\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\"Cat\", \"Bat\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Room four\",\n" +
            "      \"description\": \"You are in the Room four.  It is so hot there.\",\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"Room three\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"Down\",\n" +
            "          \"room\": \"Room two\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"Room five\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\"Dragon\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Room five\",\n" +
            "      \"description\": \"You are in the Room five.  There is full of flower.\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"flower\",\n" +
            "          \"damage\": 20.0\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"Room four\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"Room six\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Room six\",\n" +
            "      \"description\": \"You are in the Room six.  It is so bright here\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"sunglasses\",\n" +
            "          \"damage\": 60.0\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"cigarette\",\n" +
            "          \"damage\": 10.0\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"Room five\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"Room seven\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\"Elephant\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Room seven\",\n" +
            "      \"description\": \"You are in Room seven.  There is a gaint monster called MP.\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"TA\",\n" +
            "          \"damage\": 100.0\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"Room six\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\"MP\"]\n" +
            "    }\n" +
            "  ]\n" +
            "}";


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
                    for (Item item : currentLocation.getItems()) {
                        System.out.print(item.getName() + ", ");
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
        /**Adventure adventure = Parse.parse();*/
        Gson json = new Gson();
        Adventure adventure2 = json.fromJson(JSON_FILE, Adventure.class);
        Player player = new Player(adventure2);
        adventure2.output(player);

        while (!player.getCurrentLocation().equals(adventure2.findEndingRoom())) {
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
                            for (int j = 0; j < adventure2.getRooms().length; j++) {
                                if (adventure2.getRooms()[j].getName().equals(player.getCurrentLocation().getDirections()[i].getRoom())) {
                                    player.setCurrentLocation(adventure2.getRooms()[j]);
                                    adventure2.output(player);
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
                    if (firstInput.substring(5).equalsIgnoreCase(currentLocation.getItems()[i].getName())) {
                        player.addItemsInHand(currentLocation.getItems()[i]);
                        currentLocation.takeItem(currentLocation.getItems()[i]);
                        adventure2.output(player);
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
                for (Item item: player.getItemsInHand()) {
                    if (firstInput.substring(5).equalsIgnoreCase(item.getName())) {
                        System.out.println(player.getItemsInHand().toString());
                        currentLocation.dropItem(item);
                        player.dropItemsInHand(item);
                        System.out.println(player.getItemsInHand().toString());
                        adventure2.output(player);
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
                    for (Item item : player.getItemsInHand()) {
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
