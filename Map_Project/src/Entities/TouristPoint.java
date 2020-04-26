package Entities;

public class TouristPoint extends Node {

    private double beautyLevel;
    private double time;
    private String touristActionName;

    TouristPoint(String placeName, String touristActionName, double BeautyLevel, double time) {

        names.add(placeName);
        allIndex++;

        this.name = placeName;
        this.touristActionName = touristActionName;
        this.beautyLevel = beautyLevel;
        this.time = time;
    }
    String touristActionName() {
        return this.touristActionName;
    }
    void settouristActionName(String activityName) {
        this.touristActionName = activityName;
    }
}
