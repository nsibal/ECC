package src;
import java.sql.*;
public class frmConnection {
	
	public Connection con=null;
	
	public frmConnection() {
	
	}
	public Connection getCon() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ECC", "root", "");
		return con;
	}
	
	public void closeCon() {
		
		try {
			con.close();
		}
		
		catch(Exception ex){
        
		}	
	}
}
