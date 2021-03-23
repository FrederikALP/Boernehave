package com.company;

import java.sql.SQLException;

public class Main {


    void run() throws SQLException {
        //Instances
        JDBCWriter jdbcWriter = new JDBCWriter();
        jdbcWriter.setConnection("Hanne","Hanne");
        Parent parent = new Parent();
        Child child = new Child();
        jdbcWriter.insertChild(child.createChild(false));
        jdbcWriter.addDBToArrayList();


        //Method Calls
        //System.out.println(child.createChild(true).toString());
        //System.out.println(parent.createParent().toString());
    }


    public static void main(String[] args) throws SQLException {
        new Main().run();
    }
}
