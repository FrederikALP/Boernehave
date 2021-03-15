package com.company;

public class MenuSwitches {

    //@author ludvig+frederik
    void loginMenu() throws Exception {
        FileEditing fileEditing = new FileEditing();


        //editUserLogin.newUser("Formand","1","Kurt",1);
        //editUserLogin.newUser("Coach","2","Hurtigere Kurt",2);
        //editUserLogin.newUser("Kasser","3","Dame Kurt",3);
        //editUserLogin.newUser("Kurt","4","admin",4);
        //editUserLogin.newUser("luk","luk","luk",9);

        boolean run = true;
        int menuChoice;
        System.out.println("Skriv \"luk\" for at lukke programmet");
        String userNameText = "Venligst indtast dit Username: ";
        String passwordText = "Venligst indtast dit Password: ";

        while (run){
            String userName = UserInput.inputString(userNameText, false);
            String password = UserInput.inputString(passwordText, false);
            menuChoice = (fileEditing.getUserStatusFromFile(userName,password));
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
        FileEditing fileEditing = new FileEditing();
        EditMembership editMembership = new EditMembership();

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
            menuChoice = UserInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: // End program
                    run = false;
                    break;
                case 1: // New membership
                    editMembership.newMembership();
                    break;
                case 2: // Edit membership
                    Member member2 = fileEditing.findSpecificMemberAndConvert
                            (UserInput.inputString("Skriv navn eller nummer på personen du vil finde",false));
                    editMembership.editMembership(member2);
                    System.out.println(member2.toString());
                    break;
                case 3: // Delete member
                    editMembership.removeMemberFromSystem("Members",UserInput.inputString("Skriv IDNummer som skal slettes: ",false));
                    break;
                case 4: // Display total revenue and members with debt.
                    CurrentSubscriptions.showTotalRevenue();
                    break;
                case 5: // Display members with arrears.
                    CurrentSubscriptions.showMembersWithDebt();
                    break;
                default:
                    System.out.println("");
            }
        }
    }

    //@author ludvig+frederik
    void coachMenu() throws Exception {
        //instances
        FileEditing fileEditing = new FileEditing();
        SwimTimesAndStats swimTimesAndStats = new SwimTimesAndStats();

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
            menuChoice = UserInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: //End program
                    run = false;
                    break;
                case 1: //Add new time
                    Member member5 = fileEditing.findSpecificMemberAndConvert
                            (UserInput.inputString("Skriv navn eller nummer på personen du vil finde",false));
                    swimTimesAndStats.addSwimTimeToFile(member5);
                    break;
                case 2: //Show top 5 swimmmers in disciplines
                    swimTimesAndStats.displayTop5();
                    break;
                case 3: //Show member with best times
                    Member member8 = fileEditing.findSpecificMemberAndConvert
                            (UserInput.inputString("Skriv navn eller nummer på personen du vil finde",false));
                    member8.toStringWithTimes();
                    break;
                case 4: //Delete time from member
                    Member member6 = fileEditing.findSpecificMemberAndConvert
                            (UserInput.inputString("Skriv navn eller nummer på personen du vil finde",false));
                    swimTimesAndStats.deleteMembersTime(member6); // Opens new switch with disciplines.
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
            menuChoice = UserInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: //End program
                    run = false;
                    break;
                case 1: //shows total revenue
                    CurrentSubscriptions.showTotalRevenue();
                    break;
                case 2: //shows member-ARREARS
                    CurrentSubscriptions.showMembersWithDebt();
                    break;
                default:
                    System.out.println("");
            }
        }
    }

    //@author ludvig+frederik test push pls commit
    void adminMenu() throws Exception {

        //Instances
        FileEditing fileEditing = new FileEditing();
        EditMembership editMembership = new EditMembership();
        SwimTimesAndStats swimTimesAndStats = new SwimTimesAndStats();
        EditUserLogin editUserLogin = new EditUserLogin();

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
            menuChoice = UserInput.inputInt(leadtext);
            switch (menuChoice) {
                case 0: //End program
                    run = false;
                    break;
                case 1: //New membership
                    editMembership.newMembership();
                    break;
                case 2: //Edit membership
                    Member member2 = fileEditing.findSpecificMemberAndConvert
                            (UserInput.inputString("Skriv navn eller nummer på personen du vil finde",false));
                    editMembership.editMembership(member2);
                    System.out.println(member2.toString());

                    break;
                case 3: //Display total revenue and members with debt.
                    CurrentSubscriptions.showTotalRevenue();
                    CurrentSubscriptions.showMembersWithDebt();
                    break;
                case 4: //Display top 5 Switch
                    swimTimesAndStats.displayTop5();
                    break;
                case 5: //Display all members
                    for (String i : fileEditing.dataToArrayList("Members"))
                        System.out.println("\n"+i);
                    break;
                case 6: //Menu til at tilføje rekordtider til disciplin
                    Member member6 = fileEditing.findSpecificMemberAndConvert
                            (UserInput.inputString("\nSkriv navn eller nummer på personen du vil finde",false));
                    swimTimesAndStats.addSwimTimeToFile(member6);
                    break;
                case 7: //Delete time from member
                    Member member7 = fileEditing.findSpecificMemberAndConvert
                            (UserInput.inputString("Skriv navn eller nummer på personen du vil finde",false));
                    swimTimesAndStats.deleteMembersTime(member7); // Opens new switch with disciplines.
                    break;
                case 8: // Delete member
                    editMembership.removeMemberFromSystem("Members",UserInput.inputString("Skriv IDNummer som skal slettes: ",false));
                    break;
                case 9:
                    editUserLogin.newUser();
                default:
                    System.out.println("");
            }

        }
    }
}