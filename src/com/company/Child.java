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
        String firstName = userInput.inputString("Input first name", true);
        String lastName = userInput.inputString("Input last name", true);
        int age = userInput.inputInt("Input phonenumber");
        return new Child(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Child{" + "firstNameChild='" + firstNameChild + '\'' + ", lastNameChild='" + lastNameChild + '\'' + ", ageChild=" + ageChild + '}';
    }
}
