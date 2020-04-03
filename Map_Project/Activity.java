public class Activity extends Node {

    private double happiness;
    private double time;
    private String activityName;

    Activity(String placeName, String activityName, double happiness, double time) {

        names.add(placeName);
        allIndex++;

        this.name = placeName;
        this.activityName = activityName;
        this.happiness = happiness;
        this.time = time;
    }
    String getActivityName() {
        return this.activityName;
    }
    void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
