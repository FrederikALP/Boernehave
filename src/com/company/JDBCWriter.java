package com.company;

import java.sql.*;
import java.util.ArrayList;

public class JDBCWriter {

    private static Connection connection = null;
    ArrayList<Object> arrayList = new ArrayList<>();


    public boolean setConnection(String username, String password) {

        final String url = "jdbc:mysql://127.0.0.1:3306/roskildeboernehave?serverTimezone=UTC";
        boolean bres = false;

        try {
            connection = DriverManager.getConnection(url, username, password);
            bres = true;
            if (bres) {
                System.out.println("Connection status: " + bres);
            }
        } catch (SQLException error) {
            System.out.println("\nNo connection made");
        }
        return bres;
    }

    public void addDBToArrayList() throws SQLException {
        Statement s = connection.createStatement();
        ResultSet rsChild = s.executeQuery("SELECT * from childs");

        if (rsChild != null)
            while(rsChild.next()) {
                arrayList.add(new Child(rsChild.getInt("idchild"), rsChild.getString("firstname"),
                        rsChild.getString("lastname"), rsChild.getInt("age"),
                        rsChild.getBoolean("waitlist"), rsChild.getInt("idparent")));
            }
        ResultSet rsParent = s.executeQuery("SELECT * from parents");
        if (rsParent != null)
            while(rsParent.next()) {
                arrayList.add(new Parent(rsParent.getInt("idparent"), rsParent.getString("firstname"),
                        rsParent.getString("lastname"), rsParent.getInt("phonenumber"),
                        rsParent.getString("streetname"), rsParent.getString("zipcode"), rsParent.getString("city")));
            }
        System.out.println(arrayList);
    }



    public void updateArrayListToDB() {

    }

}
