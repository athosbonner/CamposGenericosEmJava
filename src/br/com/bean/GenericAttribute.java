package br.com.bean;

public class GenericAttribute {
	
	private String nome;
	private Class tipo;
	private Object valor;
	
	public GenericAttribute(String nome, Class tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Class getTipo() {
		return tipo;
	}

	public void setTipo(Class tipo) {
		this.tipo = tipo;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		//Validando se o tipo está de acordo com o valor
		//Para não termos problemas por exemplo de tipo inteiro receber String.
		if (tipo.isAssignableFrom(valor.getClass())) {
			this.valor = valor;
		}else {
			throw new ClassCastException("Tipos incompativeis" + 
						tipo + "" + valor.getClass());
		}
		
	}
	
	
}
