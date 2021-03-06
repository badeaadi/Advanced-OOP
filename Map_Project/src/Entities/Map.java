package Entities;

import java.util.*;

public class Map {


    public ArrayList<Town> towns = new ArrayList<>();
    public ArrayList<Transport> transports = new ArrayList<>();
    public ArrayList<Road> roads = new ArrayList<>();
    public ArrayList<Activity> activities = new ArrayList<>();

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
    public void displayAllBest(String first, String second) {

        System.out.println();
        System.out.println("From " + first + " to " + second);
        displayAllBest(Town.getIndex(first), Town.getIndex(second));
    }
    private void displayAllBest(int firstIndex, int secondIndex) {

        System.out.println("For the best time:");
        System.out.println(getBestTime(firstIndex, secondIndex));

        System.out.println("For the best pay:");
        System.out.println(getBestPay(firstIndex, secondIndex).toString());

        System.out.println("For the best distance traveled:");
        System.out.println(getBestDistance(firstIndex, secondIndex).toString());

    }
    //Singleton design pattern for the map
    private static Map single_instance = null;

    public static Map getInstance() {
        if (single_instance == null)
            single_instance = new Map();
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
    public void addActivity(Activity newActivity) {
        activities.add(newActivity);
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
    public void displayActivities(String name) {
        System.out.println();
        System.out.println(name + ", things to do : ");
        int cnt = 0;
        for (Activity act : activities)
            if (act.getName().equals(name)) {
                System.out.println("In " + name + " there is " + act.getActivityName() );
                cnt ++;
            }
        if (cnt == 0) {
            System.out.println("Sorry, there's nothing to do");
        }
    }

    public String textRoads() {
        String sol = "Roads:\n";
        for (Road r : roads)
            sol = sol.concat(r.textRoad() + '\n');
        return sol;
    }

    public String textTransports() {
        String sol = "Transports:\n";
        for (Transport r : transports)
            sol = sol.concat(r.textTransports() + '\n');
        return sol;
    }
    public String findRoad(String Name) {
        String sol = "Adjacents from " + Name + " are : \n";
        for (Road r : roads)
            if (r.getTownAName().equals(Name))
                sol = sol.concat(r.getTownBName() + '\n') ;
            else
                if (r.getTownBName().equals(Name))
                    sol = sol.concat(r.getTownAName() + '\n');

        if (sol.equals("Adjacents from " + Name + " are : \n"))
            return "No roads found from " + Name;
        return sol;
    }

    public String textTowns() {
        String sol = "Towns:\n";
        for (Town r : towns)
            sol = sol.concat(r.getName() + '\n');
        return sol;
    }
}
