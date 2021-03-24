package com.company;

import java.sql.*;
import java.util.ArrayList;

public class JDBCWriter {

    private static Connection connection = null;
    ArrayList<Object> arrayList = new ArrayList<>();
    UserInput userInput = new UserInput();
    final String PARENT_IDENTIFIER = "Forældre #";
    final String CHILD_IDENTIFIER = "Barn #";
    final String ACTIVE_CHILD_IDENTIFIER = "Venteliste: false";
    final String WAITLIST_CHILD_IDENTIFIER = "Venteliste: true";


    public boolean setConnection(String username, String password) {
        final String url = "jdbc:mysql://127.0.0.1:3306/roskildeboernehave?serverTimezone=UTC";
        boolean conStatus = false;

        try {
            connection = DriverManager.getConnection(url, username, password);
            conStatus = true;
            if (conStatus) {
                System.out.println("Connection status: " + conStatus);
            }
        } catch (SQLException error) {
            System.out.println("\nNo connection made");
        }
        return conStatus;
    }

    //Tager hele databasen og laver om til først Child objects og derefter Parent objects i den samme ArrayList.
    public void addDBToArrayList() throws SQLException {
        Statement s = connection.createStatement();

        ResultSet rsChild = s.executeQuery("SELECT * from childs"); //Henter data fra childs database
        if (rsChild != null)
            while(rsChild.next()) { //Laver parent data om til object -> Tilføjer object til arrayList -> repeat igennem al data
                arrayList.add(new Child(rsChild.getInt("idchild"), rsChild.getString("firstname"),
                        rsChild.getString("lastname"), rsChild.getInt("age"),
                        rsChild.getBoolean("waitlist"), rsChild.getInt("idparent")));
            }

        ResultSet rsParent = s.executeQuery("SELECT * from parents"); //Henter data fra parents database
        if (rsParent != null)
            while(rsParent.next()) { //Laver child data om til object -> Tilføjer object til arrayList -> repeat igennem al data
                arrayList.add(new Parent(rsParent.getInt("idparent"), rsParent.getString("firstname"),
                        rsParent.getString("lastname"), rsParent.getInt("phonenumber"),
                        rsParent.getString("streetname"), rsParent.getString("zipcode"), rsParent.getString("city")));
            }
    }


    //Prints Childs and/or Parent through 2 loops.
    public void printArrayList(boolean printActiveChild, boolean printWaitlistChild, boolean printParent) {
        Child child = new Child();
        if (printActiveChild) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).toString().contains(CHILD_IDENTIFIER) && arrayList.get(i).toString().contains(ACTIVE_CHILD_IDENTIFIER)) {
                    System.out.print(arrayList.get(i));
                }
            }
        }
        if (printWaitlistChild) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).toString().contains(CHILD_IDENTIFIER) && arrayList.get(i).toString().contains(WAITLIST_CHILD_IDENTIFIER)) {
                    System.out.print(arrayList.get(i));
                }
            }
        }
        if (printParent) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).toString().contains(PARENT_IDENTIFIER)) {
                    System.out.print(arrayList.get(i));
                }
            }
        }
    }

    //Et insert SQLString der insereter et nyt Child object i databasen.
    public void insertChild(Child child) throws SQLException {

        String insStr = "INSERT INTO childs(firstname, lastname, age, waitlist, idparent) VALUES('" +
                child.getFirstNameChild() + "','" +
                child.getLastNameChild() + "','" +
                child.getAgeChild() + "'," +
                child.getOnWaitList() + "," +
                child.getIdParentChild() + ")";
        Statement s = connection.createStatement();
        s.execute(insStr);

        String selectID = "Select idchild from childs where firstname = '" + child.getFirstNameChild() + "' and lastname = '"+ child.getLastNameChild() +"';";
        ResultSet rs = s.executeQuery(selectID);
        rs.next();
        child.setIdChild(rs.getInt("idchild"));

        arrayList.add(child);
        System.out.println(child.toString());
    }

    //Et insert SQLString der insereter et Parent object i databasen.
    public void insertParent(Parent parent) throws SQLException {

        String insStr = "INSERT INTO parents(firstname, lastname, phonenumber, streetname, zipcode, city) VALUES('" +
                parent.getFirstNameParent() + "','" +
                parent.getLastNameParent() + "','" +
                parent.getPhoneNumber() + "','" +
                parent.getStreetName() + "','" +
                parent.getZipcode() + "','" +
                parent.getCity() + "')";
        Statement s = connection.createStatement();
        s.execute(insStr);

        String selectID = "Select idparent from parents where firstname = '" + parent.getFirstNameParent() + "' and lastname = '"+ parent.getLastNameParent() +"';";
        ResultSet rs = s.executeQuery(selectID);
        rs.next();
        parent.setIdParent(rs.getInt("idparent"));

        arrayList.add(parent);
        System.out.println(parent.toString());
    }
    //En SQLString der opdaterer databasen baseret på et Child object.
    public void updateChild(Child child) throws SQLException {

        String insStr = "UPDATE childs set firstname = '" + child.getFirstNameChild() +
                "', lastname ='" + child.getLastNameChild() +
                "', age ='" + child.getAgeChild() +
                "', waitlist =" + child.getOnWaitList() +
                ", idparent ='" + child.getIdParentChild() +
                "' where idchild = " + child.getIdParentChild();
        Statement s = connection.createStatement();
        s.execute(insStr);

        arrayList.add(child);
    }

    public void updateParent(Parent parent) throws SQLException {

        String insStr = "UPDATE parents set firstname = '" + parent.getFirstNameParent() +
                "', lastname ='" + parent.getLastNameParent() +
                "', phonenumber ='" + parent.getPhoneNumber() +
                "', streetname ='" + parent.getStreetName() +
                "', zipcode ='" + parent.getZipcode() +
                "', city ='" + parent.getCity() +
                "' where idparent = " + parent.getIdParent();
        Statement s = connection.createStatement();
        s.execute(insStr);
        arrayList.add(parent);
    }


    public void deleteChild (Object object) throws SQLException {
        Child child = (Child) object;
        String delStr = "DELETE FROM childs where idchild = " + child.getIdChild();
        Statement s = connection.createStatement();
        s.execute(delStr);
        arrayList.remove(object);
    }

    //Method that searches/compares through objects in a list and returns 1 object based on match.
    Object searchForChildOrParent(String message, boolean parentTrueChildFalse, boolean childOnWaitlist) {
        String name = userInput.inputString(message, true);
        ArrayList<Object> personFound = new ArrayList<>();

        String waitlistID = "";
        //Alt efter parameteren vælger man om metoden skal søge efter kun børn eller kun voksne.
        String parentOrChild;
        if (parentTrueChildFalse)
            parentOrChild = PARENT_IDENTIFIER;
        else {
            parentOrChild = CHILD_IDENTIFIER;
            if (childOnWaitlist)
                waitlistID = WAITLIST_CHILD_IDENTIFIER;
            else
                waitlistID = ACTIVE_CHILD_IDENTIFIER;
        }

        //Loop through all objects from the main ArrayList and copies matching objects into the personFound-arraylist.
        for (int i = 0; i<arrayList.size(); i++) {
            if (arrayList.get(i).toString().contains(parentOrChild) && (arrayList.get(i).toString().contains(waitlistID))) {
                if (arrayList.get(i).toString().contains(name)) {
                    personFound.add(arrayList.get(i));
                }
            }
        }
        //if '1' matching searchhit it Returns arrayindex 0
        if (personFound.size() ==1){
            return personFound.get(0);

        //if '1+' matching searchhits it returns a user-selected index
        } else if (personFound.size()>1){
            for (int index = 0; index < personFound.size(); index++)
                System.out.println((index + 1) + ".\n" + personFound.get(index).toString()); //Displays index numbers+1
            int chosenIndex = userInput.inputInt(1,personFound.size(),"Skriv index nummer for den person du vil vælge:")-1;
            return personFound.get(chosenIndex);

        //if '0' matching searchits it runs the method through again
        } else {
            System.out.println("Der kunne ikke findes nogen med søgningen: " + name + ". Prøv igen!" );
            return searchForChildOrParent(message, parentTrueChildFalse, childOnWaitlist);
        }
    }

    public Child editChild(Object object) {
        Child child = (Child) object;
        arrayList.remove(object);

        boolean run = true;
        int menuChoice;

        while (run){
            menuChoice = (userInput.inputInt(child.toString() + "\n1. Ændre fornavn\n2. Ændre efternavn\n" +
                    "3. Ændre alder\n4. Ændre ventelistestatus\n5. Ændre forældreID\n0. Gem ændringerne"));
            switch (menuChoice){
                case 1:
                    child.setFirstNameChild(userInput.inputString("Indtast barnets fornavnet: ",true));
                    break;
                case 2:
                    child.setLastNameChild(userInput.inputString("Indtast barnets efternavnet: ",true));
                    break;
                case 3:
                    child.setAgeChild(userInput.inputInt("Indtast barnets alder:"));
                    break;
                case 4:
                    child.setOnWaitList(userInput.inputBoolean("Indtast 'true' for at tilføje barn til venteliste eller 'false' for at fjerne barn fra venteliste"));
                    break;
                case 5:
                    printArrayList(false,false,true);
                    child.setIdParentChild(userInput.inputInt("Skriv et nyt parent ID"));
                    break;
                case 0: //Luk
                    run = false;
                    break;
                default:
            }
        }
        return child;
    }

    public Parent editParent(Object object) {
        Parent parent = (Parent) object;
        arrayList.remove(object);

        boolean run = true;
        int menuChoice;

        while (run){
            menuChoice = (userInput.inputInt(parent.toString() + "\n1. Ændre fornavn\n2. Ændre efternavn\n" +
                    "3. Ændre Tlf nr.\n4. Ændre addresse\n5. Ændre postnr.\n 6. Ændre By" +
                    "\n0. Gem alle ændringerne"));
            switch (menuChoice){
                case 1:
                    parent.setFirstNameParent(userInput.inputString("Indtast forældres fornavnet: ",true));
                    break;
                case 2:
                    parent.setLastNameParent(userInput.inputString("Indtast forældres efternavnet: ",true));
                    break;
                case 3:
                    parent.setPhoneNumber(userInput.inputInt("Indtast forældres tlf nr:"));
                    break;
                case 4:
                    parent.setStreetName(userInput.inputString("Indtast forældres vejnavn + nr.: ",false));
                    break;
                case 5:
                    parent.setZipcode(userInput.inputString("Indtast postnummer: ", false));
                    break;
                case 6:
                    parent.setCity(userInput.inputString("Indtast by: ", true));
                    break;
                case 0: //Luk
                    run = false;
                    break;
                default:
            }
        }
        System.out.println(parent.toString());
        return parent;
    }
}

