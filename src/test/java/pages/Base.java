package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Base {

    public static void readPropertiesFile() {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("/Users/marcorozo/Documents/Test/git/Selenium/SeleniumPageObModel/src/test/resources/constants.properties");
            prop.load(input);
            prop.getProperty("SEND_TEXT");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
