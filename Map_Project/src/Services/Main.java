package Services;

import Entities.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static Harta myHarta = Harta.getInstance();

    private static void addDetails() throws IOException {

        //Reading from "towns.csv" - names of towns
        Service myService = Service.getInstance();
        ArrayList<Town> previousTowns = myService.readTowns("towns.csv");

        myHarta.towns.addAll(previousTowns);

        //Adding standard types of transportation
        myHarta.addTransport(Transport.get_pedestrian());
        myHarta.addTransport(Transport.get_bicicleta());
        //Adding transportation from the csv files
        ArrayList<Transport> previousTransport =  myService.readTransports("transports.csv");

        myHarta.transports.addAll(previousTransport);


        //Adding roads from the csv files
        ArrayList<Road> previousRoads = myService.readRoads("roads.csv");

        myHarta.roads.addAll(previousRoads);


        //Adding activities from the csv files
        ArrayList<Activity> previousActivities = myService.readActivities("activities.csv");

        myHarta.activities.addAll(previousActivities);
    }
    public static void main(String [] args) throws IOException {

        addDetails();
        //perfomOperations();
        requestOperations();

    }
    private static void perfomOperations() {


        //These certain operations would produce the output_log.txt file
        myHarta.displayTransports();
        myHarta.displayRoads();
        myHarta.displayAllBest("Pitesti", "Bucuresti");
        myHarta.displayAllBest("Valcea", "Bucuresti");
        myHarta.displayActivities("Bucuresti");
        myHarta.displayActivities("Valcea");
    }
    static String log = "log.csv";
    private static void requestOperations() throws IOException {

        UserService startOperations = UserService.getInstance();
        UserService.getInstance().startOperations(myHarta);
    }
}
