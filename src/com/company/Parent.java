package com.company;

public class Parent extends Child {

    //Instances
    UserInput userInput = new UserInput();
    //Attributes
    private int idparent;
    private String firstName;
    private String lastName;
    private String streetName;
    private int phoneNumber;
    private String zipcode;
    private String city;


    //Constructors
    Parent() {}

    Parent(int idparent, String firstName, String lastName, int phoneNumber, String streetName, String zipcode, String city) {
        this.idparent = idparent;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.streetName = streetName;
        this.zipcode = zipcode;
        this.city = city;


    }

    //Getters & Setters
    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName; }


    public String getLastName() {return lastName; }

    public void setLastName(String lastName) {this.lastName = lastName;}


    public String getStreetName() {return streetName;}

    public void setStreetName(String streetName) {this.streetName = streetName;}


    public String getZipcode() {return zipcode;}

    public void setZipcode(String zipcode) {this.zipcode = zipcode;}


    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}


    public int getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(int phoneNumber) {this.phoneNumber = phoneNumber;}



    //Method for creating Parent Object.
    public Parent createParent() {
        String firstname = userInput.inputString("Indtast forældres fornavn: ", true);
        String lastname = userInput.inputString("Indtast forældres efternavn: ", true);
        String address = userInput.inputString("Indtast forældres vejnavn + nr.: ", false);
        String zipcode = userInput.inputString("Indtast postnummer: ", false);
        String city = userInput.inputString("Indtast by: ", true);
        int phoneNumber = userInput.inputInt("Indtast forældres telefon nummer: ");
        return new Parent(idparent, firstname, lastname, phoneNumber, address, zipcode, city);
    }


    @Override
    public String toString() {
        return "\n" + "Forældres navn: " + firstName + " " + lastName + ", Gade/vejnavn: " + streetName + ", Postnummer"
                + zipcode + ", By: " + city + ", Telefon nummer:" + phoneNumber;
    }
}
