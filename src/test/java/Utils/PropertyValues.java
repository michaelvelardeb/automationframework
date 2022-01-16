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
    String BROWSER;
    String PORT;
    String SELENIUM_HUB;
    String PATH_TO_EXTENT_REPORT;

    public void setBrowser(String browser) {
        this.BROWSER = browser;
    }

    public String getBrowser() {
        return BROWSER;
    }

    public String getPATH_TO_EXTENT_REPORT() {
        return PATH_TO_EXTENT_REPORT;
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
            BROWSER = properties.getProperty("BROWSER");
            PORT = properties.getProperty("PORT");
            SELENIUM_HUB = String.format(properties.getProperty("SELENIUM_HUB"), PORT);
            PATH_TO_EXTENT_REPORT = properties.getProperty("PATH_TO_EXTENT_REPORT");


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }
}
