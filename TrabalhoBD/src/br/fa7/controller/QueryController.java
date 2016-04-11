package br.fa7.controller;

import br.fa7.dao.BaseDao;
import br.fa7.dao.QueryDao;
import br.fa7.dao.QueryMongoDao;

public class QueryController {

	private BaseDao dao;
	private Controller controller;

	public QueryController(Controller controller) {
		this.controller = controller;
		
		if(controller.getDatabase().equals("mongo"))
			dao = new QueryMongoDao(controller.getDatabase());
		else
			dao = new QueryDao(controller.getDatabase());
	
	}

	public void executeQuery() {
		query1();
		query2();
		query3();
		query4();
		query5();
		query6();
		query7();
		query8();
		query9();
		query10();
	}

	private void query1() {
		controller.initTimer();
		dao.query1();
		System.out.println(
				"Consultando " + Controller.getRegistros() + " de especialidades: " + controller.finishTimer());
	}

	private void query2() {
		controller.initTimer();
		dao.query2();
		System.out.println("Consultando especialidades por intervaloe de id :" + controller.finishTimer());
	}

	private void query3() {
		controller.initTimer();
		dao.query3();
		System.out.println("Consultando especialidades usando LIKE : " + controller.finishTimer());
	}

	private void query4() {
		controller.initTimer();
		dao.query4();
		System.out.println("Consultando medicos com especialidades (INNER JOIN): " + controller.finishTimer());
	}

	private void query5() {
		controller.initTimer();
		dao.query5();
		System.out.println("Consultando médicos com especialidades onde o ID da especialidade é 50000: "
				+ controller.finishTimer());
	}

	private void query6() {
		controller.initTimer();
		dao.query6();
		System.out.println("Consultando médicos com especialidades onde o nome da especialidade contém Ma (LIKE): "
				+ controller.finishTimer());
	}

	private void query7() {
		controller.initTimer();
		dao.query7();
		System.out.println("Consultando a quatidade de especialidades (Agregação): " + controller.finishTimer());
	}

	private void query8() {
		controller.initTimer();
		dao.query8();
		System.out.println("Consultando a quatidade de médicos com especialidades " + "(Agregação e JOIN): "
				+ controller.finishTimer());
	}

	private void query9() {
		controller.initTimer();
		dao.query9();
		System.out.println("Consultando a quatidade de médicos com especialidades agrupado por nome "
				+ "(Agregação, JOIN e GROUPBY): " + controller.finishTimer());
	}

	private void query10() {
		controller.initTimer();
		dao.query10();
		System.out.println("Consultando especialidades com limit :" + controller.finishTimer());
	}

}
