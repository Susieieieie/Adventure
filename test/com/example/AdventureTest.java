package com.example;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdventureTest {
    private static Adventure adventure;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
        final HttpResponse<String> stringHttpResponse = Unirest.get(url).asString();
        if (stringHttpResponse.getStatus() == 200) {
            String json = stringHttpResponse.getBody();
            adventure = gson.fromJson(json, Adventure.class);
        }
    }

    @Test
    public void main() {
    }

    @Test
    public void getStartingRoomTest() {
        assertEquals("MatthewsStreet", adventure.getStartingRoom());
    }

    @Test
    public void getDescriptionTest() {
        assertEquals("You are on Matthews, outside the Siebel Center", adventure.getRooms()[0].getDescription());
    }

    @Test
    public void getDirectionName(){
        assertEquals("East", adventure.getRooms()[0].getDirections()[0].getDirectionName());
    }

    @Test



}