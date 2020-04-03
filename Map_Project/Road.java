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
    private boolean possibleTransport(Transport t) {
        if (pedestrianWay && t.walky())
            return true;
        if (bicycleWay && t.biky())
            return true;
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
    private double max(double a, double b)
    {
        return a + b - min(a, b);
    }

    private Cost getCost(Cost c, Transport t)
    {
        if (!possibleTransport(t))
            return new Cost(0, 0, 0, true);


        double newTime = distance / min(topSpeed, t.getTopSpeed());
        double newPay = price;

        if (bicycleWay && t.biky())
            newPay = 0;
        if (pedestrianWay && t.walky())
            newPay = 0;

        return new Cost(newTime, newPay, distance, true);
    }
}
