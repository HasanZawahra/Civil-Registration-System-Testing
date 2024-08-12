package commons;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {

	public static Properties prop;

	public static void propertyInit() {
		prop = new Properties();

		try {
			FileInputStream file = new FileInputStream("src/main/resources/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@BeforeClass
	public void setUp() {
		propertyInit();
	}
}
