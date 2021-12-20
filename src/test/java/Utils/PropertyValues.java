package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyValues {
    InputStream inputStream;
    String browser;

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }

    public void getPropValues() throws IOException {
        Properties properties = null;
        try {
            properties = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            browser = properties.getProperty("browser");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }
}
