package br.fa7.controller;

import org.bson.Document;

import com.mongodb.Block;

import br.fa7.dao.BaseDao;
import br.fa7.dao.MedicoDao;
import br.fa7.dao.MedicoMongoDao;
import br.fa7.model.Medico;

public class MedicoController{
	
	private static final String[] nomes = { "João", "Maria", "José", "Eduardo", "Sebastião", "Mariana", "Francisco",
			"Manoel", "Fernanda", "Gabriela", "Mário", "Marcos" };
		
	private static final String[] sobrenomes = { "Souza", "Silva", "Andrade", "Machado", "Júnior", "Albuquerque",
		"Alencar", "Assis", "Batista", "Camargo", "Coelho", "Costa", "Dias", "Rosa", "Leal", "Lima", "Leite" };
	
	
	private BaseDao dao;
	private Medico medico = new Medico();
	private Controller controller;

	public MedicoController(Controller controller) {
		this.controller = controller;
		
		if(controller.getDatabase().equals("mongo"))
			dao = new MedicoMongoDao(controller.getDatabase());
		else
			dao = new MedicoDao(controller.getDatabase());
	}
	
	public void insert(){
		controller.initTimer();
		System.out.println("Iniciada a inclusão de "+Controller.getRegistros()+" médicos ...");
		
		//for(Long i = 1L; i <= Controller.getRegistros(); i++){
			medico.setId(1L);
			medico.setNome(getNomeAleatorio());
			medico.setSobrenome(getSobrenomeAleatorio());
			medico.setIdEspecialidade(getIdEspecialidadeAleatoria());
			dao.insert(medico);
		//}
			
		System.out.println("Médicos adicionados com sucesso - Tempo: "+ controller.finishTimer()+" segundos");
	}
	
	public void update(){
		controller.initTimer();
		System.out.println("Iniciada a alteração dos médicos ...");
		if(dao.getDatabase().equals("mongo")){
			MedicoMongoDao daoMongo = (MedicoMongoDao) dao;
			daoMongo.getDocuments().forEach(new Block<Document>(){
				@Override
				public void apply(final Document document) {
					// TODO Auto-generated method stub
					medico.set_idObject(document.getObjectId("_id"));
					medico.setNome(getNomeAleatorio());
					medico.setSobrenome(getSobrenomeAleatorio());
					medico.setIdEspecialidade(getIdEspecialidadeAleatoria());
					dao.update(medico);
				}
				
			});
		}else{	
			//for(Long i = 1L; i <= Controller.getRegistros(); i++){
				medico.setId(1L);
				medico.setNome(getNomeAleatorio());
				medico.setSobrenome(getSobrenomeAleatorio());
				medico.setIdEspecialidade(getIdEspecialidadeAleatoria());
				dao.update(medico);
			//}
		}	
		
		System.out.println("Médicos alterados com sucesso - Tempo: "+ controller.finishTimer()+" segundos");
	}
	
	public void delete(){
		controller.initTimer();
		System.out.println("Iniciada a exclusão dos médicos ...");
		
		dao.delete();
			 
		System.out.println("Médicos excluídos com sucesso - Tempo: "+ controller.finishTimer()+" segundos");
		//dao.fechar();
	}
	
	private Long getIdEspecialidadeAleatoria() {
		Long id = (long) Math.round(Math.random() * (Controller.getRegistros())); 
				
		if(id > Controller.getRegistros())
			return Controller.getRegistros();
		
		if(id == 0)
			id++;
		
		return id;
	}
	
	private String getSobrenomeAleatorio() {
		int posicao = (int) Math.round(Math.random() * (sobrenomes.length - 1));
		return sobrenomes[posicao];
	}
	
	private String getNomeAleatorio() {
		int posicao = (int) Math.round(Math.random() * (nomes.length - 1));
		return nomes[posicao];
	}
}
