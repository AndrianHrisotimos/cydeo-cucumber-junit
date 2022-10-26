package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();


    static {

        try {
            //2- We need to open the file in java memory: FileInputStream
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            //3- Load the properties object using FileInputStream object
            properties.load(fileInputStream);
            //close the file
            fileInputStream.close();

        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }

    }

    public static String getProperties(String myKey) {
        return properties.getProperty(myKey);
    }


}
