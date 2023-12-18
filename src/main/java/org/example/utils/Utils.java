package org.example.utils;


import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class Utils {

    public Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = Utils.class.getClassLoader().getResourceAsStream("test.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
