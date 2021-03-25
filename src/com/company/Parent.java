package com.company;

public class Parent {

    //Instances
    UserInput userInput = new UserInput();
    //Attributes
    private int idparent;
    private String firstNameParent;
    private String lastNameParent;
    private String streetName;
    private int phoneNumber;
    private String zipcode;
    private String city;

    //Constructors
    Parent() {}

    Parent(int idparent, String firstNameParent, String lastNameParent, int phoneNumber, String streetName, String zipcode, String city) {
        this.idparent = idparent;
        this.firstNameParent = firstNameParent;
        this.lastNameParent = lastNameParent;
        this.phoneNumber = phoneNumber;
        this.streetName = streetName;
        this.zipcode = zipcode;
        this.city = city;
    }

    //Getters & Setters
    public int getIdParent() {return idparent;}

    public void setIdParent(int idparent) {this.idparent = idparent;}


    public String getFirstNameParent() {return firstNameParent;}

    public void setFirstNameParent(String firstNameParent) {this.firstNameParent = firstNameParent; }


    public String getLastNameParent() {return lastNameParent; }

    public void setLastNameParent(String lastNameParent) {this.lastNameParent = lastNameParent;}


    public int getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(int phoneNumber) {this.phoneNumber = phoneNumber;}


    public String getStreetName() {return streetName;}

    public void setStreetName(String streetName) {this.streetName = streetName;}


    public String getZipcode() {return zipcode;}

    public void setZipcode(String zipcode) {this.zipcode = zipcode;}


    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}


    //Method for creating Parent Object.
    public Parent createParent() {
        int idparent = getIdParent();
        String firstName = userInput.inputString("Indtast forældres fornavn: ", true);
        String lastName = userInput.inputString("Indtast forældres efternavn: ", true);
        int phoneNumber = userInput.inputInt("Indtast forældres telefon nummer: ");
        String streetName = userInput.inputString("Indtast forældres vejnavn + nr.: ", false);
        String zipcode = userInput.inputString("Indtast postnummer: ", false);
        String city = userInput.inputString("Indtast by: ", true);
        return new Parent(idparent, firstName, lastName, phoneNumber, streetName, zipcode, city);
    }


    @Override
    public String toString() {
        return "\n\nForældre #" + idparent +
                " Navn: " + firstNameParent + " " + lastNameParent +
                " Telefon Nr: " + phoneNumber +
                "\nAddresse: Gade/vejnavn: " + streetName +
                " Post Nr: " + zipcode +
                " By: " + city;
    }

}
