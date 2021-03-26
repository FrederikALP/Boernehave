package com.company;

import java.io.IOException;
import java.sql.SQLException;

public class Main {


    void run() throws SQLException {
        MenuSwitches menuSwitches = new MenuSwitches();
        menuSwitches.mainMenu();
    }


    public static void main(String[] args) throws SQLException {
        new Main().run();
    }
}
