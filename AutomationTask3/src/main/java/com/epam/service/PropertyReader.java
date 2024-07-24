package com.epam.service;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import java.util.Properties;

import static java.lang.String.format;

/**
 * The PropertyReader class is responsible for loading properties from a .properties file
 * based on the specified environment.
 * It provides methods to retrieve the value of a property given its key and to determine
 * the current environment.
 */
public class PropertyReader {
    private static Properties properties = new Properties();

    /**
     * Static block to load properties from the .properties file based on the environment.
     * The properties file path is constructed using the environment name.
     */
    static {
        String propertyPath = format("C:\\Users\\HP\\Documents\\epamdocuments\\copiarepositorio\\ta_training-java\\AutomationTask3\\src\\test\\resources\\%s.properties", getEnvironment());
        try (InputStream input = new FileInputStream(propertyPath)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

/**
 * Retrieves the value of a property given its key.
 */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

/**
 * Determines the current environment by checking the "environment" system property.
 * If the "environment" property is not set, it defaults to "qa".
 */
    public static String getEnvironment() {
        if (Objects.isNull(System.getProperty("environment"))) {
            System.setProperty("environment", "qa");
        }
        return System.getProperty("environment");
    }
}
