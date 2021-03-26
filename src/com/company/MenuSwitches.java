package com.company;

import java.sql.SQLException;

public class MenuSwitches {

    UserInput userInput = new UserInput();
    JDBCWriter jdbcWriter = new JDBCWriter();
    Child child = new Child();
    Parent parent = new Parent();

    void mainMenu() throws SQLException {
        jdbcWriter.setConnection("Hanne","Hanne");
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
        String[] menuItems = {"1. Vis børnehavens børn ", "2. Vis børn på venteliste", "3. Vis forældre", "4. Vis alle børn og forældre",
                 "5. Søg efter et barn i børnehaven", "6. Søg efter en forældre", "7. Søg efter et børnehavebarn og de relaterede forældre", "0. Gå tilbage til hovedmenu"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt();
            switch (menuChoice) {
                case 0: // return to mainmenu
                    run = false;
                    break;
                case 1: // List all children
                    jdbcWriter.printArrayList(true,false,false);
                    break;
                case 2: // List all children on waitlist
                    jdbcWriter.printArrayList(false,true,false);
                    break;
                case 3: // list all parents
                    jdbcWriter.printArrayList(false,false,true);
                    break;
                case 4: //List all children and parents
                    jdbcWriter.printArrayList(true, true, true);
                    break;
                case 5: //Search for a child
                    jdbcWriter.printArrayList(true, true, false);
                    System.out.println(jdbcWriter.searchForChildOrParent("Søg efter et barn i børnehaven: ",false,3));
                    break;
                case 6://Search for parent
                    jdbcWriter.printArrayList(true, false, true);
                    System.out.println(jdbcWriter.searchForChildOrParent("Søg efter en forældre:", true,0));
                    break;
                case 7://Search for related parents
                    jdbcWriter.printArrayList(true, true, false);
                    jdbcWriter.printChildAndRelParent(jdbcWriter.searchForChildOrParent("Søg på et barn og vis forældre: ", false,3));
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
                case 0: //return to mainmenu
                    run = false;
                    break;
                case 1: //Add child with new parents
                    jdbcWriter.insertDB(child.createChild(false, jdbcWriter.insertDB(parent.createParent())));
                    break;
                case 2: //Add child with existing parents
                    jdbcWriter.insertDB(child.createChild(false));
                    break;
                case 3: //Edit child
                    jdbcWriter.printArrayList(true, false, false);
                    jdbcWriter.updateDB(jdbcWriter.editChild(jdbcWriter.searchForChildOrParent("Søg på det barn du vil redigere",false, 2)));
                    break;
                case 4: //remove child
                    jdbcWriter.printArrayList(true, false, false);
                    jdbcWriter.deleteChild(jdbcWriter.searchForChildOrParent( "Skriv navn/id på det barn der skal slettes",false, 2));
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
                    jdbcWriter.updateDB(jdbcWriter.editParent(jdbcWriter.searchForChildOrParent("Søg på den forældre du vil redigere", true, 0)));
                    break;
                case 3: //delete parent
                    jdbcWriter.printArrayList(false, false, true);
                    jdbcWriter.deleteParent(jdbcWriter.searchForChildOrParent("Skriv navn/id på det barn der skal slettes", true, 0));
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
                "3. Rediger barn på venteliste" ,"4. Slet barn fra venteliste", "0. Gå tilbage til hovedmenu"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt();
            switch (menuChoice) {
                case 0: // Return to mainmenu
                    run = false;
                    break;
                case 1: //Add child to waitlist with new parents
                    jdbcWriter.insertDB(child.createChild(true, jdbcWriter.insertDB(parent.createParent())));
                    break;
                case 2: //Add child to waitlist with existing parents
                    jdbcWriter.insertDB(child.createChild(true));
                    break;
                case 3: //Edit child on waitlist
                    jdbcWriter.printArrayList(false, true, false);
                    jdbcWriter.updateDB(jdbcWriter.editChild(jdbcWriter.searchForChildOrParent("Søg på det barn du vil redigere",false, 1)));
                    break;
                case 4: //Delete child from waitlist
                    jdbcWriter.printArrayList(false, true, false);
                    jdbcWriter.deleteChild(jdbcWriter.searchForChildOrParent( "Skriv navn/id på det barn der skal slettes",false, 1));
                    break;
                default:
                    System.out.println("");
            }
        }
    }
}