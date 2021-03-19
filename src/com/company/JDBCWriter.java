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

        String delStr = "DELETE FROM players WHERE child_id = ?";
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

    public Player getPlayerFromDbById(int player_id){

        String selectStr = "SELECT * FROM players where player_id = ?";
        PreparedStatement preparedStatement;
        Player player = new Player();

        try {
            preparedStatement = connection.prepareStatement(selectStr);
            preparedStatement.setInt(1,player_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            //vi bruger executeQuery

            while (resultSet.next()){
                int playerid =resultSet.getInt("player_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                int team = resultSet.getInt("team");

                player.setFirstname(first_name);
                player.setLastname(last_name);
                player.setAge(age);
                player.setTeam(team);

                // LAV MIG player.setPlayer_ID(playerid);
            }

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Fejl i getPlayerFromDbById");
        }

        return player;
    }

    // FIX DEN HER LALALALA
    public LinkedList returnAllPlayers(){
        //void skal ændres til LISTTYPE
        //LAV LINKED LIST OG RETURN DEN!
        LinkedList linkedList = new LinkedList();
        PreparedStatement preparedStatement;
        String selectStr = "SELECT * FROM players";

        try{

            preparedStatement = connection.prepareStatement(selectStr);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                Player player = new Player();
                int playerid =resultSet.getInt("playerid");
                String first_name = resultSet.getString("firstname");
                String last_name = resultSet.getString("lastname");
                int age = resultSet.getInt("age");
                int team = resultSet.getInt("team");

                player.setFirstname(first_name);
                player.setLastname(last_name);
                player.setAge(age);
                player.setTeam(team);
                player.setPlayerid(playerid);
                linkedList.insertAtEnd(player);
            }


        } catch (SQLException e){
            e.printStackTrace();
        }
        return linkedList;
    }
    public int deletePlayer(int playerid){
        String delQuery = "DELETE from players where playerid = ?";
        PreparedStatement preparedStatement;
        int result = -1;

        try {
            preparedStatement = connection.prepareStatement(delQuery);
            preparedStatement.setInt(1,playerid);
            result = preparedStatement.executeUpdate();
        } catch(SQLException err) {
            err.printStackTrace();
        }
        return result;
    }


    public int updatePlayer(int player_id, Player player){

        return 1;}

}
