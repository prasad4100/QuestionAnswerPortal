import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
	private final Properties prop=new Properties();
	public PropertiesLoader() {
		try {
			FileInputStream file=new FileInputStream("resources/oracledb1.properties");
			prop.load(file);	
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public String getValues(String key) {
		return prop.getProperty(key);
	}
	
}
