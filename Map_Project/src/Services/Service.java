package Services;

import Entities.Activity;
import Entities.Road;
import Entities.Town;
import Entities.Transport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Service {

    private static Service ourInstance = new Service();




    static Service getInstance() {

        return ourInstance;
    }

    private Service() {

        System.out.println("Initialized service class");
    }
    Road createRoad(String[] data) {
        Road thisRoad = new Road(data[0], data[1],
                Double.parseDouble(data[2]),
                Double.parseDouble(data[3]),
                Double.parseDouble(data[4]),
                Double.parseDouble(data[5]),
                Double.parseDouble(data[6]),
                Boolean.parseBoolean(data[7]),
                Boolean.parseBoolean(data[8]));
        return thisRoad;
    }

    ArrayList<Town> readTowns(String pathToCsv) throws IOException {

        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));

        String line;
        ArrayList<Town> newTowns = new ArrayList<>();

        while ((line = csvReader.readLine()) != null) {
            String[] data = line.split(",");
            newTowns.add(new Town(data[0]));
        }
        csvReader.close();
        return newTowns;
    }

    ArrayList<Transport> readTransports(String pathToCsv) throws IOException {

        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));

        String line;
        ArrayList<Transport> newTransports = new ArrayList<>();

        while ((line = csvReader.readLine()) != null) {
            String[] data = line.split(",");
            Transport thisTransport = new Transport(data[0], false, false,
                                                    Double.parseDouble(data[1]),
                                                    Double.parseDouble(data[2]),
                                                    Double.parseDouble(data[3]));
            newTransports.add(thisTransport);
        }
        csvReader.close();
        return newTransports;
    }


    ArrayList<Road> readRoads(String pathToCsv) throws IOException {

        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));

        String line;
        ArrayList<Road> newRoads = new ArrayList<>();

        while ((line = csvReader.readLine()) != null) {
            String[] data = line.split(",");
            Road thisRoad = createRoad(data);
            newRoads.add(thisRoad);
        }
        csvReader.close();
        return newRoads;
    }

    ArrayList<Activity> readActivities(String pathToCsv) throws IOException {

        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));

        String line;
        ArrayList<Activity> newActivities = new ArrayList<>();

        while ((line = csvReader.readLine()) != null) {
            String[] data = line.split(",");
            Activity thisActivity = new Activity(data[0], data[1],
                                Double.parseDouble(data[2]),
                                Double.parseDouble(data[3]));

            newActivities.add(thisActivity);
        }
        csvReader.close();
        return newActivities;
    }


}
