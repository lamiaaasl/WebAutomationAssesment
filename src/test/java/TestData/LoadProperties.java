package TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
// Load the properties file from the folder
	public static Properties configuration = 
			LoadProb(System.getProperty(("user.dir")+"\\src\\main\\java\\Properties\\configuration.properties"));
	
	public static Properties LoadProb(String Path) {
		Properties pro = new Properties();
		try {
			FileInputStream stream = new FileInputStream(Path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
		System.out.println("Error Occured : " + e.getMessage());
		} catch (IOException e) {
		System.out.println("Error Occured : " + e.getMessage());
		}
		catch (NullPointerException e) {
		System.out.println("Error Occured : " + e.getMessage());
		}
		return pro;
	}
}
