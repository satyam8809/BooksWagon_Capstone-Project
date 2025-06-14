package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public static Properties readProperties() {
		String filename = "src\\test\\resources\\config\\config.properties";
		FileInputStream fis;
		Properties prop = null;
		
		try {
			fis = new FileInputStream(filename);
			prop = new Properties();
			prop.load(fis);
		}
		catch(FileNotFoundException e) {
			System.out.println("The file or fill name is not correct, please check it");
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
