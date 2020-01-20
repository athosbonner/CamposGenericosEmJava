package br.com.bean.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import br.com.bean.GenericBean;
import br.com.bean.GenericAttribute;

public class GenericFactory {

	private GenericFactory() {
	};

	// Pattern Factory
	public static GenericBean newInstance(String propertieFileName) {

		GenericBean retorno = null;

		HashMap<String, GenericAttribute> attributes = new HashMap<>();
		String name, type;

		try {

			Properties dictionary = getDictionary(propertieFileName);


			Enumeration list = dictionary.propertyNames();

			while (list.hasMoreElements()) {
				//Get name element. First field of dictionary
				name = (String) list.nextElement();
				//Get type element. ex: java.lang.String 
				type = dictionary.getProperty(name);

				GenericAttribute attribute = new GenericAttribute(name, Class.forName(type));
				attributes.put(name, attribute);

			}

			retorno = new GenericBean("NUMERO_CPF", attributes);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;

	}

	private static Properties getDictionary(String propertieFileName) throws FileNotFoundException, IOException {
		Properties dictionary = new Properties();
		FileInputStream fis = new FileInputStream(propertieFileName);
		dictionary.load(fis);
		fis.close();
		return dictionary;
	}

}
