package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_test {

        public static void main(String[] args) {

            // connection details
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Connection
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/", "root", "tirth@G503");

                // Statement
                Statement statement = connection.createStatement();











                //create table
                statement.executeUpdate("create table employee (No int, Name varchar(30), Salary int)");
                System.out.println("Table created");
                connection.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }