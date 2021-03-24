package com.company;

import java.io.IOException;
import java.sql.SQLException;

public class Main {


    void run() throws SQLException {
        //Instances

        //jdbcWriter.insertChild(child.createChild(false));
        //jdbcWriter.insertParent(parent.createParent());
        //jdbcWriter.addDBToArrayList();
        //jdbcWriter.printArrayList(true, true, true);

        //System.out.println(jdbcWriter.searchForChildOrParent(true).toString());

        //jdbcWriter.updateChild(jdbcWriter.editChild(jdbcWriter.searchForChildOrParent(false)));
        //jdbcWriter.deleteChild(jdbcWriter.searchForChildOrParent( "hej",false));
        //jdbcWriter.printArrayList(true, true, true);


        //Method Calls
        //System.out.println(child.createChild(true).toString());
        //System.out.println(parent.createParent().toString());
        MenuSwitches menuSwitches = new MenuSwitches();
        menuSwitches.mainMenu();
    }


    public static void main(String[] args) throws SQLException {
        new Main().run();
    }
}
