package br.fa7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.fa7.controller.Controller;
import br.fa7.model.Especialidade;
import br.fa7.model.Model;

public class EspecialidadeDao extends BaseDao {

	private PreparedStatement stmt;
	private Connection connection;
	private Especialidade especialidade;
	
	public EspecialidadeDao(String database) {
		super(database);
		connection = getConnection();
	}

	public void insert(Model model) {
		especialidade = (Especialidade) model;
		
		String sql = "insert into especialidade(id_especialidade, nome) values (?, ?)";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, especialidade.getId());
			stmt.setString(2, especialidade.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			close();
			e.printStackTrace();
		}

	}

	public void update(Model model) {
		especialidade = (Especialidade) model;
		
		String sql = "update especialidade set nome = ? where id_especialidade = ?";
	
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, especialidade.getNome());
			stmt.setLong(2, especialidade.getId());
			
			if(getDatabase().equals("oracle"))
				stmt.execute();
			else if(getDatabase().equals("sqlite")){
				stmt.addBatch();
				if(especialidade.getId() == Controller.getRegistros())
					stmt.executeBatch();
			}
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			close();
			e.printStackTrace();
		}

	}

	public void delete() {
		String sql = "delete from especialidade";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			close();
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void query1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query5() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query6() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query7() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query8() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query9() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void query10() {
		// TODO Auto-generated method stub
		
	}
}
