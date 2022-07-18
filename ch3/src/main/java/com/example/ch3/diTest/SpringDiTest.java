/*
package com.example.ch3.diTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

public class SpringDiTest {
    public void main() {
        ApplicationContext ac = ApplicationContextProvider.getContext();
        ApplicationContext context = new GenericXmlApplicationContext("config.xml");

        Car car = ac.getBean("car", Car.class);

        Engine engine = ac.getBean("engine", Engine.class);
        Engine engine1 = ac.getBean("superEngine", SuperEngine.class);
        Door door = ac.getBean("door", Door.class);

        car.setColor("red");
        car.setOil(100);
        car.setEngine(engine);
        car.setDoors(new Door[]{ac.getBean("diTest.door", Door.class),
                ac.getBean("diTest.door", Door.class)});

        System.out.println("ac = " + ac);
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
        System.out.println("engine1 = " + engine1);
        System.out.println("door = " + door);
    }
}

@Component
@Scope("prototype")
class Car{
    @Value("red")
    String color;

    @Value("100")
    int oil;

    @Resource(name = "superEngine")
    Engine engine;

    @Autowired
    Door[] doors;

    public Car() {
    }

    public Car(String color, int oil, Engine engine, Door[] doors) {
        this.color = color;
        this.oil = oil;
        this.engine = engine;
        this.doors = doors;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", oil=" + oil +
                ", engine=" + engine +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }
}

@Component
class Engine{}

@Component
class SuperEngine extends Engine{}

@Component
class TurboEngine extends Engine{}
@Component
@Scope("prototype")
class Door{}
*/
