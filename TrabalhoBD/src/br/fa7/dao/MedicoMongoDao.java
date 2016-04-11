package br.fa7.dao;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import br.fa7.model.Medico;
import br.fa7.model.Model;

public class MedicoMongoDao extends BaseDao{

	private MongoClient mongo;
	private MongoDatabase dbMongo;

	public MedicoMongoDao(String database) {
		super(database);
		mongo = getMongoClient();
		dbMongo = mongo.getDatabase("trabalho_bd");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void insert(Model model) {
		Medico medico = (Medico) model;
		
		dbMongo.getCollection("medico").
		insertOne(new Document().append("id_medico", medico.getId())
				.append("nome", medico.getNome()).append("sobrenome", medico.getSobrenome())
				.append("especialidade_medica", new Document("especialidade", dbMongo.getCollection("especialidade").
						find(new Document("id_especialidade", medico.getIdEspecialidade())))));
	}	
	
	@Override
	public void update(Model model) {
		Medico medico = (Medico) model;
		
		dbMongo.getCollection("medico").
			updateOne(new Document("_id", medico.get_idObject()), 
					new Document().append("$set", new Document("nome", medico.getNome())
							.append("sobrenome", medico.getSobrenome())
							.append("id_especialidade", medico.getIdEspecialidade())));
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		dbMongo.getCollection("medico").deleteMany(new Document());
	}
	
	public FindIterable<Document> getDocuments(){
		return dbMongo.getCollection("medico").find();
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
