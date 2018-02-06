package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdventureTest {
    public static final String JSON_FOR_URL_TEXT = "{\n" +
            "  \"startingRoom\": \"MatthewsStreet\",\n" +
            "  \"endingRoom\": \"Siebel1314\",\n" +
            "  \"rooms\": [\n" +
            "    {\n" +
            "      \"name\": \"MatthewsStreet\",\n" +
            "      \"description\": \"You are on Matthews, outside the Siebel Center\",\n" +
            "      \"items\": [\"coin\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n";
    public static final String JSON_FOR_ARRAY_OF_TEXT = "[{\n" +
            "  \"startingRoom\": \"MatthewsStreet\",\n" +
            "  \"endingRoom\": \"Siebel1314\",\n" +
            "  \"rooms\": [\n" +
            "    {\n" +
            "      \"name\": \"MatthewsStreet\",\n" +
            "      \"description\": \"You are on Matthews, outside the Siebel Center\",\n" +
            "      \"items\": [\"coin\"],\n" +
            "      \"directions\": [\n" +
            "        {\n" +
            "          \"directionName\": \"East\",\n" +
            "          \"room\": \"SiebelEntry\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n]";
    public static Adventure adventure;
    public  static Adventure[] adventureArray;
    public static ArrayList<Adventure> adventures;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        adventure = gson.fromJson(JSON_FOR_URL_TEXT, Adventure.class);
        adventureArray = gson.fromJson(JSON_FOR_ARRAY_OF_TEXT, Adventure[].class);
        adventures = new ArrayList<Adventure>();
        for (int i = 0; i < adventureArray.length; i++) {
            adventures.add(adventureArray[i]);
        }
    }

    @Test
    public void main() {
    }

}