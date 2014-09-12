package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnectin {
	
	Connection conn;
	Statement stmt;
	ResultSet res;
	
	public DatabaseConnectin(){
		
	}
	
	public Connection setConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Job_Portal", "root", "root123");
			
		}catch (Exception e){
			
		}
		return conn;
	}
	
	public ResultSet getResult(String sql, Connection conn){
		this.conn = conn;
		try{
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
		}catch (Exception e){
			
		}
		return res;
	}
}
