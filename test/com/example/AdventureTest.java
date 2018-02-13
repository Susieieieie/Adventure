package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdventureTest {
    private static Adventure adventure;
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
            "      \"attack\": 70.0,\n" +
            "      \"defense\": 50.0,\n" +
            "      \"health\": 250.0\n" +
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
            "          \"damage\": 80.0\n" +
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

    @Before
    public void setUp() throws Exception {
        Gson json = new Gson();
        adventure = json.fromJson(JSON_FILE, Adventure.class);
    }

    @Test
    public void getStartingRoomTest() {
        assertEquals("Room one", adventure.getStartingRoom());
    }

    @Test
    public void getDescriptionTest() {
        assertEquals("You are on Room one, there is trash everywhere", adventure.getRooms()[0].getDescription());
    }

    @Test
    public void getDirectionName(){
        assertEquals("East", adventure.getRooms()[0].getDirections()[0].getDirectionName());
    }

    @Test
    public void findingEndingRoomTest(){
        assertEquals("Room eight", adventure.getEndingRoom());
    }

    @Test
    public void levelUpTest(){
        assertEquals(300.0, adventure.levelUp(adventure.getPlayer(), adventure.getMonsters()[1]),0.0001);
    }

    @Test
    public void statusPlayerTest(){
        assertEquals("####################",adventure.statusPlayer(adventure.getPlayer()));
    }

    @Test
    public void removeMonsterTest(){
        assertEquals("Bear",adventure.removeMonster(adventure.getMonsters()[0])[0].getName());
    }

    @Test
    public void takeItemTest(){
        assertEquals("apple",adventure.getRooms()[0].takeItem(adventure.getRooms()[1].getItems()[0])[0].getName());
    }

    @Test
    public void removeMonstersInRoom(){
        assertEquals("Ape",adventure.getRooms()[0].removeMonsterInRoom(adventure.getRooms()[1].getMonstersInRoom()[0])[0]);
    }

}