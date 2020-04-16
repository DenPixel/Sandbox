package com.alevel.nix.java.hometask.lesson25;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class AppProperties {

    @PropertyKey(name = "limit")
    public int lim;
    @PropertyKey(name = "speed")
    public int sp;

    public boolean ok = true;

    private AppProperties(){

    }

    private static Properties loadProperties() {
        Properties props = new Properties();

        try(InputStream input = AppProperties.class.getResourceAsStream("app.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return props;
    }

    public static AppProperties build(){
        Class<PropertyKey> propertyKeyClass = PropertyKey.class;
        AppProperties appProp = new AppProperties();
        Properties properties = loadProperties();

        Class<? extends AppProperties> aClass = appProp.getClass();

        List<Field> fieldsWithAnnoPropKey = Arrays.stream(aClass.getFields())
                .filter(field -> field.isAnnotationPresent(propertyKeyClass))
                .collect(Collectors.toList());
        for (Field field : fieldsWithAnnoPropKey) {
            field.setAccessible(true);
            String nameProp = field.getAnnotation(propertyKeyClass).name();
            try {
                field.set(appProp, properties.get(nameProp));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return appProp;
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

    public static void main(String[] args) {
        AppProperties build = AppProperties.build();

        System.out.println("limit = " + build.getLim());
        System.out.println("speed = " + build.getSp());
        System.out.println("ok = " + build.isOk());
    }
}
