package Services;

import Entities.*;
import GUI.Frame;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    private static Map myMap = Map.getInstance();

    private static void addDetails() throws IOException, SQLException {

        //Reading from "towns.csv" - names of towns
        Service myService = Service.getInstance();
        ArrayList<Town> previousTowns = myService.readTowns("towns.csv");

        myMap.towns.addAll(previousTowns);


        TownDatabase td = TownDatabase.getInstance();
        for (int i = 0; i < previousTowns.size(); i++)
            td.saveTown(previousTowns.get(i));


        //Adding standard types of transportation
        myMap.addTransport(Transport.get_pedestrian());
        myMap.addTransport(Transport.get_bicicleta());
        //Adding transportation from the csv files
        ArrayList<Transport> previousTransport =  myService.readTransports("transports.csv");

        myMap.transports.addAll(previousTransport);


        //Adding roads from the csv files
        ArrayList<Road> previousRoads = myService.readRoads("roads.csv");

        myMap.roads.addAll(previousRoads);
        RoadDatabase Db = RoadDatabase.getInstance();
        for(int i = 0; i < previousRoads.size(); i++)
            Db.saveRoad(previousRoads.get(i));


        //Adding activities from the csv files
        ArrayList<Activity> previousActivities = myService.readActivities("activities.csv");

        myMap.activities.addAll(previousActivities);

        Frame newFrame = new Frame(myMap);


    }
    public static void main(String [] args) throws IOException, SQLException {

        DatabaseConnection myConnection = DatabaseConnection.getInstance();
        
        addDetails();
        //perfomOperations();
        requestOperations();

    }
    private static void perfomOperations() {


        //These certain operations would produce the output_log.txt file
        myMap.displayTransports();
        myMap.displayRoads();
        myMap.displayAllBest("Pitesti", "Bucuresti");
        myMap.displayAllBest("Valcea", "Bucuresti");
        myMap.displayActivities("Bucuresti");
        myMap.displayActivities("Valcea");
    }
    static String log = "log.csv";
    private static void requestOperations() throws IOException {

        UserService startOperations = UserService.getInstance();
        UserService.getInstance().startOperations(myMap);
    }
}
