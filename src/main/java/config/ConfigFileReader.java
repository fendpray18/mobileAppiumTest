package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    public static String getConfigPropertyVal(String propertyName) {
        String reportConfigPath = "";
        try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\configuration.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            reportConfigPath = prop.getProperty(propertyName);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return reportConfigPath;
    }


}
