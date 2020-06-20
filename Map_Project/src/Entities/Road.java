package Entities;

public class Road {

    private int townA, townB;
    private double distance;
    private double maxWeight;
    private double maxHeight;
    private double price;
    private double topSpeed;
    private boolean pedestrianWay;
    private boolean bicycleWay;

    public Road(String newTownA, String newTownB, String newDistance, String newMaxWeight,
                String newMaxHeight, String newTopSpeed, String newPrice, String pedestrian,String bicycle)
    {
        this.townA = Town.getIndex(newTownA);
        this.townB = Town.getIndex(newTownB);
        this.distance = Double.valueOf(newDistance);
        this.maxWeight = Double.valueOf(newMaxWeight);
        this.maxHeight = Double.valueOf(newMaxHeight);
        this.topSpeed = Double.valueOf(newTopSpeed);
        this.pedestrianWay = Boolean.getBoolean(pedestrian);
        this.bicycleWay = Boolean.getBoolean(bicycle);
        this.price = Double.valueOf(newPrice);
    }


    public Road(String newTownA, String newTownB, double newDistance, double newMaxWeight,
                double newMaxHeight, double newTopSpeed, double newPrice, boolean pedestrian, boolean bicycle)
    {
        this.townA = Town.getIndex(newTownA);
        this.townB = Town.getIndex(newTownB);
        this.distance = newDistance;
        this.maxWeight = newMaxWeight;
        this.maxHeight = newMaxHeight;
        this.topSpeed = newTopSpeed;
        this.pedestrianWay = pedestrian;
        this.bicycleWay = bicycle;
        this.price = newPrice;
    }

    Road(int newTownA, int newTownB, double newDistance, double newMaxWeight,
         double newMaxHeight, double newTopSpeed, double newPrice, boolean pedestrian, boolean bicycle)
    {
        this.townA = newTownA;
        this.townB = newTownB;
        this.distance = newDistance;
        this.maxWeight = newMaxWeight;
        this.maxHeight = newMaxHeight;
        this.topSpeed = newTopSpeed;
        this.pedestrianWay = pedestrian;
        this.bicycleWay = bicycle;
        this.price = newPrice;
    }
    public Road() {

    }
    public boolean possibleTransport(Transport t) {
        if (t.walky()) {
            if (pedestrianWay)
                return true;
            return false;
        }
        if (t.biky()) {
            if (bicycleWay)
                return true;
            return false;
        }
        if (maxWeight > t.getWeight() && maxHeight > t.getHeight())
            return true;
        return false;
    }
    private double min(double a, double b)
    {
        if (a < b)
            return a;
        return b;
    }
    Cost getCost(Transport t)
    {
        if (!possibleTransport(t))
            return new Cost(1000, 1000, 1000, false);


        double newTime = distance / min(topSpeed, t.getTopSpeed());
        double newPay = price;

        if (bicycleWay && t.biky())
            newPay = price / 2;
        if (pedestrianWay && t.walky())
            newPay = 0;

        return new Cost(newTime, newPay, distance, true);
    }

    public int getTownA() {
        return townA;
    }
    public int getTownB() {
        return townB;
    }


    public String getTownAName() {
        return Town.getName(townA);
    }

    public String getTownBName() {
        return Town.getName(townB);
    }


    void displayRoad() {
        System.out.println("There is a road from: " +
                Town.names.get(townA) + " to " +
                Town.names.get(townB) + " and vice versa");
    }

    public String getDistance() {
        return Double.toString(distance);
    }

    public String getWeight() {
        return Double.toString(maxWeight);
    }

    public String getHeight() {
        return Double.toString(maxHeight);
    }

    public String getPrice() {
        return Double.toString(price);
    }

    public String getSpeed() {
        return Double.toString(topSpeed);
    }

    public String getPedestrian() {
        return Boolean.toString(pedestrianWay);
    }
    public String getBicycle() {
        return Boolean.toString(bicycleWay);
    }

    public String textRoad() {
        return new String("There is a road from town: " + Town.names.get(townA) + " to " + Town.names.get(townB));
    }
}
