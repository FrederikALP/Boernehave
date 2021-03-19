package com.company;

public class MenuSwitches {
    UserInput userInput = new UserInput();

    //@author ludvig+frederik
    void loginMenu() throws Exception {

        boolean run = true;
        int menuChoice;
        System.out.println("Skriv \"luk\" for at lukke programmet");
        String userNameText = "Venligst indtast dit Username: ";
        String passwordText = "Venligst indtast dit Password: ";

        while (run){
            String userName = userInput.inputString(userNameText, false);
            String password = userInput.inputString(passwordText, false);
            menuChoice = (userInput.inputInt("Choose option:"));
            switch (menuChoice){
                case 0: //Error
                    System.out.println("Wrong Username and or Password");
                    break;
                case 1: //Chairman Menu
                    formandMenu();
                    break;
                case 2: //Coach Menu
                    coachMenu();
                    break;
                case 3: //Cashier Menu
                    cashierMenu();
                    break;
                case 4: //Admin Menu
                    adminMenu();
                    break;
                case 9: //Luk
                    run = false;
                    break;
                default:
            }
        }
    }

    //@author ludvig+frederik
    void formandMenu() throws Exception {

        //Instances

        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "Formands valgmuligheder - "+ TimeAndDate.currentDate();
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Tilføj nyt medlem.", "2. Rediger medlem.", "3. Slet medlem.",
                "4. Vis den årlige indkomst fra kontigenter.",
                "5. Vis navn og id på alle som skylder penge.", "0. Log ud af din bruger."};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: // End program
                    run = false;
                    break;
                case 1: // New membership

                    break;
                case 2: // Edit membership

                    break;
                case 3: // Delete member

                    break;
                case 4: // Display total revenue and members with debt.

                    break;
                case 5: // Display members with arrears.
                    break;
                default:
                    System.out.println("");
            }
        }
    }

    //@author ludvig+frederik
    void coachMenu() throws Exception {
        //instances

        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "Træner valgmuligheder - "+ TimeAndDate.currentDate();
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Indtast ny svømmetid", "2. Vis top5 svømmere indenfor alle discipliner",
                "3. Vis medlem med tider",
                "4. Slet tid fra medlem","0. Log ud af din bruger"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: //End program
                    run = false;
                    break;
                case 1: //Add new time

                    break;
                case 2: //Show top 5 swimmmers in disciplines

                    break;
                case 3: //Show member with best times

                    break;
                case 4: //Delete time from member

                    break;
                default:
                    System.out.println("");
            }
        }
    }

    //@author ludvig+frederik
    void cashierMenu() throws Exception {
        boolean run = true;
        int menuChoice;
        String headertext = "Kasser valgmuligheder - " + TimeAndDate.currentDate();
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Vis omsættelse", "2. Vis medlemmer i restance", "0. Log ud af din bruger"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: //End program
                    run = false;
                    break;
                case 1: //shows total revenue

                    break;
                case 2: //shows member-ARREARS

                    break;
                default:
                    System.out.println("");
            }
        }
    }

    //@author ludvig+frederik test push pls commit
    void adminMenu() throws Exception {

        //Instances

        //Menu
        boolean run = true;
        int menuChoice;
        String headertext = "admin valgmuligheder - " + TimeAndDate.currentDate();
        String leadtext = "Indtast en valgmulighed: ";
        String[] menuItems = {"1. Tilføj nyt medlem", "2. Rediger medlem", "3. Vis omsættelse",
                "4. Display top5 ", "5. Vis alle medlemmer",
                "6. Tilføj en tid til medlem", "7. Slet en tid fra medlem","8. Slet et medlem",
                "9. Opret ny bruger","0. For at lukke programmet"};
        while (run) {
            Menu menu = new Menu(headertext, leadtext, menuItems);
            menu.printMenu();
            menuChoice = userInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: //End program
                    run = false;
                    break;
                case 1: //New membership
                    break;
                case 2: //Edit membership

                    break;
                case 3: //Display total revenue and members with debt.

                    break;
                case 4: //Display top 5 Switch

                    break;
                case 5: //Display all members

                    break;
                case 6: //Menu til at tilføje rekordtider til disciplin

                    break;
                case 7: //Delete time from member

                    break;
                case 8: // Delete member

                    break;
                case 9:

                default:
                    System.out.println("");
            }

        }
    }
}