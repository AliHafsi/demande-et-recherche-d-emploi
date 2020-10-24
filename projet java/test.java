package employer;

import java.awt.Component;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class test {

	public static void main(String[] args) {
		graphique fn = new graphique();
		
	
		// TODO Auto-generated method stub
		try {
          
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employers", "root", "");
            Statement stmt = conn.createStatement();
            int rs;
 
           
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
		 
	
	}
		

	}


