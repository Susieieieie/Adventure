package com.example;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.junit.Before;

public class Parse {


    public static Adventure parse() throws Exception {
        Gson gson = new Gson();
        String url = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
        // Make an HTTP request to the above URL
        final HttpResponse<String> stringHttpResponse = Unirest.get(url).asString();
        // Check to see if the request was successful; if so, convert the payload JSON into Java objects
        String json = null;
        if (stringHttpResponse.getStatus() == 200) {
            json = stringHttpResponse.getBody();
        }
        return gson.fromJson(json,Adventure.class);
    }
}
