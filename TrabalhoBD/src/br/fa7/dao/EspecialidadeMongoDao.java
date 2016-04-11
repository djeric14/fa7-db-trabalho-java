package br.fa7.dao;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import br.fa7.model.Especialidade;
import br.fa7.model.Model;

public class EspecialidadeMongoDao extends BaseDao {
	
	private MongoClient mongo;
	private MongoDatabase dbMongo;

	public EspecialidadeMongoDao(String database) {
		super(database);
		mongo = getMongoClient();
		dbMongo = mongo.getDatabase("trabalho_bd");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void insert(Model model) {
		Especialidade especialidade = (Especialidade) model;	
		dbMongo.getCollection("especialidade").
		insertOne(new Document().append("id_especialidade", especialidade.getId())
				.append("nome", especialidade.getNome()));
		
	}	
	
	@Override
	public void update(Model model) {
		Especialidade especialidade = (Especialidade) model;
		
		dbMongo.getCollection("especialidade").
			updateOne(new Document("_id", especialidade.get_idObject()), 
					new Document("$set", new Document("nome", especialidade.getNome())));
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		dbMongo.getCollection("especialidade").deleteMany(new Document());
	}
	
	public FindIterable<Document> getDocuments(){
		return dbMongo.getCollection("especialidade").find();
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
