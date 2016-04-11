package br.fa7.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mongodb.MongoClient;

public class ConnectionBD {

	public ConnectionBD() {
		// TODO Auto-generated constructor stub
	}
	
	public static MongoClient getConnectionMongo() {
		
		return new MongoClient("localhost", 27017);
	}
	
	public static Connection getConnectionOracle(){
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TRABALHO_BD", "1234");
			return conn;
		}
		catch (ClassNotFoundException | SQLException ex){
			ex.printStackTrace();
		}

		return null;
	}
	
	public static Connection getConnectionSQLite(){

		Connection conn = null;
        try {
            String url = "jdbc:sqlite::memory:";
            conn = DriverManager.getConnection(url);    
           
            System.out.println("Connection to SQLite has been established.");
            return conn;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());   
        }    
		return null;
     }	
	
	

}
