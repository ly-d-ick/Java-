package com.example.javaadvanced.generic.wildchar;

public class WildChar{

    public static void print(GenericType<Fruit> p){
        System.out.println(p.getData().getColor());
    }

    public static void use(){
       GenericType<Fruit> a = new GenericType<>();
        print(a);
       GenericType<Orange> b = new GenericType<>();
        //print(b);
    }


    public static void print2(GenericType<? extends Fruit> p){
        System.out.println(p.getData().getColor());
    }

    public static void use2(){
        GenericType<Fruit> a = new GenericType<>();
        print2(a);
        GenericType<Orange> b = new GenericType<>();
        print2(b);
        //print2(new GenericType<Food>());
        GenericType<? extends Fruit> c =  new GenericType<>();

        Apple apple =  new Apple();
        Fruit fruit = new Fruit();
        //c.setData(apple);
        //c.setData(fruit);
        Fruit x = c.getData();
    }

    public static void printSuper(GenericType<? super Apple> p){
        System.out.println(p.getData());
    }

    public static void useSuper(){
        GenericType<Fruit> fruitGenericType = new GenericType<>();
        GenericType<Apple> appleGenericType = new GenericType<>();
        GenericType<RedFuji> hongFuShiGenericType = new GenericType<>();
        GenericType<Orange> orangeGenericType = new GenericType<>();
        printSuper(fruitGenericType);
        printSuper(appleGenericType);
//        printSuper(hongFuShiGenericType);
//        printSuper(orangeGenericType);


        //表示GenericType的类型参数的下界是Apple
        GenericType<? super Apple> x = new GenericType<>();
        x.setData(new Apple());
        x.setData(new RedFuji());
        //x.setData(new Fruit());
        Object data = x.getData();

    }

}
