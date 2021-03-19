package com.company;

public class Parent extends Child {

    //Instances
    UserInput userInput = new UserInput();

    //Attributes
    private String firstName;
    private String lastName;
    private String address;
    private int phoneNumber;

    //Constructors
    Parent() {}

    Parent(String firstName, String lastName, String address, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
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

    //Method for creating Parent Object.
    public Parent createParent() {
        String firstname = userInput.inputString("Input first name", true);
        String lastname = userInput.inputString("Input last name", true);
        String address = userInput.inputString("Input address", true);
        int phoneNumber = userInput.inputInt("Input phonenumber");
        return new Parent(firstname, lastname, address, phoneNumber);
    }


    @Override
    public String toString() {
        return "Player{" + "firstname='" + firstName + '\'' + ", lastname='" + lastName + '\'' + ", address=" + address + ", phone number=" + phoneNumber + '}';
    }
}
