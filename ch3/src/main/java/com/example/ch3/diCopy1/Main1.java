package com.example.ch3.diCopy1;

import java.io.FileReader;
import java.util.Properties;

public class Main1 {
    public static void main(String[] args) throws Exception {
        Car car = (Car) getObject("car");
        Engine engine = (Engine) getObject("engine");

        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }

    private static Object getObject(String key) throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("src/main/resources/config.txt"));

        Class clazz = Class.forName(p.getProperty(key));

        return clazz.getDeclaredConstructor().newInstance();
    }

    private static Car getCar() throws Exception{
        return (Car) getObject("car");
    }


}

class Car {}

class SportCar extends Car {}

class Truck extends Car {}

class Engine {}
