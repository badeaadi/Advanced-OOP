package Services;

import Entities.Map;
import Entities.Road;
import Entities.Town;
import Entities.Transport;

import java.io.*;
import java.sql.Timestamp;
import java.util.Scanner;


public class UserService {
    private static UserService ourInstance = new UserService();

    public static UserService getInstance() {
        return ourInstance;
    }

    private UserService() {
    }
    void startOperations(Map myMap) throws IOException {

        RunnableThread myThread = new RunnableThread();


        System.out.println("Type help for operations");
        System.out.println("Type stop for ending program");
        Scanner fin = new Scanner(System.in);
        FileWriter fw  = new FileWriter(new File("console.csv"), true);

        String line;
        String lineSecond;
        String lineGood;

        do {
            line = fin.nextLine();

            switch (line.toLowerCase()) {
                case "help":
                    helpUI();
                    break;
                case "display transports":
                    myMap.displayTransports();
                    break;
                case "display roads":
                    myMap.displayRoads();
                    break;
                case "find road":

                    lineSecond = fin.nextLine();
                    String[] towns = lineSecond.split(" ");
                    if (towns.length > 2)
                        System.out.println("Invalid number of parameters");

                    line += " " + lineSecond;
                    myMap.displayAllBest(towns[0], towns[1]);
                    break;
                case "add road":
                    System.out.println("Input: TownA,TownB, Distance, Weight, Height, Speed, Price");

                    lineSecond = fin.nextLine() + " false false\n";
                    String[] commands = lineSecond.split(" ");
                    Road thisRoad = Service.getInstance().createRoad(commands);

                    myMap.addRoad(thisRoad);

                    FileWriter auxRoad  = new FileWriter(new File("roads.csv"), true);


                    lineGood = getCsvString(lineSecond);
                    auxRoad.write(lineGood);
                    auxRoad.close();

                    break;

                case "add town":
                    System.out.println("Input: Name of town");

                    lineSecond = fin.nextLine() + "\n";
                    Town thisTown = new Town(lineSecond);
                    myMap.addTown(thisTown);

                    lineGood = getCsvString(lineSecond);
                    FileWriter auxTown  = new FileWriter(new File("towns.csv"), true);
                    auxTown.write(lineGood);
                    auxTown.close();
                    break;

                case "add transportation":

                    System.out.println("Input: Name, weight, height, top speed");

                    lineSecond = fin.nextLine() + "\n";
                    lineGood = getCsvString(lineSecond);
                    FileWriter auxTransport = new FileWriter(new File("transports.csv"), true);

                    String[] commandsT = lineSecond.split(" ");
                    Transport thisTransport = new Transport(commandsT[0],
                                                            false, false,
                                                            Double.parseDouble(commandsT[1]),
                                                            Double.parseDouble(commandsT[2]),
                                                            Double.parseDouble(commandsT[3]));
                    myMap.addTransport(thisTransport);

                    auxTransport.write(lineGood);
                    auxTransport.close();
                    break;
                case "stop":
                    break;

                default:
                    System.out.println("Invalid command");
                    break;
            }
            writetime(line + ",thread: " + myThread.getName(), fw);

        } while (!line.equals("stop"));

        System.out.println("Program shut");
        fw.close();
    }

    private String getCsvString(String lineSecond) {
        String line = lineSecond.replaceAll(" ", " ,");
        return line.replaceAll(" ", "");
    }

    public void writetime(String line, FileWriter fw) throws IOException {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        fw.write(line + "," + timestamp.toString() + "\n");
    }

    private void helpUI() {

        System.out.println("Display commands:");
        System.out.println("Display roads/transports");

        System.out.println("Qeury commands to find or add ways of one or more roads:(multiple line query):");
        System.out.println("Find road");
        System.out.println("Add town/transportation/road");

    }
}
