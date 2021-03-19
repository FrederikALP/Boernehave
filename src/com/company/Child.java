package com.company;

public class Child {

    //Instances
    UserInput userInput = new UserInput();

    //Attributes
    private int idChild;
    private String firstNameChild;
    private String lastNameChild;
    private int ageChild;
    private int siblingNr;
    private boolean onWaitList;

    //Constructors
    Child() {}

    Child(int idChild, String firstNameChild, String lastNamechild, int ageChild, int siblingNr, boolean onWaitlist){
        this.idChild = idChild;
        this.firstNameChild = firstNameChild;
        this.lastNameChild = lastNamechild;
        this.ageChild = ageChild;
        this.siblingNr = siblingNr;
        this.onWaitList = onWaitlist;
    }

    //Getters & Setters
    public int getIdChild() {return idChild;}

    public void setIdChild(int idChild) {this.idChild = idChild;}


    public String getFirstNameChild() {return firstNameChild;}

    public void setFirstNameChild(String newFirstNameChild) {this.lastNameChild = newFirstNameChild;}


    public String getLastNameChild() {return lastNameChild;}

    public void setLastNameChild(String newLastNameChild) {this.lastNameChild = newLastNameChild;}


    public int getAgeChild() {return ageChild;}

    public void setAgeChild(int newAgeChild) {this.ageChild = newAgeChild;}


    public int getSiblingNr() {return siblingNr;}

    public void setSiblingNr(int newSiblingNr) { this.siblingNr = newSiblingNr;}


    public boolean getOnWaitList() {return onWaitList;}

    public void setOnWaitList(boolean newOnWaitList) { this.onWaitList = newOnWaitList;}


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
