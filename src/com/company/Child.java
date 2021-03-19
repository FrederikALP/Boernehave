package com.company;

public class Child {


    private String firstNameChild;
    private String lastNameChild;
    private int ageChild;

    Child() {}

    Child(String firstNameChild, String lastNamechild, int ageChild){
        this.firstNameChild = firstNameChild;
        this.lastNameChild = lastNamechild;
        this.ageChild = ageChild;
    }

    public String getFirstNameChild() {return firstNameChild;}

    public String getLastNameChild() {return lastNameChild;}

    public int getAgeChild() {return ageChild;}

    public void setFirstNameChild(String newFirstNameChild) {this.lastNameChild = newFirstNameChild;}

    public void setLastNameChild(String newLastNameChild) {this.lastNameChild = newLastNameChild;}

    public void setAgeChild(int newAgeChild) {this.ageChild = newAgeChild;}

    @Override
    public String toString() {
        return "Child{" + "firstNameChild='" + firstNameChild + '\'' + ", lastNameChild='" + lastNameChild + '\'' + ", ageChild=" + ageChild + '}';
    }
}
