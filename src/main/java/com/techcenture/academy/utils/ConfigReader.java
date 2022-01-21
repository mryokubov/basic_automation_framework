package com.techcenture.academy.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by tairovich_jr on 2022-01-20.
 */
public class ConfigReader {

    private static Properties properties;
    private static final String propertyFilePath = "src/main/resources/configuration.properties";

    private ConfigReader(){ }

    static {
        try{
            FileInputStream inputStream = new FileInputStream(propertyFilePath);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyName){
        return properties.getProperty(keyName);
    }

    public static void setProperty(String key, String value) throws IOException {
        properties.store(new FileOutputStream("src/main/resources/configuration.properties"), null);
        properties.setProperty(key, value);
    }

}
