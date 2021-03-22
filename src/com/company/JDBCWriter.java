package com.company;

import java.sql.*;

public class JDBCWriter {

    private static Connection connection = null;

    public boolean setConnection(String username, String password) {

        final String url = "jdbc:mysql://127.0.0.1:3306/??????????????serverTimezone=UTC";
        boolean bres = false;

        try {
            connection = DriverManager.getConnection(url, username, password);
            bres = true;
            if (bres) {
                System.out.println("Connection status: " + bres);
            }
        } catch (SQLException error) {
            System.out.println("\nNo connection made");
        }
        return bres;
    }

    public int deleteMember(int id){

        String delStr = "DELETE FROM childs WHERE child_id = ?";
        PreparedStatement preparedStatement;
        int result = -1;

        try{
            preparedStatement = connection.prepareStatement(delStr);
            preparedStatement.setInt(1,id); //Kig i første kolunne og brug parameter til at vælge
            result = preparedStatement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fejl i deleteMember");
        }
        return result;
    }

    //vi sender et player objekt til metoden, og den indsætter den.
    /* mangler at rettes til så det passer med child
    public int insertPlayer(Child Child){

        String insStr = "INSERT INTO childs(first_name,last_name,age,team) VALUES ('" +
                child.getFirstname() + "','" +
                child.getLastname() + "'," +
                child.getAge() + "," +
                child.getTeam() + ")";
        PreparedStatement preparedStatement;

        int result = -1;

        try{
            preparedStatement = connection.prepareStatement(insStr);
            int rowcount = preparedStatement.executeUpdate();
            result = rowcount;

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("SQL fejl i insertPlayer");
        }

        System.out.println("Successfully inserted a player");
        return result;
    }
   */

  /*
  public Child getChildFromDbById(int child_id){

        String selectStr = "SELECT * FROM childs where child_id = ?";
        PreparedStatement preparedStatement;
        Child child = new Child();

        try {
            preparedStatement = connection.prepareStatement(selectStr);
            preparedStatement.setInt(1,child_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            //vi bruger executeQuery

            while (resultSet.next()){
                int childid =resultSet.getInt("player_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                int team = resultSet.getInt("team");

                child.setFirstname(first_name);
                child.setLastname(last_name);
                child.setAge(age);
                child.setTeam(team);

                // LAV MIG player.setPlayer_ID(playerid);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Fejl i getPlayerFromDbById");
        }

        return child;
    }

   */

    public int deleteChild(int childid){
        String delQuery = "DELETE from childs where childid = ?";
        PreparedStatement preparedStatement;
        int result = -1;

        try {
            preparedStatement = connection.prepareStatement(delQuery);
            preparedStatement.setInt(1,childid);
            result = preparedStatement.executeUpdate();
        } catch(SQLException err) {
            err.printStackTrace();
        }
        return result;
    }

}
