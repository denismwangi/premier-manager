package premierlegue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.sql.ResultSet;




abstract class SportsClub {
	
	String name;
	String location;
	int wins;
	int defeats;
	int draws;
	int goals_scored;
	int goals_received;
	int points;
	int matches_played;
	
	void play() {
		System.out.print("play!");
	}
	
	
}
class sports extends SportsClub{}

class FootballClub{
	String name;
	String location;
	int wins;
	int defeats;
	int draws;
	int goals_scored;
	int goals_received;
	int points;
	int matches_played;
	
	

	public FootballClub(String name, String location, int wins, int defeats, int draws, int goals_scored, int goals_received, int points, int matches_played)
	{
	this.name=name;
	this.location = location;
	this.wins = wins;
	this.defeats = defeats;
	this.draws =  draws;
	this.goals_scored = goals_scored;
	this.goals_received = goals_received;
	this.matches_played = matches_played;
	this.points = points;
	
	
	}
	
	
	
	
	
}

interface  LeagueManager{
	
	void addTeam();
	void displayTabe();
	void displyOneTeam();
	void deleteTeam();
	String player = "salah";
	
	void play();
}

public class PremierLegueManager implements LeagueManager {
	
	
   
	//2020-2021 premier legue clubs
	  int footbal_clubs;
	  /*
	  "Arsenal", "Aston Villa", "Burnley", "Chelsea", "Crystal Palace",
	  "Evarton", "Fulham", "Leeds United", "Liverpool","Manchester City", 
	  "Manchester United", "Sheffield United", 
	  "Southampton", "Brighton & Hove Albion",
	  "Tottenham Hotspur", "West Bromwich", "West Ham United",
	  "Wolverhamptom Wanderers"
	  
	  */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
				PremierLegueManager pl  = new PremierLegueManager();
					//	pl.play();
						
				sports sp = new sports();
				//sp.play();
				//pl.addTeam();
				
				
			//	pl.displayTabe();
				
				
				    int swValue;
				    System.out.println("|***********MENU SELECTION**************|");
				    System.out.println("|           Options:                    |");
				    System.out.println("|        1. add team                    |");
				    System.out.println("|        2. delete team                 |");
				    System.out.println("|        3. display premier leguea table|");
				    swValue = Keyin.inInt(" Select option: ");

				    // Switch construct
				    switch (swValue) {
				    case 1:
				      System.out.println("add team");
				      pl.addTeam();
				      break;
				    case 2:
				      System.out.println("select team to delete");
				      pl.deleteTeam();
				      break;
				    case 3:
				      System.out.println("league table");
				      pl.displayTabe();
				      
				      break;
				    case 4:
				    	System.out.println("Exit selected");
				    	break;
				    	
				    default:
				      System.out.println("Invalid selection");
				      break; // This break is not really necessary
				    }
	}
	public void addTeam() {
		// TODO Auto-generated method stub
		
		Db_connection db_conn = new Db_connection();
		Connection connection = db_conn.Start_connection();
		
		
		//PreparedStatement pa=null;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter name:");
		String n = s.nextLine();
	
		System.out.println("Please enter location :");
		String l = s.nextLine();
		
		System.out.println("Please enter no .of wins:");
		String w = s.nextLine();
		
		System.out.println("Please enter no of defeats:");
		String d = s.nextLine();
		
		System.out.println("Please enter no. of draws:");
		String ds = s.nextLine();
		
		System.out.println("Please enter number number of goals scored:");
		String gs = s.nextLine();
		
		System.out.println("Please enter number of goals received:");
		String gr = s.nextLine();
		
		System.out.println("Please enter match played:");
		String mp = s.nextLine();
		
		System.out.println("Please enter points :");
		String pts = s.nextLine();

		//Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			String sql="insert into teams(name, location, wins, defeat, draws, goals_scored, goals_received,matches_played, points_received ) values(?,?,?,?,?,?,?,?,?)";
		    stmt = connection.prepareStatement(sql);
		    stmt.setString(1, n);
		    stmt.setString(2, l);
		    stmt.setString(3, w);
		    stmt.setString(4, d);
		    stmt.setString(5, ds);
		    stmt.setString(6, gs);
		    stmt.setString(7, gr);
		    stmt.setString(8, mp);
		    stmt.setString(9, pts);
		    System.out.println("data inserted");
		    stmt.executeUpdate();

		} catch (SQLException se){
		    System.out.println(se.getMessage());
		}
	}
		
	
	public void displayTabe() {
		Db_connection db_conn = new Db_connection();
		Connection connection = db_conn.Start_connection();
		Statement smt = null;
		try {
			smt = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			//query to display all records from table teams
			String q="Select * from teams";
			
			//to execute query
			ResultSet rs = smt.executeQuery(q);
			
			//to print the resultset on console
			if(rs.next()){ 
				do{
				System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+","+rs.getString(8)+","+rs.getString(9));
				}while(rs.next());
			}
			else{
				System.out.println("Record Not Found...");
			}
			connection.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
		
	public void displyOneTeam() {
		// TODO Auto-generated method stub
		
		
		
	}
	public void play() {
		// TODO Auto-generated method stub
		
	}
	public void deleteTeam() {
		// TODO Auto-generated method stub
		
		Db_connection db_conn = new Db_connection();
		Connection connection = db_conn.Start_connection();
		
		
		//PreparedStatement pa=null;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter team name:");
		String nm = s.nextLine();
		
		PreparedStatement stmt = null;
		try {
			
			//query to delete
			String qdelete ="delete from teams where name = ?";
			stmt = connection.prepareStatement(qdelete);
			stmt.setString(1, nm);
			System.out.println("team deleted");
			// execute the preparedstatement
		    stmt.execute();
			// execute the preparedstatement
		     
		    
		}catch (SQLException se) {
			
			System.out.println(se.getMessage());
		}
		
	}
}
class Keyin {

	  //*******************************
	  //   support methods
	  //*******************************
	  //Method to display the user's prompt string
	  public static void printPrompt(String prompt) {
	    System.out.print(prompt + " ");
	    System.out.flush();
	  }

	  //Method to make sure no data is available in the
	  //input stream
	  public static void inputFlush() {
	    int dummy;
	    int bAvail;

	    try {
	      while ((System.in.available()) != 0)
	        dummy = System.in.read();
	    } catch (java.io.IOException e) {
	      System.out.println("Input error");
	    }
	  }
	  public static String inString() {
	    int aChar;
	    String s = "";
	    boolean finished = false;

	    while (!finished) {
	      try {
	        aChar = System.in.read();
	        if (aChar < 0 || (char) aChar == '\n')
	          finished = true;
	        else if ((char) aChar != '\r')
	          s = s + (char) aChar; // Enter into string
	      }

	      catch (java.io.IOException e) {
	        System.out.println("Input error");
	        finished = true;
	      }
	    }
	    return s;
	  }

	  public static int inInt(String prompt) {
	    while (true) {
	      inputFlush();
	      printPrompt(prompt);
	      try {
	        return Integer.valueOf(inString().trim()).intValue();
	      }

	      catch (NumberFormatException e) {
	        System.out.println("Invalid input. Not an integer");
	      }
	    }
	  }

	}
