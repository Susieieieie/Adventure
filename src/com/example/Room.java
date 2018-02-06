package com.example;

public class Room {
    public static String name;
    public static String description;
    public static Direction[] directions;
    public static String[] items;

    public static String getName() {
        return name;
    }

    public static String getDescription() {
        return description;
    }

    public static Direction[] getDirections() {
        return directions;
    }

    public static String[] getItems() {
        return items;
    }
}
