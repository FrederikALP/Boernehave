package com.company;

public class Child {

    //Instances
    UserInput userInput = new UserInput();

    //Attributes
    private String firstNameChild;
    private String lastNameChild;
    private int ageChild;

    //Constructors
    Child() {}

    Child(String firstNameChild, String lastNamechild, int ageChild){
        this.firstNameChild = firstNameChild;
        this.lastNameChild = lastNamechild;
        this.ageChild = ageChild;
    }

    //Getters & Setters
    public String getFirstNameChild() {return firstNameChild;}

    public void setFirstNameChild(String newFirstNameChild) {this.lastNameChild = newFirstNameChild;}


    public String getLastNameChild() {return lastNameChild;}

    public void setLastNameChild(String newLastNameChild) {this.lastNameChild = newLastNameChild;}


    public int getAgeChild() {return ageChild;}

    public void setAgeChild(int newAgeChild) {this.ageChild = newAgeChild;}


    public Child createChild() {
        String firstName = userInput.inputString("Indtast barnets fornavn: ", true);
        String lastName = userInput.inputString("Indtast barnets efternavn: ", true);
        int age = userInput.inputInt("Indtast barnets alder: ");
        return new Child(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Barnets navn: " + firstNameChild + " " + lastNameChild + ", Alder: " + ageChild;
    }
}
