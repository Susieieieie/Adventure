package com.example;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.deploy.net.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;

public class Parse {
    public static JsonObject getRootobj() throws IOException{
        String sURL = "https://courses.engr.illinois.edu/cs126/adventure/siebel.json";
        URL url = new URL(sURL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        JsonParser jp = new JsonParser();
        InputStream inStream = url.openStream();
        JsonElement root = jp.parse(new InputStreamReader(inStream));
        request.getContent();
        JsonObject rootobj = root.getAsJsonObject();
        return rootobj;
    }
}
