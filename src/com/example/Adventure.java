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
            "  \"endingRoom\": \"Room eight\",\n" +
            "  \"player\":\n" +
            "  {\n" +
            "    \"name\": \"Susie\",\n" +
            "    \"items\": [\n" +
            "      {\n" +
            "        \"name\": \"tear\",\n" +
            "        \"damage\": 20.0\n" +
            "      }\n" +
            "    ],\n" +
            "    \"attack\": 50.0,\n" +
            "    \"defense\": 30.0,\n" +
            "    \"health\": 300.0,\n" +
            "    \"level\": 1\n" +
            "  },\n" +
            "  \"monsters\": [\n" +
            "    {\n" +
            "      \"name\": \"Ape\",\n" +
            "      \"attack\": 40.0,\n" +
            "      \"defense\": 10.0,\n" +
            "      \"health\": 50.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Bear\",\n" +
            "      \"attack\": 50.0,\n" +
            "      \"defense\": 20.0,\n" +
            "      \"health\": 100.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Cat\",\n" +
            "      \"attack\": 60.0,\n" +
            "      \"defense\": 10.0,\n" +
            "      \"health\": 150.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Dragon\",\n" +
            "      \"attack\": 70.0,\n" +
            "      \"defense\": 30.0,\n" +
            "      \"health\": 200.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Frog\",\n" +
            "      \"attack\": 40.0,\n" +
            "      \"defense\": 50.0,\n" +
            "      \"health\": 160.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Elephant\",\n" +
            "      \"attack\": 80.0,\n" +
            "      \"defense\": 40.0,\n" +
            "      \"health\": 180.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"MP\",\n" +
            "      \"attack\": 60.0,\n" +
            "      \"defense\": 30.0,\n" +
            "      \"health\": 230.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Mom\",\n" +
            "      \"attack\": 0.0,\n" +
            "      \"defense\": 0.0,\n" +
            "      \"health\": 10000.0\n" +
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
            "      \"monstersInRoom\": [\"Cat\"]\n" +
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
            "      ],\n" +
            "      \"monstersInRoom\": [\"Frog\"]\n" +
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
            "        },\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"Room eight\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\"MP\"]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Room eight\",\n" +
            "      \"description\": \"You are at home, there is a huge bed:-)\",\n" +
            "      \"items\": [\n" +
            "        {\n" +
            "          \"name\": \"pillow\",\n" +
            "          \"damage\": 0.0\n" +
            "        }\n" +
            "      ],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"West\",\n" +
            "          \"room\": \"Room seven\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"monstersInRoom\": [\"Mom\"]\n" +
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
     * remove monster if it is dead.
     * @param monster
     */
    public void removeMonster(Monster monster) {
        ArrayList<Monster> myMonsterArrayList = new ArrayList<Monster>(Arrays.asList(getMonsters()));
        myMonsterArrayList.remove(monster);
        Monster[] newMonster = myMonsterArrayList.toArray(new Monster[myMonsterArrayList.size()]);
        monsters = newMonster;
    }

    public void statusPlayer(Player player) {
        String playerHealthOutput = "";
        Double[] healthArray = { 0.05, 0.10, 0.15, 0.20, 0.25, 0.30, 0.35, 0.40, 0.45, 0.50, 0.55, 0.60, 0.65, 0.70, 0.75, 0.80, 0.85, 0.90, 0.95, 1.00};
        Double playerHealthPercent = player.getHealth() / 300 * Math.pow(1.3, (player.getLevel() - 1));
        for (int j = 0; j < healthArray.length; j++) {
            if (playerHealthPercent >= healthArray[j]) {
                playerHealthOutput += "1";
            } else {
                playerHealthOutput += "0";
            }
        }
        System.out.println("Player's current health is: " + playerHealthOutput);
    }

    public void statusMonster(Monster monster) {
        String monsterHealthOutput = "";
        Double[] healthArray = { 0.05, 0.10, 0.15, 0.20, 0.25, 0.30, 0.35, 0.40, 0.45, 0.50, 0.55, 0.60, 0.65, 0.70, 0.75, 0.80, 0.85, 0.90, 0.95, 1.00};
        for (int i = 0; i < this.getMonsters().length; i++) {
            if (this.getMonsters()[i].equals(monster.getName())) {
                Double monsterHealthPercent = monster.getHealth() / this.getMonsters()[i].getHealth();
                for (int j = 0; j < healthArray.length; j++) {
                    if (monsterHealthPercent >= healthArray[j]) {
                        monsterHealthOutput += "1";
                    } else {
                        monsterHealthOutput += "0";
                    }
                }
            }
        }
        System.out.println("Monster's current health is: " + monsterHealthOutput);
    }

    /**
     * helper function about the duel without item
     */
    public void duelWithoutItem(Player player, Monster monster) {
        for (Monster aimMonster : this.getMonsters()) {
            Double orginalHelath = aimMonster.getHealth();
            if (aimMonster.equals(monster)) {
                while (monster.getHealth() > 0 && player.getHealth() > 0) {
                    Double playerDamage = player.getAttack() - monster.getDefense();
                    monster.setHealth(monster.getHealth() - playerDamage);
                    String thirdInput = this.getInputFromUser();
                    if (thirdInput.equalsIgnoreCase("disegage")) {
                        break;
                    } else if (thirdInput.equalsIgnoreCase("status")) {
                        this.statusPlayer(player);
                        String monsterHealthOutput = "";
                        Double[] healthArray = {0.05, 0.10, 0.15, 0.20, 0.25, 0.30, 0.35, 0.40, 0.45, 0.50, 0.55, 0.60, 0.65, 0.70, 0.75, 0.80, 0.85, 0.90, 0.95, 1.00};
                        Double monsterHealthPercent = monster.getHealth() / orginalHelath;
                        for (int j = 0; j < healthArray.length; j++) {
                            if (monsterHealthPercent >= healthArray[j]) {
                                monsterHealthOutput += "1";
                            } else {
                                monsterHealthOutput += "0";
                            }
                        }
                        System.out.println("Monster's current health is: " + monsterHealthOutput);
                    }
                    if (monster.getHealth() <= 0) {
                        System.out.println("You win");
                        player.getCurrentLocation().removeMonsterInRoom(monster.toString());
                        this.removeMonster(monster);
                        player.getCurrentLocation().removeMonsterInRoom(monster.getName());
                        this.levelUp(player, monster);
                        break;
                    } else if (player.getHealth() > 0 && monster.getHealth() > 0) {
                        Double monsterDamage = monster.getAttack() - player.getDefense();
                        player.setHealth(player.getHealth() - monsterDamage);
                    } else if (player.getHealth() <= 0) {
                        System.out.println("You dead.");
                        System.exit(-1);
                    }
                }
            }
        }
    }

    /**
     * helper function about the duel with item
     */
    public boolean duelWithItem(Player player, Monster monster, Item item) {
        boolean duelMonster = true;
        for (Monster aimMonster : this.getMonsters()) {
            Double orginalHelath = aimMonster.getHealth();
            if (aimMonster.equals(monster)) {
                while (monster.getHealth() > 0 && player.getHealth() > 0) {
                    Double playerDamageWithItem = player.getAttack() + item.getDamage() - monster.getDefense();
                    monster.setHealth(monster.getHealth() - playerDamageWithItem);
                    Double playerDamage = player.getAttack() - monster.getDefense();
                    monster.setHealth(monster.getHealth() - playerDamage);
                    String thirdInput = this.getInputFromUser();
                    if (thirdInput.equalsIgnoreCase("disegage")) {
                        break;
                    } else if (thirdInput.equalsIgnoreCase("status")) {
                        this.statusPlayer(player);
                        String monsterHealthOutput = "";
                        Double[] healthArray = {0.05, 0.10, 0.15, 0.20, 0.25, 0.30, 0.35, 0.40, 0.45, 0.50, 0.55, 0.60, 0.65, 0.70, 0.75, 0.80, 0.85, 0.90, 0.95, 1.00};
                        Double monsterHealthPercent = monster.getHealth() / orginalHelath;
                        for (int j = 0; j < healthArray.length; j++) {
                            if (monsterHealthPercent >= healthArray[j]) {
                                monsterHealthOutput += "1";
                            } else {
                                monsterHealthOutput += "0";
                            }
                        }
                        System.out.println("Monster's current health is: " + monsterHealthOutput);
                    }
                    if (monster.getHealth() <= 0) {
                        System.out.println("You win");
                        player.getCurrentLocation().removeMonsterInRoom(monster.getName());
                        this.removeMonster(monster);
                        this.levelUp(player, monster);
                        duelMonster = false;
                        break;
                    } else if (player.getHealth() > 0 && monster.getHealth() > 0) {
                        Double monsterDamage = monster.getAttack() - player.getDefense();
                        player.setHealth(player.getHealth() - monsterDamage);
                        duelMonster = true;
                    } else if (player.getHealth() <= 0) {
                        System.out.println("You dead.");
                        duelMonster = false;
                        System.exit(-1);
                    }
                }
            }
        }
        return duelMonster;
    }

    /**
     * winning a duel-- level up
     */
    public void levelUp(Player player, Monster monster){
        Double experience = ((monster.getAttack() + monster.getDefense()) / 2 + monster.getHealth()) * 20;
        Double accumulativeExperience = 0.0;
        Double experienceNeeded = 0.0;
        Double[] experiencePerLevel = {25.0, 50.0, 82.5, 145.75, 251.075, 436.5, 756.3, 1312.1, 2275.2, 3946.0};
        for (int i = 0; i < experiencePerLevel.length; i++) {
            experienceNeeded = experiencePerLevel[player.getLevel() - 1];
        }
        if (monster.getHealth() <= 0) {
            accumulativeExperience += experience;
            if (accumulativeExperience >= experienceNeeded) {
                player.setLevel(player.getLevel() + 1);
                player.setHealth(player.getHealth() * 1.3);
                player.setDefense(player.getDefense() * 1.5);
                player.setAttack(player.getAttack() * 1.5);
                System.out.println("Congrats, you level up to " + (player.getLevel()));
                System.out.println("Your current health is: " + player.getHealth());
                System.out.println("Your current attack is: " + player.getAttack());
                System.out.println("Your current defense is: " + player.getDefense());
                accumulativeExperience -= experienceNeeded;
            }
        }
    }



    /**
     * get the User's input and toLowerCase them
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
        if (currentLocation.getName().equals(this.getStartingRoom())) {
            System.out.println("Your journey begins here");
        }
        if (currentLocation.getName().equals(this.getEndingRoom())) {
            System.out.println("You have reached your final destination");
        }
        if (currentLocation.getName() != null) {
            if (currentLocation.getMonstersInRoom() == null || currentLocation.getMonstersInRoom().length == 0) {
                System.out.println("This room have no monster.");
            } else {
                System.out.print("The monsters in this room are: ");
                for (String monsterInRoom: currentLocation.getMonstersInRoom()) {
                    System.out.println(monsterInRoom + ", ");
                }
            }
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
        Gson json = new Gson();
        Adventure adventure2 = json.fromJson(JSON_FILE, Adventure.class);
        Player player = adventure2.getPlayer();
        for (Room room: adventure2.getRooms()) {
            if (room.getName().equals(adventure2.getStartingRoom())) {
                player.setCurrentLocation(room);
            }
        }
        adventure2.output(player);

        while (!player.getCurrentLocation().equals(adventure2.findEndingRoom())) {
            String firstInput = getInputFromUser();
            Room currentLocation = player.getCurrentLocation();
            boolean duelMonsters = true;
            /**
             * check if player wants to exit game
             */
            if (firstInput.equalsIgnoreCase("quit") || firstInput.equalsIgnoreCase("exit")) {
                System.exit(-1);
            }

            /**
             * printout player's information
             */
            else if (firstInput.equalsIgnoreCase("playerinfo")) {
                System.out.println("Your level is " + player.getLevel());
                System.out.println("Your attack is " + player.getAttack());
                System.out.println("Your defense is " + player.getDefense());
                System.out.println("Your health is " + player.getHealth());
            }

            /**
             * duel the monsters (including "attack" and "atack with item")
             */
            else if (firstInput.startsWith("duel")) {
                for (String monsterInRoom : player.getCurrentLocation().getMonstersInRoom()) {
                    if (monsterInRoom.equalsIgnoreCase(firstInput.substring(5))) {
                        for (Monster monster : adventure2.getMonsters()) {
                            if (monster.getName().equalsIgnoreCase(monsterInRoom)) {
                                String secondInput = adventure2.getInputFromUser();
                                if (secondInput.equalsIgnoreCase("attack")) {
                                    adventure2.duelWithoutItem(player, monster);
                                    if (duelMonsters == false) {
                                        break;
                                    }
                                } else if (secondInput.startsWith("attack with")) {
                                    for (Item item : currentLocation.getItems()) {
                                        if (currentLocation.getItems().length > 0 || currentLocation.getItems() != null) {
                                            if (item.getName().equals(secondInput.substring(12))) {
                                                duelMonsters = adventure2.duelWithItem(player, monster, item);
                                                if (duelMonsters == false) {
                                                    break;
                                                }
                                            } else {
                                                System.out.println("You can't use that.");
                                            }
                                        } else {
                                            System.out.println("You can't use that.");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        duelMonsters = true;
                        System.out.println("I can’t " + firstInput);
                    }
                }
            }

            /**
             * check if input format is correct and implement it.
             */
            else if (firstInput.contains("go")) {
                if (firstInput.contains("east")
                        || firstInput.contains("west") || firstInput.contains("north")
                        || firstInput.contains("south") || firstInput.contains("up") || firstInput.contains("down")) {
                    boolean hasMoved = false;
                    for (int i = 0; i < player.getCurrentLocation().getDirections().length; i++) {
                        if (player.getCurrentLocation().getMonstersInRoom().length == 0 || player.getCurrentLocation().getMonstersInRoom() == null) {
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
                        } else {
                            System.out.print("Monster is alive, ");
                            break;
                        }
                    }
                    if (hasMoved == false) {
                        System.out.println("You can't " + firstInput);
                    }
                } else {
                    System.out.println("I don't understand: " + firstInput);
                    System.out.println(currentLocation.getDescription());
                    System.out.println("From here you can go: ");
                    for (int i = 0; i < currentLocation.getDirections().length; i++) {
                        System.out.print(currentLocation.getDirections()[i].getDirectionName() + ", ");
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
                        currentLocation.dropItem(item);
                        player.dropItemsInHand(item);
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
                        System.out.print(item.getName() + ", ");
                    }
                    System.out.println();
                } else {
                    System.out.println("You have nothing.");
                }
            } else {
                System.out.println("I cannot understand " + firstInput);
            }
        }
    }
}
