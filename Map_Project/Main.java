public class Main {

    public static void main(String [] args)
    {
        Harta myHarta = Harta.getInstance();

        myHarta.addTown(new Town("Valcea"));
        myHarta.addTown(new Town("Bucuresti"));
        myHarta.addTown(new Town("Pitesti"));


        myHarta.addTransport(Transport.get_pedestrian());

        myHarta.addTransport(Transport.get_bicicleta());

        myHarta.addTransport(new Transport("Masina", false, false, 2000, 1.5,  130));



        myHarta.addRoad(new Road("Valcea", "Pitesti", 60, 3500, 3, 60, 5, true, true));

        myHarta.addRoad(new Road("Pitesti", "Bucuresti", 120, 3500, 3, 130, 12, true, true));



    }
}
