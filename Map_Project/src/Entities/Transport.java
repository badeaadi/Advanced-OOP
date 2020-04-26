package Entities;

public class Transport {

    private String name;
    private boolean pedestrian, bicycle;
    private double weight, height, topSpeed;

    public static Transport get_pedestrian() {
        return new Transport("Pedestrian", true, false, 0, 10, 6);
    }
    public static Transport get_bicicleta() {
        return new Transport("Bicicleta", false, true, 0, 0, 20);
    }

    public Transport(String newName, boolean ped, boolean bi, double newWeight, double newHeight, double newTopSpeed) {
        name = newName;
        pedestrian = ped;
        bicycle = bi;
        weight = newWeight;
        height = newHeight;
        topSpeed = newTopSpeed;
    }
    public boolean walky() { return pedestrian; }
    public boolean biky() {
        return bicycle;
    }
    public double getWeight()
    {
        return weight;
    }
    public double getHeight()
    {
        return height;
    }
    public double getTopSpeed()
    {
        return topSpeed;
    }
    public String getName() {return name;}

    public void displayTransport() {
        System.out.println("This transportation is called:" + name);
        if (!walky() && !biky()) {
            System.out.println("All details:");
            System.out.println("Weight: " + weight);
            System.out.println("Height: " + height);
            System.out.println("TopSpeed: " + topSpeed);
        }
        else {
            System.out.println("TopSpeed: " + topSpeed);
        }

    }

}
