package org.mir.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ProjectProperties {
    private static Properties properties ;
    static {

            try {
                properties = new Properties();
                FileInputStream fileInputStream = new FileInputStream(".\\src\\test\\resources\\project.properties");
                properties.load(fileInputStream); //exception here
            }
            catch (Exception ex)
            {

            }
        }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }


}
