package br.fa7.test;

import br.fa7.controller.Controller;

public class Running {
	
	private Controller controller;
	private Double tempoTotal;

	public Running() {
		// TODO Auto-generated constructor stub
	}
	
	public void runningOracle(){
		System.out.println("========================= Oracle ==========================");
		System.out.println("");
		tempoTotal = (double) System.currentTimeMillis();
		
		controller = new Controller("oracle");
		controller.run();
		
		tempoTotal = (System.currentTimeMillis()-tempoTotal)/1000; 
		System.out.println("Tempo final de execução no oracle "+ tempoTotal);
		controller.closeConnection();
	}
	
	public void runningSQLite(){
		System.out.println("========================= SQLite ==========================");
		System.out.println("");
		tempoTotal = (double) System.currentTimeMillis();
		
		controller = new Controller("sqlite");
		controller.run();
	
		tempoTotal = (System.currentTimeMillis()-tempoTotal)/1000; 
		System.out.println("Tempo final de execução no sqlite "+ tempoTotal);
	}
	
	public void runningMongo(){
		System.out.println("========================= Mongo ==========================");
		System.out.println("");
		tempoTotal = (double) System.currentTimeMillis();
		
		controller = new Controller("mongo");
		controller.run();
		
		tempoTotal = (System.currentTimeMillis()-tempoTotal)/1000; 
		System.out.println("Tempo final de execução no mongo "+ tempoTotal);
	}

}
