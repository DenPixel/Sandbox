package com.alevel.nix.java.hometask.lesson26;

public class PersonalData {

    @CSVMap("surname")
    private String surname;

    @CSVMap("name")
    private String name;

    @CSVMap("patronymic")
    private String patronymic;

    @CSVMap("age")
    private int age;

    @Override
    public String toString() {
        return "PersonalData{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                '}';
    }
}
