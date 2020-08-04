package com.pixel.sandbox.reflection.app_properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class AppProperties {

    @PropertyKey(name = "limit")
    public int lim;
    @PropertyKey(name = "speed")
    public int sp;

    public boolean ok = true;

    private AppProperties(){

    }

    private static Properties loadProperties(String path) {
        Properties props = new Properties();

        try(InputStream input = Files.newInputStream(Paths.get(path))) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return props;
    }

    public static AppProperties build(String pathProperties){
        AppProperties instance = new AppProperties();
        Properties properties = loadProperties(pathProperties);

        try {
            Class<? extends AppProperties> classOfInstance = instance.getClass();

            Field sp = classOfInstance.getField("sp");
            Field lim = classOfInstance.getField("lim");

            String nameProp;

            nameProp = sp.getAnnotation(PropertyKey.class).name();
            String propertySp = properties.getProperty(nameProp);
            sp.setInt(instance, Integer.parseInt(propertySp));

            nameProp = lim.getAnnotation(PropertyKey.class).name();
            String propertyLim = properties.getProperty(nameProp);
            lim.setInt(instance, Integer.parseInt(propertyLim));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return instance;
    }

    public int getLim() {
        return lim;
    }

    public int getSp() {
        return sp;
    }

    public boolean isOk() {
        return ok;
    }

}
