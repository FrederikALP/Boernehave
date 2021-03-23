package com.company;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class JDBCWriter {

    private static Connection connection = null;
    ArrayList<Object> arrayList = new ArrayList<>();
    UserInput userInput = new UserInput();


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

    public void insertChild(Child child) throws SQLException {

        String insStr = "INSERT INTO childs(firstname, lastname, age, waitlist, idparent) VALUES('" +
                child.getFirstNameChild() + "','" +
                child.getLastNameChild() + "','" +
                child.getAgeChild() + "'," +
                child.getOnWaitList() + "," +
                child.getIdParent() + ")";
        Statement s = connection.createStatement();
        s.execute(insStr);
    }
    public void insertParent(Parent parent) throws SQLException {

        String insStr = "INSERT INTO parents(firstname, lastname, phonenumber, streetname, zipcode, city) VALUES('" +
                parent.getFirstName() + "','" +
                parent.getLastName() + "','" +
                parent.getPhoneNumber() + "','" +
                parent.getStreetName() + "','" +
                parent.getZipcode() + "','" +
                parent.getCity() + "')";
        Statement s = connection.createStatement();
        s.execute(insStr);
    }

    public void updateChild(Child child) throws SQLException {

        String insStr = "UPDATE childs set firstname = '" + child.getFirstNameChild() +
                "', lastname ='" + child.getLastNameChild() +
                "', age ='" + child.getAgeChild() +
                "', waitlist =" + child.getOnWaitList() +
                ", idparent ='" + child.getIdParent() +
                "' where idchild = " + child.getIdChild();
        Statement s = connection.createStatement();
        s.execute(insStr);
    }


    Object searchForChildOrParent(boolean parentTrueChildFalse) {
        String name = userInput.inputString("Enter name of child: " , true);
        ArrayList<Object> personFound = new ArrayList<>();

        String parentOrChild;
        if (parentTrueChildFalse)
            parentOrChild = "ParentID:";
        else
            parentOrChild = "idChild=";


        //Loop through and find matches to "searchFor". Send to arraylist.
        for (int i = 0; i<arrayList.size(); i++) {
            if (arrayList.get(i).toString().contains(parentOrChild)) {
                if (arrayList.get(i).toString().contains(name)) {
                personFound.add(arrayList.get(i));
                }
            }
        }

        //With only one hit
        if (personFound.size() ==1){
            return personFound.get(0);
        } else if (personFound.size()>1){
            //More than one hit
            for (int i = 0; i < personFound.size(); i++) {
                System.out.println((i + 1) + "."); //Displays index numbers+1
                System.out.println(personFound.get(i).toString());
            }
            int reInput = userInput.inputInt(1,personFound.size(),"Skriv index nummer for den " + " du vil vælge.")-1;
            return personFound.get(reInput);
        } else {
            //No hits on the search-term.
            System.out.println("Der kunne ikke findes nogen med søgningen: " + name + ". Prøv igen!" );
            Object obj = searchForChildOrParent(parentTrueChildFalse);
            return obj;
        }
    }

    public Child editChild(Object object) {
        Child child = (Child) object;

        boolean run = true;
        int menuChoice;

        while (run){
            menuChoice = (userInput.inputInt(child.toString() + "\n" + "Vælg 1 for at ændre fornavn\nVælg 2 for at ændre efternavn\n" +
                    "Vælg 3 for at ændre alder\nVælg 4 for at ændre ventelistestatus\nVælg 5 for at ændre forældreID" +
                    "\nVælg 6 for at gemme ændringerne"));
            switch (menuChoice){
                case 1:
                    child.setFirstNameChild(userInput.inputString("Skriv fornavnet venligst",true));
                    break;
                case 2:
                    child.setLastNameChild(userInput.inputString("Skriv efternavnet venligst",true));
                    break;
                case 3:
                    child.setAgeChild(userInput.inputInt("Skriv barnets alder venligst"));
                    break;
                case 4:
                    child.setOnWaitList(userInput.inputBoolean("Vælg boolean venligst"));
                    break;
                case 5:
                    child.setIdParent(userInput.inputInt("Skriv fornavnet venligst"));
                    break;
                case 6: //Luk
                    run = false;
                    break;
                default:
            }
        }
        return child;
    }
}

