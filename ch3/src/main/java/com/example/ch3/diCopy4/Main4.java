package com.example.ch3.diCopy4;

import com.google.common.reflect.ClassPath;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext();

        Car car = (Car) ac.getBean("diCopy4.car");
        Engine engine = (Engine) ac.getBean("engine");
        Door door = (Door) ac.getBean(Door.class);

        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
        System.out.println("door = " + door);


    }
}

class AppContext{
    Map mapByName, mapByType;

    AppContext() {
        mapByName = new HashMap();
        mapByType = new HashMap();
        doComponentScan();
        doAutowired();
        doResource();
    }

    private void doResource() {
        try {
            for (Object bean : mapByName.values()){
                for (Field fld: bean.getClass().getDeclaredFields()){
                    if(fld.getAnnotation(Resource.class) != null){
                        fld.set(bean, getBean(fld.getName()));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void doAutowired() {
        try {
            for (Object bean : mapByName.values()){
                for (Field fld: bean.getClass().getDeclaredFields()){
                    if(fld.getAnnotation(Autowired.class) != null){
                        fld.set(bean, getBean(fld.getType()));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void doComponentScan(){
        try {
            ClassLoader classLoader = AppContext.class.getClassLoader();
            ClassPath classPath = ClassPath.from(classLoader);

            Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses(this.getClass().getPackageName());

            for (ClassPath.ClassInfo classInfo : set){
                Class clazz = classInfo.load();
                Component component = (Component) clazz.getAnnotation(Component.class);

                if (component != null){
                    String id = StringUtils.uncapitalize(classInfo.getSimpleName());
                    Object obj= clazz.getDeclaredConstructor().newInstance();
                    mapByName.put(id, obj);
                    mapByType.put(clazz, obj);
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

@ToString
@Component("diCopy4.car") class Car {
   @Resource Engine engine;
   @Resource Door door;
}

@Component("diCopy4.sportCar") class SportCar extends Car {}

@Component("diCopy4.truck") class Truck extends Car {}

@Component("diCopy4.engine") class Engine {}

@Component("diCopy4.door") class Door {}