package com.alevel.nix.java.hometask.lesson26;

import com.alevel.nix.java.hometask.lesson19.CsvTable;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CSVMapper {

    public <T> List<T> createAll(String pathToCSVFile, Class<T> tClass) {
        try {
            CsvTable csvTable = new CsvTable(pathToCSVFile);
            Constructor<T> constructor = tClass.getConstructor();
            List<T> list = new ArrayList<>();
            for (int i = 0, size = csvTable.getCountRows(); i < size; i++) {
                T target = constructor.newInstance();

                for (Field field : tClass.getDeclaredFields()) {
                    field.setAccessible(true);
//                    if (field.canAccess(target)) continue;
                    CSVMap key = field.getAnnotation(CSVMap.class);
                    if (key == null) continue;
                    String prop = csvTable.getElement(i,key.value());
                    if (prop == null) continue;

                    Class<?> type = field.getType();
                    if (type == int.class) {
                        field.setInt(target, Integer.parseInt(prop));
                    } else if (type == long.class) {
                        field.setLong(target, Long.parseLong(prop));
                    } else if (type == double.class) {
                        field.setDouble(target, Double.parseDouble(prop));
                    } else if (type == boolean.class) {
                        field.setBoolean(target, Boolean.parseBoolean(prop));
                    } else if (type == String.class) {
                        field.set(target, prop);
                    } else {
                        throw new UnsupportedOperationException("Unsupported field type (" +
                                type.getName() + ") is required for field " +
                                field.getName());
                    }
                }

                list.add(target);
            }
            return list;
        } catch (IOException |
                NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException |
                InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
