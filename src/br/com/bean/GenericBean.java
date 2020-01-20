package br.com.bean;

import java.util.HashMap;

public class GenericBean {
	
	private String nome;
	private HashMap<String, GenericAttribute> attributes;
	
	public GenericBean(String nome, HashMap<String, GenericAttribute> attributes) {
		this.nome = nome;
		this.attributes = attributes;
	}

	
	public void setAtrribute(String att, Object value) {
		try {
			attributes.get(att).setValor(value);
		}catch (ClassCastException e) {
			throw e;
		}
		
	}
	
	
	public Object getAttribute(String att) {
		return attributes.get(att).getValor();
	}
	
	
}
