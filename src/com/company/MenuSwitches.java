package com.company;

import java.sql.SQLException;

public class MenuSwitches {
    //Instances
    UserInput userInput = new UserInput();
    JDBCWriter jdbcWriter = new JDBCWriter();
    Child child = new Child();
    Parent parent = new Parent();



    //@author ludvig+frederik
    void mainMenu() throws SQLException {
        jdbcWriter.setConnection("ludvig","789bog");
        jdbcWriter.addDBToArrayList();
        jdbcWriter.printArrayList(true,true,true);
        boolean run = true;
        int menuChoice;
        String headertext = "Børnehave program ";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Oversigtsmenu", "2. Børnemenu", "3. Forældremenu.", "9. Luk programmet"};

        while (run){
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = (userInput.inputInt("Choose option:"));
            switch (menuChoice){
                case 1:
                    overviewMenu();
                    break;
                case 2:
                    childMenu();
                    break;
                case 3:
                    parentMenu();
                    break;
                case 9:
                    run = false;
                    break;
                default:
            }
        }
    }

    //@author ludvig+frederik
    void overviewMenu() {

        //Instances

        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "Oversigtsmenu ";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Vis børnehavens børn ", "2. Vis børn på venteliste", "3. Vis forældre", "0. Gå tilbage til hovedmenu"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: // End program
                    run = false;
                    break;
                case 1: // List all children
                    jdbcWriter.printArrayList(true,false,false);
                    break;
                case 2: // List all children on waitlist
                    jdbcWriter.printArrayList(false,true,false);
                    break;
                case 3: // Show all parents
                    jdbcWriter.printArrayList(false,false,true);
                    break;
                default:
                    System.out.println("");
            }
        }
    }

    //@author ludvig+frederik
    void childMenu() throws SQLException {
        //instances

        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "Børnemenu ";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Opret barn og forældre", "2. Tilføj barn til venteliste",
                "3. Rediger barn",
                "4. Slet barn","0. Gå tilbage til hovedmenu"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: //End program
                    run = false;
                    break;
                case 1:
                    jdbcWriter.insertChild(child.createChild(false));
                    break;
                case 2:
                    jdbcWriter.insertChild(child.createChild(true));
                    break;
                case 3:
                    jdbcWriter.updateChild(jdbcWriter.editChild(jdbcWriter.searchForChildOrParent("Søg på det barn du vil redigere",false)));
                    break;
                case 4:
                    jdbcWriter.deleteChild(jdbcWriter.searchForChildOrParent( "Skriv navn/id på det barn der skal slettes",false));
                    break;
                default:
                    System.out.println("");
            }
        }
    }

    //@author ludvig+frederik
    void parentMenu() throws SQLException {
        boolean run = true;
        int menuChoice;
        String headertext = "Forældremenu ";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Opret forældre", "2. Rediger forældre","3. Slet forældre", "0. Gå tilbage til hovedmenu"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: //End program
                    run = false;
                    break;
                case 1: //Create parent
                    jdbcWriter.insertParent(parent.createParent());
                    break;
                case 2: //Edit parent
                    jdbcWriter.updateParent(jdbcWriter.editParent(jdbcWriter.searchForChildOrParent("Søg på den forældre du vil redigere", true)));
                    break;
                case 3:

                    break;
                default:
                    System.out.println("");
            }
        }
    }
}