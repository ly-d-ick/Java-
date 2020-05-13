package com.example.javaadvanced.generic.restrict;

public class Restrict<T> {
    private T data;

    //不能实例化类型变量
//    public Restrict() {
//        this.data = new T();
//    }


    //静态域或者方法里不能引用类型变量
    //private static T instance;
    //静态方法 本身是泛型方法就行
    //private static <T> T getInstance(){}


    public static void main(String[] args) {
        //Restrict<double>
        Restrict<Double> restrict = new Restrict<>();

//        if(restrict instanceof  Restrict<Double>)
//        if(restrict instanceof  Restrict<T>)

        Restrict<String> restrictString = new Restrict<>();

        System.out.println(restrict.getClass() == restrictString.getClass());
        System.out.println(restrict.getClass().getName());
        System.out.println(restrictString.getClass().getName());


        Restrict<Double>[] restrictArray;
        //Restrict<Double>[] restricts = new Restrict<Double>[10];
//        ArrayList<String>[] list1 = new ArrayList<String>[10];
//        ArrayList<String>[] list2 = new ArrayList[10];

    }


}
