package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class dataReader {
	
public static String getTestData (String testData1) throws Throwable{
		
		File src = new File("./objectRepo/locator.property");
		FileInputStream dataGrab = new FileInputStream(src);
		Properties property = new Properties();
		property.load(dataGrab);
		String testData = property.getProperty(testData1);
		return testData;
	}

}
