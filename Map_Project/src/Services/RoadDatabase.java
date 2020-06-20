package Services;
import Entities.Road;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RoadDatabase {

    private static RoadDatabase instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO roads (townA, townB, Distance, Weight, Height, Speed, Price, pedestrian, bicycle) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_STATEMENT = "SELECT * FROM roads WHERE TownA LIKE ?;";

    private static final String DELETE_STATEMENT = "TRUNCATE roads";

    private RoadDatabase() {
         }

    public static RoadDatabase getInstance() throws SQLException {
        if (instance == null) {

            PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT);
            try (ResultSet result = statement.executeQuery()) {

            }
            catch (SQLException s) {
            }
            instance = new RoadDatabase();
        }

        return instance;
    }

    public Road saveRoad(Road myRoad) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {

            statement.setString(1, myRoad.getTownAName());
            statement.setString(2, myRoad.getTownBName());
            statement.setString(3, myRoad.getDistance());
            statement.setString(4, myRoad.getWeight());
            statement.setString(5, myRoad.getHeight());
            statement.setString(6, myRoad.getPrice());
            statement.setString(7, myRoad.getSpeed());
            statement.setString(8, myRoad.getPedestrian());
            statement.setString(9, myRoad.getBicycle());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new road was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new road: " + e.getMessage());
            return new Road();
        }
        return myRoad;
    }
    public ArrayList<Road> findRoad(String TownA) throws SQLException {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {

            statement.setString(1, TownA);

            ArrayList<Road> arr = new ArrayList<>();

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Road myRoad = new Road(result.getString("TownA"), result.getString("TownB"),
                        result.getString("Distance"), result.getString("Weight"),
                        result.getString("Height"),
                        result.getString("Price"), result.getString("Speed"),
                        result.getString("Pedestrian"), result.getString("Bicycle"));
                arr.add(myRoad);
            }
            return arr;
        }
    }
}