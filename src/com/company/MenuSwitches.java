package com.company;

import java.sql.SQLException;

public class MenuSwitches {

    UserInput userInput = new UserInput();
    JDBCWriter jdbcWriter = new JDBCWriter();
    Child child = new Child();
    Parent parent = new Parent();

    void mainMenu() throws SQLException {
        jdbcWriter.setConnection("gustav","0108");
        jdbcWriter.addDBToArrayList();
        jdbcWriter.printArrayList(true,true,true);
        boolean run = true;
        int menuChoice;
        String headertext = "Børnehave program ";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Oversigt over børn og forældre", "2. Børnehavebørn Menu", "3. Forældredata Menu.", "4. Ventelistebørn Menu", "0. Luk programmet"};

        while (run){
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = (userInput.inputInt());
            switch (menuChoice){
                case 1:
                    overviewMenu();
                    break;
                case 2:
                    createChildMenu();
                    break;
                case 3:
                    parentMenu();
                    break;
                case 4:
                    createWaitlistChildMenu();
                    break;
                case 0:
                    run = false;
                    break;
                default:
            }
        }
    }

    void overviewMenu() {
        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "Oversigtsmenu ";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Vis børnehavens børn ", "2. Vis børn på venteliste", "3. Vis forældre", "4. Vis alle børn of forældre",
                "5. Vis alle børn i børnehaven & på venteliste", "6. Søg efter et barn i børnehaven","7. Søg efter et barn fra ventelisten" ,
                "8. Søg efter en forældre" , "0. Gå tilbage til hovedmenu"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt();
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
                case 4:
                    jdbcWriter.printArrayList(true, true, true);
                    break;
                case 5:
                    jdbcWriter.printArrayList(true, true, false);
                    break;
                case 6: //Søg efter et barn i børnehaven
                    jdbcWriter.searchForChildOrParent("Søg efter et barn i børnehaven",false,false);
                    break;
                case 7://Søg efter et barn på ventelisten
                    jdbcWriter.searchForChildOrParent("Søg efter et barn på ventelisten",false,true);
                    break;
                case 8://Søg efter en forældre
                    jdbcWriter.searchForChildOrParent("Søg efter en forældre", true,false);
                    break;
                default:
                    System.out.println("");
            }
        }
    }

    void createChildMenu() throws SQLException {
        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "Børnemenu ";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Tilføj barn med nye forældre", "2. Tilføj barn med eksisterende forældre", "3. Rediger barn",
                "4. Slet børnehave barn", "0. Gå tilbage til hovedmenu"};

        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt();
            switch (menuChoice) {
                case 0: //End program
                    run = false;
                    break;
                case 1: //Tilføj barn med nye forældre
                    jdbcWriter.insertDB(child.createChild(false, jdbcWriter.insertDB(parent.createParent())));
                    break;
                case 2: //Tilføj barn med eksisterende forældre
                    jdbcWriter.insertDB(child.createChild(false));
                    break;
                case 3: //Rediger barn
                    jdbcWriter.printArrayList(true, false, false);
                    jdbcWriter.updateDB(jdbcWriter.editChild(jdbcWriter.searchForChildOrParent("Søg på det barn du vil redigere",false, false)));
                    break;
                case 4: //Slet børnehave barn
                    jdbcWriter.printArrayList(true, false, false);
                    jdbcWriter.deleteChild(jdbcWriter.searchForChildOrParent( "Skriv navn/id på det barn der skal slettes",false, false));
                    break;
                default:
                    System.out.println("");
            }
        }
    }

    void parentMenu() throws SQLException {
        boolean run = true;
        int menuChoice;
        String headertext = "Forældremenu ";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Opret forældre", "2. Rediger forældre","3. Slet forældre", "0. Gå tilbage til hovedmenu"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt();
            switch (menuChoice) {
                case 0: //End program
                    run = false;
                    break;
                case 1: //Create parent
                    jdbcWriter.insertDB(parent.createParent());
                    break;
                case 2: //Edit parent
                    jdbcWriter.printArrayList(false, false, true);
                    jdbcWriter.updateDB(jdbcWriter.editParent(jdbcWriter.searchForChildOrParent("Søg på den forældre du vil redigere", true, false)));
                    break;
                case 3: //delete parent
                    jdbcWriter.printArrayList(false, false, true);
                    jdbcWriter.deleteParent(jdbcWriter.searchForChildOrParent("Skriv navn/id på det barn der skal slettes", true, false));
                    break;
                default:
                    System.out.println("");
            }
        }
    }

    void createWaitlistChildMenu() throws SQLException {
        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "Oversigtsmenu ";
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Tilføj barn på venteliste med nye forældre ", "2. Tilføj barn på venteliste med eksisterende forældre",
                "3. Rediger barn på venteliste" ,"4. Slet bar fra venteliste", "0. Gå tilbage til hovedmenu"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt();
            switch (menuChoice) {
                case 0: // End program
                    run = false;
                    break;
                case 1: //
                    jdbcWriter.insertDB(child.createChild(true, jdbcWriter.insertDB(parent.createParent())));
                    break;
                case 2: //
                    jdbcWriter.insertDB(child.createChild(true));
                    break;
                case 3: //
                    jdbcWriter.printArrayList(false, true, false);
                    jdbcWriter.updateDB(jdbcWriter.editChild(jdbcWriter.searchForChildOrParent("Søg på det barn du vil redigere",false, true)));
                    break;
                case 4: //
                    jdbcWriter.printArrayList(false, true, false);
                    jdbcWriter.deleteChild(jdbcWriter.searchForChildOrParent( "Skriv navn/id på det barn der skal slettes",false, true));
                    break;
                default:
                    System.out.println("");
            }
        }
    }
}