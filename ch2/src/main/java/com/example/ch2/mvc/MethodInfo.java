package com.example.ch2.mvc;

import com.example.ch2.controller.YoilTeller;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.example.ch2.controller.YoilTellerMVC");
        Object obj = clazz.getDeclaredConstructor().newInstance();

        Method[] methodArr = clazz.getDeclaredMethods();

        for (Method method : methodArr) {
            String name = method.getName();
            Parameter[] parameters = method.getParameters();
            Class returnType = method.getReturnType();

            StringJoiner paramList = new StringJoiner(", ", "(", ")");

            for (Parameter parameter : parameters){
                String paramName = parameter.getName();
                Class paramType = parameter.getType();

                paramList.add(paramType.getName() + " " + paramName);
            }

            System.out.println(returnType.getName() + " " +name + paramList);
        }

    }
}
