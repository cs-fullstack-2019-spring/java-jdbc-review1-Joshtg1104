package com.codecrew;

import java.*;
import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private final static String url = "jdbc:postgresql://localhost:5432/java-jdbc-review1";
    private final static String user = "student";
    private final static String password = "C0d3Cr3w";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
//            gData(conn);
//            gRecord(conn);
            sportsRecorder(conn);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void gData(Connection conn){
        System.out.print("Welcome to CodeCrew Sports Network");
        try {
             String SQL = "SELECT * FROM goal";
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL);
             while (rs.next()){
             System.out.print(rs.getString(3)+"\n");
         }
         }
         catch (SQLException e) {
            System.out.print(e.getMessage());
         }
    }

    public static void sportsRecorder(Connection conn){
        Scanner record = new Scanner(System.in);
//        String listing = gRecord();
        System.out.print("Welcome to CodeCrew Sports Network"+"\n");
        System.out.print("Pick an option below:\n");
        System.out.print("1. List match results\n" +
                "2. Add a goal to the database\n");
        Integer input = record.nextInt();
        if(input == 1){
            gRecord(conn);
            return;
        }
        else if(input == 2){
            System.out.print("Not set up yet");
            return;
        }
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery();

    }

    public static void gRecord(Connection conn){

        try{
            String list ="SELECT * FROM goal LEFT JOIN game ON goal.matchid = game.id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(list);
            while(rs.next()){
                System.out.print(rs.getString(7)+", ");
                System.out.print(rs.getString(6)+", ");
                System.out.print(rs.getString(8)+", ");
                System.out.print(rs.getString(9)+", ");
                System.out.print(rs.getString(3)+", ");
                System.out.print(rs.getString(4)+"\n");
            }
        }
        catch (SQLException e){
            System.out.print(e.getMessage());
        }
    }

    public static void main(String[] args) {

        connect();
    }
}

//    Create a interface for the data above to be repeatable and persistant.
//
//        Make the following options avaiable when the program starts up:
//
//        Welcome to CodeCrew Sports Network. Pick an option below:
//        1. List match results
//        2. Add a goal to the database
//        Challenge:
//
//        Get all the stats for a match with goals being added dynamically.
//        Add the match to the database as well.

//Examples:
//    public static void matchResults(int matchIDNumber, String teamOne , String teamTwo)
//   {
//       int team1Score = 0;
//       int team2Score = 0;
//       String SQL ="select matchid, teamid  from goal where matchid = ?";
//       try
//       {
//           Connection conn = connect();
//           PreparedStatement pstmt = conn.prepareStatement(SQL) ;
//           pstmt.setInt(1,matchIDNumber);
//           ResultSet rs = pstmt.executeQuery();
//           while (rs.next())
//           {
////                System.out.print(rs.getString(1) + "\t");
////                System.out.println(rs.getString(2));
//               if(rs.getString(2).equalsIgnoreCase(teamOne))
//               {
//                   team1Score++;
//               }
//               else
//                   {
//                       team2Score++;
//                   }
//           }
//       }
//       catch (SQLException ex)
//       {
//           System.out.println(ex.getMessage());
//       }
//       System.out.print(teamOne+"\t");
//       System.out.print(team1Score+"\t");
//       System.out.print(teamTwo+"\t");
//       System.out.println(team2Score);
//   }