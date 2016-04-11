package br.fa7.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.mongodb.MongoClient;

import br.fa7.connection.ConnectionBD;

public abstract class BaseDao implements Dao {

	private static MongoClient mongoClient;
	private static Connection connection;
	private String database;
	private static Boolean isConnection = false;

	public BaseDao(String database) {
		this.database = database;
		
		switch (this.database) {
			case "oracle": 
				if(connection == null){
					connection = ConnectionBD.getConnectionOracle();
				}	
				isConnection = false;
				break;
			case "mongo": 
				if (mongoClient == null)
					mongoClient = ConnectionBD.getConnectionMongo();
				isConnection = false;
				break;
			case "sqlite": {
				if (connection == null){
					connection = ConnectionBD.getConnectionSQLite();
					isConnection = true;
				}	
				break;
			}
			default: 
				System.out.println("Database connection not suported");
		}
	}	
	
	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public Connection getConnection() {
		if(database.equals("sqlite") && isConnection){
			createTables(connection);
		}	
		isConnection = false;
		
		return connection;
	}

	private static void createTables(Connection connection) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("create table especialidade (id_especialidade integer primay key, nome text)");
			stmt.executeUpdate("create table medico (id_medico integer primary key, nome text, sobrenome text,"
					+ " id_especialidade integer references especialidade(id_especialidade))");
			stmt.executeUpdate("create table paciente (id_paciente integer primary key, nome text, sobrenome text,"
					+ "email text)");
			stmt.executeUpdate("create table consulta_medica(id_consulta integer primary key, id_medico integer"
					+ " references medico (id_medico), "
					+ "id_paciente integer references paciente (id_paciente), descricao text, data_consulta text)");
			
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getDatabase() {
		return database;
	}
	
	public void closeConnection(){
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
