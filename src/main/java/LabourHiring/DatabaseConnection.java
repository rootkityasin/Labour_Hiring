package LabourHiring;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection databaseLink;

    public Connection getConnection() {



        String url = "jdbc:mysql://localhost:3306/Lobour_Hiring";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        databaseLink = DriverManager.getConnection(url,"root","ya1000ar");

    }catch(Exception e){
        e.printStackTrace();
    }

        return databaseLink;

    }


}
