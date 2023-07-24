package com.qa.app.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String getProperty(String key) {
		Properties pro = new Properties();

		try {

			pro.load(new FileReader("D:/GithubWS/page_obj_mod/resources/Config.properties"));
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		String value = pro.getProperty(key);

		return value;
	}

}
