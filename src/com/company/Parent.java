package com.company;

public class Parent extends Child {
    private String firstName;
    private String lastName;
    private String address;
    private int phoneNumber;

    UserInput userInput = new UserInput();

    Parent() {

    }

    Parent(String firstName, String lastName, String address, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Parent createParent() {
        String firstname = userInput.inputString("Input first name", true);
        String lastname = userInput.inputString("Input last name", true);
        String address = userInput.inputString("Input last name", true);
        int phoneNumber = userInput.inputInt("Input phonenumber");
        Parent parent = new Parent(firstname, lastname, address, phoneNumber);
        return parent;

    }
}
