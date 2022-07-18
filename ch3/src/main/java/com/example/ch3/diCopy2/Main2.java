package com.example.ch3.diCopy2;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Main2 {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext();

        Car car = (Car) ac.getBean("car");
        Engine engine = (Engine) ac.getBean("engine");

        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }
}

class AppContext{
    Map map;

    AppContext() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Properties p = new Properties();
        p.load(new FileReader("src/main/resources/config.txt"));
        map = new HashMap(p);

        for (Object key : map.keySet()){
            Class clazz = Class.forName((String) map.get(key));
            map.put(key, clazz.getDeclaredConstructor().newInstance());
        }
    }

    Object getBean(String key){
        return map.get(key);
    }
}

class Car {}

class SportCar extends Car {}

class Truck extends Car {}

class Engine {}
