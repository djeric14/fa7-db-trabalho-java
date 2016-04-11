package br.fa7.dao;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import static java.util.Arrays.asList;

import br.fa7.model.Model;

public class QueryMongoDao extends BaseDao {
	
	private MongoClient mongo;
	private MongoDatabase dbMongo;
	
	public QueryMongoDao(String database) {
		super(database);
		mongo = getMongoClient();
		dbMongo = mongo.getDatabase("trabalho_bd");
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

	@Override
	public void query1() {
		// TODO Auto-generated method stub
		dbMongo.getCollection("especialidade").find();
	}

	@Override
	public void query2() {
		// TODO Auto-generated method stub
		dbMongo.getCollection("especialidade").find(new Document("id_especialidade", 1000));
		
	}

	@Override
	public void query3() {
		// TODO Auto-generated method stub
		dbMongo.getCollection("especialidade").find(new Document("nome", "Cardiologia"));
	}

	@Override
	public void query4() {
		// TODO Auto-generated method stub
		dbMongo.getCollection("medico").find();
	}

	@Override
	public void query5() {
		// TODO Auto-generated method stub
		dbMongo.getCollection("medico").find(new Document("id_especialidade", 3));
	}

	@Override
	public void query6() {
		// TODO Auto-generated method stub
		BasicDBObject q = new BasicDBObject();
		q.put("nome", "/^Ma/");
		dbMongo.getCollection("especialidade").find(new Document("nome", q));
	}

	@Override
	public void query7() {
		// TODO Auto-generated method stub
		dbMongo.getCollection("especialidade").count();
	}

	@Override
	public void query8() {
		// TODO Auto-generated method stub
		dbMongo.getCollection("medico").find();
	}

	@Override
	public void query9() {
		// TODO Auto-generated method stub
		dbMongo.getCollection("restaurants").aggregate(asList(
		        new Document("$group", new Document("_id", "$nome").append("count", new Document("$sum", 1)))));
	}

	@Override
	public void query10() {
		// TODO Auto-generated method stub
		dbMongo.getCollection("especialidade").find().limit(1000);
		
	}
	
	
	
}
