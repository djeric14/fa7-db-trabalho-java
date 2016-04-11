package br.fa7.model;

import org.bson.types.ObjectId;

public class Model {
	
	private Long id;
	private ObjectId _idObject;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ObjectId get_idObject() {
		return _idObject;
	}
	public void set_idObject(ObjectId _idObject) {
		this._idObject = _idObject;
	}
	
	

}
