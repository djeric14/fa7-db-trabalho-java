package br.fa7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.fa7.model.Model;

public class QueryDao extends BaseDao{

	private PreparedStatement stmt;
	private Connection connection;
	
	public QueryDao(String database) {
		// TODO Auto-generated constructor stub
		super(database);
		connection = getConnection();
	}

	public void query1() {
		try {
			String query = "select * from especialidade";
			
			if(connection == null)
				System.out.println("null");
			
			stmt = connection.prepareStatement(query);
			stmt.executeQuery();
		
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fechar();
			e.printStackTrace();
		}
	}

	public void query2() {
		try {
			String query = "select * from especialidade where id_especialidade = 1000";
			stmt = connection.prepareStatement(query);
			stmt.executeQuery();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fechar();
			e.printStackTrace();
		}
	}

	public void query3() {
		try {
			String query = "select * from especialidade where nome like 'Cardiologia'";
					
			stmt = connection.prepareStatement(query);
			stmt.executeQuery();
			stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fechar();
			e.printStackTrace();
		}
	}

	public void query4() {
		try {
			String query = "select * from medico a left join especialidade b on a.id_especialidade = b.id_especialidade";
			stmt = connection.prepareStatement(query);
			stmt.executeQuery();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fechar();
			e.printStackTrace();
		}
	}
	
	public void query5() {
		try {
			String query = "select * from medico a inner join especialidade b on a.id_especialidade = b.id_especialidade "
					+ " where a.id_medico = 50000";
			stmt = connection.prepareStatement(query);
			stmt.executeQuery();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fechar();
			e.printStackTrace();
		}
	}
	
	public void query6() {
		try {
			String query = "select * from medico a inner join especialidade b on a.id_especialidade = b.id_especialidade "
					+ "where a.nome like '%Ma%'";
			stmt = connection.prepareStatement(query);
			stmt.executeQuery();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fechar();
			e.printStackTrace();
		}
	}
	
	public void query7() {
		try {
			String query = "select count(*) from especialidade";
			stmt = connection.prepareStatement(query);
			stmt.executeQuery();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fechar();
			e.printStackTrace();
		}
	}
	
	public void query8() {
		try {
			String query = "select count(a.id_medico) from medico a inner join especialidade b "
					+ "on a.id_especialidade = b.id_especialidade";
			stmt = connection.prepareStatement(query);
			stmt.executeQuery();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fechar();
			e.printStackTrace();
		}
	}
	
	public void query9() {
		try {
			String query = "select nome, count(*) from especialidade group by nome";
			stmt = connection.prepareStatement(query);
			stmt.executeQuery();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fechar();
			e.printStackTrace();
		}
	}
	
	public void query10() {
		try {
			String query = "select * from especialidade where id_especialidade < 1000";
			stmt = connection.prepareStatement(query);
			stmt.executeQuery();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fechar();
			e.printStackTrace();
		}
	}
	
	public void fechar() {
		try {
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
