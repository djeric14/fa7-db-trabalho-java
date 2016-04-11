package br.fa7.controller;

import br.fa7.dao.RunController;

public class Controller implements RunController{
	
	private static Long registros;
	private Double timer;
	private String database;
	private EspecialidadeController especialidadeController;
	private MedicoController medicoController;
	private QueryController queryController;
	
	public Controller(String database){
		registros = 1000000L;
		this.database = database;
		especialidadeController = new EspecialidadeController(this);
		medicoController = new MedicoController(this);
		queryController = new QueryController(this);
	}

	public static Long getRegistros() {
		return registros;
	}

	public Double getTimer() {
		return timer;
	}

	public void setTimer(Double timer) {
		this.timer = timer;
	}
	
	public void initTimer(){
		this.timer =  (double) System.currentTimeMillis();
	}
	
	public Double finishTimer(){
		return this.timer = (System.currentTimeMillis() - getTimer()) / 1000; 
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		especialidadeController.insert();
		medicoController.insert();
		queryController.executeQuery();
		especialidadeController.update();
		medicoController.update();
		medicoController.delete();
		especialidadeController.delete();
	}
	
	public void closeConnection(){
		especialidadeController.closeConnection();
	}

}
