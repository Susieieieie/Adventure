package com.example;

import com.google.gson.JsonIOException;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;


    public class data {
        /**
         * parse json from URL in
         * @throws IOException
         */
        public data() throws IOException {
            URL url = new URL("https://courses.engr.illinois.edu/cs126/adventure/siebel.json");
            InputStream inStream = url.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inStream,Charset.forName("UTF-8"));
    }
}

