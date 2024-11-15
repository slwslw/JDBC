package com.itheima.reflect.method;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo2 {


    @Test
    public void testMethod5() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1、获取Class对象
        Class<Student> studentClass = Student.class;

        //2、基于Class对象，获取静态方法
        Method method = studentClass.getDeclaredMethod("hello", String.class);

        //3、利用Method对象，运行方法
        method.invoke(null,  "张三");//静态方法的调用是通过 ： 类名.静态方法

    }


    @Test
    public void testMethod4() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1、获取Class对象
        Class<Student> studentClass = Student.class;
        Student student = studentClass.newInstance();//可以使用Class类中的newInstance()方法直接调用Student类中的无参构造创建对象

        //2、基于Class对象，获取私有的sayHello方法
        Method method = studentClass.getDeclaredMethod("sayHello", String.class, String.class);

        //取消权限检查
        method.setAccessible(true);

        //3、利用Method对象，运行方法
        Object result = method.invoke(student, "你好,", "张三");

        System.out.println(result);

    }


    @Test
    public void testMethod3() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1、获取Class对象
        Class<Student> studentClass = Student.class;
        Student student = studentClass.newInstance();//可以使用Class类中的newInstance()方法直接调用Student类中的无参构造创建对象

        //2、基于Class对象，获取sleep方法
        Method method = studentClass.getMethod("sleep", String.class);

        //3、利用Method对象，运行方法
        method.invoke( student , "张三");

    }




    @Test
    public void testMethod2() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1、获取Class对象
        Class<Student> studentClass = Student.class;
        Student student = studentClass.newInstance();//可以使用Class类中的newInstance()方法直接调用Student类中的无参构造创建对象

        //2、基于Class对象，获取到本类所有的方法（包含：私有）
        Method[] methods = studentClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method);
        }

    }
    @Test
    public void testMethod() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1、获取Class对象
        Class<Student> studentClass = Student.class;
        Student student = studentClass.newInstance();//可以使用Class类中的newInstance()方法直接调用Student类中的无参构造创建对象

        //2、基于Class对象，获取到所有的public修饰的Method对象（成员方法对象）
        Method[] methods = studentClass.getMethods();//获取本类中的public修饰的方法，以及父类中的方法

        for (Method method : methods) {
            System.out.println(method);
        }

    }
}
