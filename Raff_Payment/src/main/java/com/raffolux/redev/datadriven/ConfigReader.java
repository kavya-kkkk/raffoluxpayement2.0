package com.raffolux.redev.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;
	private static String path = "C:\\Users\\Rhibhus\\git\\Raff_Payment1\\Raff_Payment\\src\\test\\resources\\configuration.properties";

	static {
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			properties = new Properties();
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Invalid File path");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
