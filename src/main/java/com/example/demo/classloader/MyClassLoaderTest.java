package com.example.demo.classloader;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 自定义类加载器
 * @author robert
 */
public class MyClassLoaderTest {
    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replace(".", "/");
            FileInputStream fileInputStream = new FileInputStream(classPath + "/" + name + ".class");
            int len = fileInputStream.available();
            byte[] data = new byte[len];
            fileInputStream.read(data);
            fileInputStream.close();
            return data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        public static void main(String[] args) throws Exception {
            MyClassLoader myClassLoader = new MyClassLoader("D:\\test");
            Class<?> clazz = myClassLoader.findClass("InsertSort");
            Object obj = clazz.newInstance();
            Method[] methods = clazz.getMethods();
            System.out.println(Arrays.toString(methods));
            String[] strs = new String[]{};
            Method method = clazz.getDeclaredMethod("main", String[].class);
            method.invoke(obj, new Object[]{strs});
            System.out.println(clazz.getClassLoader().getClass().getName());
            System.out.println(MyClassLoader.class.getClassLoader().getClass().getName());
        }
    }
}
