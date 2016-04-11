package br.fa7.controller;

import org.bson.Document;

import com.mongodb.Block;

import br.fa7.dao.BaseDao;
import br.fa7.dao.EspecialidadeDao;
import br.fa7.dao.EspecialidadeMongoDao;
import br.fa7.model.Especialidade;

public class EspecialidadeController {
		
	private BaseDao dao;
	private Especialidade especialidade = new Especialidade();
	private Controller controller;
	
	private static final String[] especialidades = { "Cardiologia", "Gastroentorogia", "Urologia", 
			"Otorrinolaringologia", "Neulorogia", "Protoclogia", "Hematologia",
			"Endocrinologia", "Traumatologia", "Ortopedia", "Dermatologia"};
	
	public EspecialidadeController(Controller controller){
		this.controller = controller;
				
		if(controller.getDatabase().equals("mongo"))
			dao = new EspecialidadeMongoDao(controller.getDatabase());
		else
			dao = new EspecialidadeDao(controller.getDatabase());
	}
	
	public void insert() {
		
		this.controller.initTimer();
		System.out.println("Iniciada a inclusão de "+Controller.getRegistros() +" especialidades ...");
		
		for(Long i = 1L; i <= Controller.getRegistros(); i++){
			especialidade.setId(i);
			especialidade.setNome(getEspecialidadeAleatoria());
			dao.insert(especialidade);
		}
			
		System.out.println("Especialidades adicionadas com sucesso - Tempo: "+ controller.finishTimer()+" segundos");
	}
	
	public void update() {
		controller.initTimer();
		System.out.println("Iniciada a alteração das especialidades ...");
		
		if(dao.getDatabase().equals("mongo")){
			EspecialidadeMongoDao daoMongo = (EspecialidadeMongoDao) dao;
			daoMongo.getDocuments().forEach(new Block<Document>(){
				@Override
				public void apply(final Document document) {
					// TODO Auto-generated method stub
					especialidade.set_idObject(document.getObjectId("_id"));
					especialidade.setNome(getEspecialidadeAleatoria());
					dao.update(especialidade);
				}
				
			});
		}else{	
			for(Long i = 1L; i <= Controller.getRegistros(); i++){
				especialidade.setId(i);
				especialidade.setNome(getEspecialidadeAleatoria());
				dao.update(especialidade);
			}
		}
		 
		System.out.println("Especialidades alteradas com sucesso - Tempo: "+ controller.finishTimer()+" segundos");
	}
	
	public void delete() {
		controller.initTimer();
		System.out.println("Iniciada a exclusão das especialidades ...");
		
		dao.delete();
			
		System.out.println("Especialidades excluídas com sucesso - Tempo: "+ controller.finishTimer()+" segundos");
	}
	
	public void closeConnection(){
		dao.closeConnection();
	}
	
	public String getEspecialidadeAleatoria() {
		int posicao = (int) Math.round(Math.random() * (especialidades.length - 1));
		if(posicao == 0)
			posicao ++;
		return especialidades[posicao];
	}
}
