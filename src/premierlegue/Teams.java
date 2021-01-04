package premierlegue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Teams {
	
	
	public static void main(String[] args) {
		
		Teams t =  new Teams();
		t.create_data();
		
	}
	
	
	public void create_data() {

		Db_connection db_conn = new Db_connection();
		Connection connection = db_conn.Start_connection();
		
		
		
		//PreparedStatement pa=null;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Please name:");
		String catName = s.nextLine();
	
		System.out.println("Please goals:");
		String g = s.nextLine();
		

		//Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			
			String sql="insert into test(name, goals) values(?,?)";
		    stmt = connection.prepareStatement(sql);
		    stmt.setString(1, catName);
		    stmt.setString(2, g);
		    System.out.println("data inserted");
		    stmt.executeUpdate();
			
	
			
		} catch (SQLException se){
		    System.out.println(se.getMessage());
		} 
	}

}
