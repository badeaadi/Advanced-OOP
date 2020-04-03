import java.util.ArrayList;

public class Harta {

    private static ArrayList<Town> towns = new ArrayList<>();
    private static ArrayList<Transport> transports = new ArrayList<>();
    private static ArrayList<Road> roads = new ArrayList<>();

    static Cost getDistance(int firstIndex, int secondIndex, Transport t) {
        for (int i = 0; i < transports.size(); i++) {

        }

    }

    private static Harta single_instance = null;
    public static Harta getInstance() {
        if (single_instance == null)
            single_instance = new Harta();
        return single_instance;
    }


    public static void addTown(Town newTown) {
        towns.add(newTown);
    }
    public static void addTransport(Transport newTransport) {
        transports.add(newTransport);
    }
    public static void addRoad(Road newRoad) {
        roads.add(newRoad);
    }



}
