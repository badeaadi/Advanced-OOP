public class Main {

    private static Harta myHarta = Harta.getInstance();

    static void addDetails() {

        myHarta.addTown(new Town("Valcea"));
        myHarta.addTown(new Town("Bucuresti"));
        myHarta.addTown(new Town("Pitesti"));


        myHarta.addTransport(Transport.get_pedestrian());

        myHarta.addTransport(Transport.get_bicicleta());

        myHarta.addTransport(new Transport("Car", false, false, 2, 1.5,  120));

        myHarta.addTransport(new Transport("Bus", false, false, 20, 3.5,  90));

        myHarta.addTransport(new Transport("Minibus", false, false, 20, 3.5,  130));

        myHarta.addRoad(new Road("Valcea", "Pitesti", 60, 25, 3, 60, 5, true, true));

        myHarta.addRoad(new Road("Pitesti", "Bucuresti", 120, 50, 50, 130, 12, false, true));

        myHarta.addRoad(new Road("Pitesti", "Bucuresti", 110, 25, 5, 80, 8, false, false));

        myHarta.addRoad(new Road("Pitesti", "Bucuresti", 100, 0, 0, 100, 11, false, false));

        myHarta.addActivity(new Activity("Bucuresti", "Learning", 10, 5));
        myHarta.addActivity(new Activity("Bucuresti", "Fun", 10, 10));
    }
    public static void main(String [] args)
    {

        addDetails();
        perfomOperations();

    }

    private static void perfomOperations() {

        myHarta.displayTransports();
        myHarta.displayRoads();
        myHarta.displayAllBest("Pitesti", "Bucuresti");
        myHarta.displayAllBest("Valcea", "Bucuresti");
        myHarta.displayActivities("Bucuresti");
        myHarta.displayActivities("Valcea");

        /*
        OUTPUT:

        TRANSPORTS:
        This transportation is called:Pedestrian
        TopSpeed: 6.0
        This transportation is called:Bicicleta
        TopSpeed: 20.0
        This transportation is called:Car
        All details:
        Weight: 2.0
        Height: 1.5
        TopSpeed: 120.0
        This transportation is called:Bus
        All details:
        Weight: 20.0
        Height: 3.5
        TopSpeed: 90.0
        This transportation is called:Minibus
        All details:
        Weight: 20.0
        Height: 3.5
        TopSpeed: 130.0
        ROADS:
        There is a road from: Valcea to Pitesti and vice versa
        There is a road from: Pitesti to Bucuresti and vice versa
        There is a road from: Pitesti to Bucuresti and vice versa
        There is a road from: Pitesti to Bucuresti and vice versa

        From Pitesti to Bucuresti
        For the best time:
        It takes 0.9230769230769231 hours, 12.0 pay, 120.0 distance,Minibus
        For the best pay:
        It takes 6.0 hours, 6.0 pay, 120.0 distance,Bicicleta
        For the best distance traveled:
        It takes 1.375 hours, 8.0 pay, 110.0 distance,Car

        From Valcea to Bucuresti
        For the best time:
        It takes 2.0 hours, 17.0 pay, 180.0 distance,Car
        For the best pay:
        It takes 9.0 hours, 8.5 pay, 180.0 distance,Bicicleta
        For the best distance traveled:
        It takes 2.375 hours, 13.0 pay, 170.0 distance,Car

        Bucuresti, things to do :
        In Bucuresti there is Learning
        In Bucuresti there is Fun

        Valcea, things to do :
        Sorry, there's nothing to do

        */
    }
}
