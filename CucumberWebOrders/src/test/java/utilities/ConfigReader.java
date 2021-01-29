package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	
private static Properties prop;
    
    static {
        String path="configuration.properties";
        try {
            FileInputStream fis= new FileInputStream(path);
            prop=new Properties();
            prop.load(fis);
            fis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
	
}
