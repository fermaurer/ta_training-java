package com.epam.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

import static java.lang.String.format;

public class PropertyReader {
    private static Properties properties = new Properties();

    static {
        String propertyPath = format("C:\\Users\\HP\\Documents\\epamdocuments\\copiarepositorio\\ta_training-java\\AutomationTask3\\src\\test\\resources\\%s.properties", getEnvironment());
        try (InputStream input = new FileInputStream(propertyPath)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    public static String getEnvironment() {
        if (Objects.isNull(System.getProperty("environment"))) {
            System.setProperty("environment", "qa");
        }
        return System.getProperty("environment");
    }
}
