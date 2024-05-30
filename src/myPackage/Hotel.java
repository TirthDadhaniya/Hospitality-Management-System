package myPackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    private int id;
    private String name;
    private String location;
    private String amenities;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getAmenities() { return amenities; }
    public void setAmenities(String amenities) { this.amenities = amenities; }

    public static void createTable() throws SQLException {
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "tirth@G503";
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Hotels (id int AUTO_INCREMENT PRIMARY KEY, name VARCHAR(250) NOT NULL, location VARCHAR(250) NOT NULL, amenities TEXT)");
            System.out.println("Hotel table created");
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addHotel(String name, String location, String amenities) throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "tirth@G503";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        while (true){
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Hotels (name, location, amenities) VALUES (?, ?, ?)");
        statement.setString(1, name);
        statement.setString(2, location);
        statement.setString(3, amenities);
        statement.executeUpdate();
        statement.close();
        connection.close();
        System.out.println("Do you want to add more hotels? (y/n): ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
/*
    public static List<Hotel> getHotels() throws SQLException, ClassNotFoundException {
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "tirth@G503";

        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        List<Hotel> hotels = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Hotels");

        while (resultSet.next()) {
            hotels.add(new Hotel(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("location"),
                    resultSet.getString("amenities")
                ));
            }
            resultSet.close();
            statement.close();
            connection.close();
            return hotels;
    }
        // Implement methods for add, edit, and delete operations using prepared statements*/
}