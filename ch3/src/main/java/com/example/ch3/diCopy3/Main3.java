package com.example.ch3.diCopy3;

import com.google.common.reflect.ClassPath;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main3 {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext();

        Car car = (Car) ac.getBean("car");
        Car car2 = (Car) ac.getBean(SportCar.class);
        Engine engine = (Engine) ac.getBean("engine");

        System.out.println("car = " + car);
        System.out.println("car2 = " + car2);
        System.out.println("engine = " + engine);
    }
}

class AppContext{
    Map mapByName, mapByType;

    AppContext() {
        mapByName = new HashMap();
        mapByType = new HashMap();
        doComponentScan();
    }

    private void doComponentScan(){
        try {
            ClassLoader classLoader = AppContext.class.getClassLoader();
            ClassPath classPath = ClassPath.from(classLoader);

            Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.example.ch3.diCopy3");

            for (ClassPath.ClassInfo classInfo : set){
                Class clazz = classInfo.load();
                Component component = (Component) clazz.getAnnotation(Component.class);

                if (component != null){
                    String id = StringUtils.uncapitalize(classInfo.getSimpleName());
                    mapByName.put(id, clazz.getDeclaredConstructor().newInstance());
                    mapByType.put(clazz, clazz.getDeclaredConstructor().newInstance());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    Object getBean(String key){
        return mapByName.get(key);
    }

    Object getBean(Class clazz){
        return mapByType.get(clazz);
    }
}

@Component("diCopy3.car") class Car {}

@Component("diCopy3.sportCar") class SportCar extends Car {}

@Component("diCopy3.truck") class Truck extends Car {}

@Component("diCopy3.engine") class Engine {}
