package com.pixel.sandbox.reflection.csv_mapper;

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

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }
}
