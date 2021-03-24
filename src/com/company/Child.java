package com.company;

public class Child {

    //Instances
    UserInput userInput = new UserInput();

    //Attributes
    private int idChild;
    private String firstNameChild;
    private String lastNameChild;
    private int ageChild;
    private boolean onWaitList;
    private int idParentChild;

    //Constructors
    Child() {}

    Child(int idChild, String firstNameChild, String lastNameChild, int ageChild, boolean onWaitList, int idParentChild){
        this.idChild = idChild;
        this.firstNameChild = firstNameChild;
        this.lastNameChild = lastNameChild;
        this.ageChild = ageChild;
        this.onWaitList = onWaitList;
        this.idParentChild = idParentChild;
    }

    //Getters & Setters
    public int getIdChild() {return idChild;}

    public void setIdChild(int idChild) {this.idChild = idChild;}


    public String getFirstNameChild() {return firstNameChild;}

    public void setFirstNameChild(String newFirstNameChild) {this.firstNameChild = newFirstNameChild;}


    public String getLastNameChild() {return lastNameChild;}

    public void setLastNameChild(String newLastNameChild) {this.lastNameChild = newLastNameChild;}


    public int getAgeChild() {return ageChild;}

    public void setAgeChild(int newAgeChild) {this.ageChild = newAgeChild;}


    public boolean getOnWaitList() {return onWaitList;}

    public void setOnWaitList(boolean newOnWaitList) { this.onWaitList = newOnWaitList;}


    public int getIdParentChild() {return idParentChild;}

    public void setIdParentChild(int idParentChild) {this.idParentChild = idParentChild;}


    public Child createChild(boolean childOnWaitList) {
        int childId = getIdChild();
        String firstName = userInput.inputString("Indtast barnets fornavn: ", true);
        String lastName = userInput.inputString("Indtast barnets efternavn: ", true);
        int age = userInput.inputInt("Indtast barnets alder: ");
        int parentId = userInput.inputInt("Indtast parent id");
        return new Child(childId, firstName, lastName, age, childOnWaitList, parentId);
    }

    @Override
    public String toString() {
        return  "\n\nBarn #" + idChild +
                " Navn: " + firstNameChild + " " + lastNameChild +
                " Alder: " + ageChild +
                " Venteliste: " + onWaitList +
                " Forældre ID: " + idParentChild;
    }

}
