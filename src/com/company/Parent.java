package com.company;

public class Parent extends Child {

    //Instances
    UserInput userInput = new UserInput();
    //Attributes
    private int idparent;
    private String firstName;
    private String lastName;
    private String address;
    private int phoneNumber;
    private int zipcode;
    private String city;


    //Constructors
    Parent() {}

    Parent(int idparent, String firstName, String lastName, int phoneNumber, String address, int zipcode, String city) {
        this.idparent = idparent;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;


    }

    //Getters & Setters
    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName; }


    public String getLastName() {return lastName; }

    public void setLastName(String lastName) {this.lastName = lastName;}


    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}


    public int getZipcode() {return zipcode;}

    public void setZipcode(int zipcode) {this.zipcode = zipcode;}


    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}


    public int getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(int phoneNumber) {this.phoneNumber = phoneNumber;}



    //Method for creating Parent Object.
    public Parent createParent() {
        String firstname = userInput.inputString("Indtast forældres fornavn: ", true);
        String lastname = userInput.inputString("Indtast forældres efternavn: ", true);
        String address = userInput.inputString("Indtast forældres vejnavn + nr.: ", false);
        int zipcode = userInput.inputInt("Indtast postnummer: ");
        String city = userInput.inputString("Indtast by: ", true);
        int phoneNumber = userInput.inputInt("Indtast forældres telefon nummer: ");
        return new Parent(idparent, firstname, lastname, phoneNumber, address, zipcode, city);
    }


    @Override
    public String toString() {
        return"Forældres navn: " + firstName + " " + lastName + ", Gade/vejnavn: " + address + ", Postnummer" + zipcode + ", By: " + city + ", Telefon nummer:" + phoneNumber + '}';
    }
}
