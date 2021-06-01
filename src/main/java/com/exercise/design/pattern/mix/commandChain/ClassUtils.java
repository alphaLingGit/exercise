package com.exercise.design.pattern.mix.commandChain;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassUtils {

    public static List<Class> getSonClass(Class aClass) {
        List<Class> list = new ArrayList<>();
        String packageName = aClass.getPackage().getName();
        List<Class> classes = getClasses(packageName);
        for (Class aClass1 : classes) {
            if (aClass.isAssignableFrom(aClass1) && !aClass.equals(aClass1)) {
                list.add(aClass1);
            }
        }
        return list;
    }

    private static List<Class> getClasses(String packageName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        Enumeration<URL> resources = null;
        try {
            resources = classLoader.getResources(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        List<Class> classes = new ArrayList<>();
        for (File dir : dirs) {
            classes.addAll(findClasses(dir, packageName));
        }
        return classes;
    }

    private static List<Class> findClasses(File dir, String packageName) {
        List<Class> classes = new ArrayList<>();
        if (!dir.exists()) {
            return classes;
        }
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                try {
                    classes.add(Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return classes;
    }
}
