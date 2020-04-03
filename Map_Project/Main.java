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


    }
}
