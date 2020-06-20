package Services;

import Entities.Road;
import Entities.Town;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TownDatabase {

        private static Services.TownDatabase instance;

        private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        private static final String INSERT_STATEMENT = "INSERT INTO towns (Name) VALUES (?);";
        private static final String SELECT_STATEMENT = "SELECT * FROM towns WHERE Name LIKE ?;";

        private static final String DELETE_STATEMENT = "TRUNCATE towns";

        private TownDatabase() {
        }

        public static Services.TownDatabase getInstance() throws SQLException {
            if (instance == null) {

                PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT);
                try (ResultSet result = statement.executeQuery()) {

                }
                catch (SQLException s) {
                }
                instance = new Services.TownDatabase();
            }

            return instance;
        }

        public Town saveTown(Town myTown) {
            try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {

                statement.setString(1, myTown.getName());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new town was inserted successfully!");
                }
            } catch (SQLException e) {
                System.out.println("Something went wrong when trying to insert a new town: " + e.getMessage());
            }
            return myTown;
        }
        public String findRoad(String Town) throws SQLException {
            try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {

                statement.setString(1, Town);

                ArrayList<Road> arr = new ArrayList<>();

                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    return "Found";
                }
            }
            catch (SQLException e) {
                System.out.println("Something went wrong when trying to insert a new town: " + e.getMessage());
            }
            return "Not found";
        }
    }
