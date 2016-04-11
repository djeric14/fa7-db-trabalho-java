package br.fa7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.fa7.model.Medico;
import br.fa7.model.Model;

public class MedicoDao extends BaseDao {
	
	private PreparedStatement stmt;
	private Connection connection;

	public MedicoDao(String database) {
		super(database);
		connection = getConnection();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void insert(Model model){
		Medico medico = (Medico) model;
		try {
			String sql = "insert into medico(id_medico, nome, sobrenome, id_especialidade) values (?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, medico.getId());
			stmt.setString(2, medico.getNome());
			stmt.setString(3, medico.getSobrenome());
			stmt.setLong(4, medico.getIdEspecialidade());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			close();
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Model model) {
		Medico medico = (Medico) model;
		try {
			String sql = "update medico set nome = ?, sobrenome = ?, id_especialidade = ? "+""
					+ " where id_medico = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, medico.getNome());
			stmt.setString(2, medico.getSobrenome());
			stmt.setLong(3, medico.getIdEspecialidade());
			stmt.setLong(4, medico.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			close();
			e.printStackTrace();
		}
	}
	
	public void delete(){
		try {
			String sql = "delete from medico";
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
