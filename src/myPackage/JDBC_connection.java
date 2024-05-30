package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_connection {

        public static void main(String[] args) {

            // connection details
            String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
            String username = "root";
            String password = "tirth@G503";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Connection
                Connection connection = DriverManager.getConnection(url,username,password);
                System.out.println("Connection Successfully Established!");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }