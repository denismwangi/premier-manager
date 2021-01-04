package premierlegue;

import java.sql.Connection;
import java.sql.DriverManager;



public class Db_connection {
	
public static void main(String[] args) {
		
		Db_connection db_conn = new Db_connection();
		
		System.out.print(db_conn.Start_connection());
	}
	
	public Connection Start_connection() {
		
		
		
			
			Connection connection= null;
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/premier_leguea", "root","");
						
				
			}catch(Exception e){
					System.out.print(e);
					
				
			}
			return connection;
			
		}

}
