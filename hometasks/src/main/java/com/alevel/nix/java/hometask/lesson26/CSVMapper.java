package com.alevel.nix.java.hometask.lesson26;

import com.alevel.nix.java.hometask.lesson19.CsvTable;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVMapper {
    private Map<Class<?>, Block> lambdaByClass = new HashMap<>();

    public CSVMapper() {
        lambdaByClass.put(int.class,
                (target, field, prop) -> {
                    field.setInt(target, Integer.parseInt(prop));
                }
        );
        lambdaByClass.put(long.class,
                (target, field, prop) -> {
                    field.setLong(target, Long.parseLong(prop));
                }
        );
        lambdaByClass.put(double.class,
                (target, field, prop) -> {
                    field.setDouble(target, Double.parseDouble(prop));
                }
        );
        lambdaByClass.put(boolean.class,
                (target, field, prop) -> {
                    field.setBoolean(target, Boolean.parseBoolean(prop));
                }
        );
        lambdaByClass.put(String.class,
                (target, field, prop) -> {
                    field.set(target, prop);
                }
        );
    }

    public <T> List<T> createAll(String pathToCSVFile, Class<T> tClass) {
        try {
            CsvTable csvTable = new CsvTable(pathToCSVFile);
            Constructor<T> constructor = tClass.getConstructor();
            List<T> list = new ArrayList<>();
            for (int i = 0, size = csvTable.getCountRows(); i < size; i++) {
                T target = constructor.newInstance();


                for (Field field : tClass.getDeclaredFields()) {
                    field.setAccessible(true);
                    CSVMap key = field.getAnnotation(CSVMap.class);
                    if (key == null) continue;
                    String prop = csvTable.getElement(i, key.value());
                    if (prop == null) continue;
                    Class<?> type = field.getType();


                    if (lambdaByClass.containsKey(type)) {
                        lambdaByClass.get(type).run(target,field,prop);
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
