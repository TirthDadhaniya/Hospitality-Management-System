package myPackage;

import java.sql.SQLException;

public class HotelApplication extends Hotel{

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        createTable();
        addHotel("Skylon hotel bt Brizz Glow", "Ahmedabad", "Everything");

    }
}
