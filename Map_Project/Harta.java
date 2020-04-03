import java.util.*;

public class Harta {

    private ArrayList<Town> towns = new ArrayList<>();
    private ArrayList<Transport> transports = new ArrayList<>();
    private ArrayList<Road> roads = new ArrayList<>();

    private Cost getCost(int firstIndex, int secondIndex, Comparator<Cost> comp) {

        Cost sol = new Cost(1000, 1000, 1000, true);

        for (Transport trans : transports) {
            PriorityQueue<Cost> pq = new PriorityQueue<>(5, comp);

            int[] viz = new int[towns.size()];
            pq.clear();
            pq.add(new Cost(0.0, 0.0, 0.0, true, firstIndex));
            while (pq.size() != 0) {
                Cost here = pq.poll();
                if (viz[here.getIndex()] == 1)
                    continue;
                viz[here.getIndex()] = 1;

                if (here.getIndex() == secondIndex) {
                    Cost sol_here = here;
                    sol_here.setTrans(trans.getName());
                    if (comp.compare(sol_here, sol) < 0)
                        sol = sol_here;
                    pq.clear();
                    break;
                }
                for (Road road : roads) {
                    if (!road.possibleTransport(trans))
                        continue;

                    int otherIndex = -1;

                    if (road.getTownA() == here.getIndex())
                        otherIndex = road.getTownB();
                    if (road.getTownB() == here.getIndex())
                        otherIndex = road.getTownA();

                    if (otherIndex >= 0) {
                        Cost newCost = here.add(road.getCost(trans));
                        newCost.setIndex(otherIndex);

                        pq.add(newCost);
                    }
                }
            }
        }
        return sol;
    }
    private Cost getBestTime(int firstIndex, int secondIndex) {
        return getCost(firstIndex, secondIndex, new CostTime());
    }
    private Cost getBestPay(int firstIndex, int secondIndex) {
        return getCost(firstIndex, secondIndex, new CostPay());
    }
    private Cost getBestDistance(int firstIndex, int secondIndex) {
        return getCost(firstIndex, secondIndex, new CostDistance());
    }

    //Overloading displayAllBest, for strings or indexes
    void displayAllBest(String first, String second) {

        System.out.println();
        System.out.println("From " + first + " to " + second);
        displayAllBest(Town.getIndex(first), Town.getIndex(second));
    }
    void displayAllBest(int firstIndex, int secondIndex) {

        System.out.println("For the best time:");
        System.out.println(getBestTime(firstIndex, secondIndex));

        System.out.println("For the best pay:");
        System.out.println(getBestPay(firstIndex, secondIndex).toString());

        System.out.println("For the best distance traveled:");
        System.out.println(getBestDistance(firstIndex, secondIndex).toString());

    }
    //Singleton design pattern for the map
    private static Harta single_instance = null;
    public static Harta getInstance() {
        if (single_instance == null)
            single_instance = new Harta();
        return single_instance;
    }


    public void addTown(Town newTown) {
        towns.add(newTown);
    }
    public void addTransport(Transport newTransport) {
        transports.add(newTransport);
    }
    public void addRoad(Road newRoad) {
        roads.add(newRoad);
    }
    public void displayTransports() {
        System.out.println("TRANSPORTS:");
        for (Transport t : transports)
            t.displayTransport();
    }

    public void displayRoads() {
        System.out.println("ROADS:");
        for (Road r : roads)
            r.displayRoad();
    }
}
