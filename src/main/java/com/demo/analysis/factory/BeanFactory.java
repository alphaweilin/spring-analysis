package com.demo.analysis.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {

	private static Properties env = new Properties();

	static {
		try (InputStream inputStream = BeanFactory.class.getResourceAsStream("/applicationContext.properties");) {
			env.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object getBean(String key) {
		Object ret = null;
		try {
			Class clz = Class.forName(env.getProperty(key));
			ret = clz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

}
