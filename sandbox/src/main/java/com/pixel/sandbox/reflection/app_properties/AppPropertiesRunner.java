package com.pixel.sandbox.reflection.app_properties;

public class AppPropertiesRunner {
    public static void main(String[] args) {
        AppProperties build = AppProperties.build("hometasks/prop/app.properties");

        System.out.println("limit = " + build.getLim());
        System.out.println("speed = " + build.getSp());
        System.out.println("ok = " + build.isOk());
    }
}
