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
    public int getIdParent() {return idparent;}

    public void setIdParent(int idparent) {this.idparent = idparent;}


    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName; }


    public String getLastName() {return lastName; }

    public void setLastName(String lastName) {this.lastName = lastName;}


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
                " Navn: " + firstName + " " + lastName +
                " Telefon Nr: " + phoneNumber +
                "\nAddresse: Gade/vejnavn: " + streetName +
                " Post Nr: " + zipcode +
                " By: " + city;
    }

}
