package br.com.bean.teste;

import br.com.bean.GenericBean;
import br.com.bean.factory.GenericFactory;

public class Teste {

	public static void main(String[] args) {
		
		GenericBean bean = GenericFactory.newInstance("src/dictionary.properties");
		
		bean.setAtrribute("NUMERO_CPF", "00099988854");
		bean.setAtrribute("NUMERO_CEP", "5319010");
		
		
		System.out.println(bean.getAttribute("NUMERO_CPF"));
		System.out.println(bean.getAttribute("NUMERO_CEP"));
		
	}

}
