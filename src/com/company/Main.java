package com.company;

public class Main {


    void run() {
        //Instances
        JDBCWriter jdbcWriter = new JDBCWriter();
        jdbcWriter.setConnection("gustav","0108");
        Parent parent = new Parent();
        Child child = new Child();

        //Method Calls
        System.out.println(child.createChild(true).toString());
        System.out.println(parent.createParent().toString());
    }


    public static void main(String[] args) {
        new Main().run();
    }
}
