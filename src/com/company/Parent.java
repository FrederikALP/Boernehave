package com.company;

public class Parent extends Child {

    //Instances
    UserInput userInput = new UserInput();

    //Attributes
    private String firstName;
    private String lastName;
    private String address;
    private int phoneNumber;
    private int zipcode;

    //Constructors
    Parent() {}

    Parent(String firstName, String lastName, String address, int zipcode, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;

    }

    //Getters & Setters
    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName; }


    public String getLastName() {return lastName; }

    public void setLastName(String lastName) {this.lastName = lastName;}


    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public int getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(int phoneNumber) {this.phoneNumber = phoneNumber;}

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    //Method for creating Parent Object.
    public Parent createParent() {
        String firstname = userInput.inputString("Skriv forældres fornavn", true);
        String lastname = userInput.inputString("Skriv forældres efternavn", true);
        String address = userInput.inputString("Skriv forældres adresse", false);
        int zipcode = userInput.inputInt("Skriv forældres zipcode");
        int phoneNumber = userInput.inputInt("Skriv forældres telefon nummer");
        return new Parent(firstname, lastname, address, zipcode, phoneNumber);
    }


    @Override
    public String toString() {
        return "Player{" + "firstname='" + firstName + '\'' + ", lastname='" + lastName + '\'' + ", address=" + address + ", zipcode=" + zipcode + ", phone number=" + phoneNumber + '}';
    }
}
