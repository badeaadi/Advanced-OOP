class Road {

    private int townA, townB;
    private double distance, maxWeight, maxHeight, price, topSpeed;
    private boolean pedestrianWay, bicycleWay;

    Road(String newTownA, String newTownB, double newDistance, double newMaxWeight, double newMaxHeight, double newTopSpeed, double newPrice, boolean pedestrian, boolean bicycle)
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

    Road(int newTownA, int newTownB, double newDistance, double newMaxWeight, double newMaxHeight, double newTopSpeed, double newPrice, boolean pedestrian, boolean bicycle)
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
    public Cost getCost(Transport t)
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
    public void displayRoad() {
        System.out.println("There is a road from: " + Town.names.get(townA) + " to " + Town.names.get(townB) + " and vice versa");
    }
}
