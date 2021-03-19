package com.company;

public class Main {


    void run() {
        //Instances
        Parent parent = new Parent();
        Child child = new Child();

        //Method Calls
        child.createChild().toString();
        parent.createParent().toString();
    }


    public static void main(String[] args) {
        new Main().run();



    }
}
