# Java进阶学习
## [1.泛型](#generic) 
## [2.反射](#reflection) 

# <a name="generic">泛型</a>
## 一、定义
> “参数化类型”，平时定义任何方法时，例如传入int x,y属于典型的形参，调用时传入的1、2就是实参，参数类型在定义的时候参数类型本身参数化，在实际调用时告诉我们传入什么类型的参数

### 使用泛型的好处

- 适用于多种数据类型执行相同的代码

- 泛型中的类型在使用时指定，不需要强制类型转换

## 二、分类

### 1、泛型类

### 2、泛型接口

#### 实现方式分以下两种

##### 1.泛型类的方式实现泛型接口，例码：

```

public class ImplGenertor<T> implements Genertor<T> {

    @Override

    public T next() {

        return null;

    }

}

```

##### 2.直接规定参数类型，例码：

```

public class ImplGenertor2 implements Genertor<String> {

    @Override

    public String next() {

        return null;

    }

}

```

### 3、泛型方法

- #### 特点:完全独立，可在任何地方和任何场景中使用，包括普通类和泛型类

- #### 与普通方法区别

##### 普通方法：

```

public class Generic<T> {

        private T key;

        public Generic(T key) {

            this.key = key;

        }

        /* ---------------- 1 ---------------- */

        // 虽然在方法中使用了泛型，但并不是一个泛型方法

        // 这只是类中一个普通的成员方法，只不过返回值是在声明泛型类已经声明过的泛型

        // 所以在这个方法中才可以继续使用T这个泛型

        public T getKey() {

            return key;

        }

        /* ---------------- 2 ---------------- */

        // 使用了Generic<Number>这个泛型类做形参的普通方法。

        public void show(Generic<Number> num) {

        }

}

```

##### 泛型方法

###### 1.声明在泛型类的方法就不一定是泛型方法

###### 2.泛型类里定义泛型方法需要遵循泛型方法的规则，带<任一大写(国际惯例)字母>

```

/** 首先在方法权限关键字与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T

  * 这个T可以出现在这个泛型方法的任意位置.

  * 泛型的数量也可以为任意多个

  *    如：public <T,K> K showKeyName(Generic<T> container){

  *        ...

  *        }

  */

```

## 三、限定类型变量

### 泛型类和泛型方法都可使用类型变量的限定，泛型方法使用案例如：对类型变量加以约束，比如计算两个变量的最小，最大值

```

public static <T> T min(T a,T b){

    if(a.compareTo(b) > 0) {

        return a;

    } else {

        return b;

    }

}

/* 为了确保传入的两个变量一定有compareTo方法，解决方案为将T限制为实现了接口Comparable的类 */

public static <T extends Comparable> T min(T a, T b){

    if(a.compareTo(b) > 0) {

        return a;

    } else {

        return b;

    }

}

/*  限定类型可以多个，类和接口均行，若类和接口混用，类必须放在第一位，且只能有一个(原因Java是单继承多实现) */

public static <T extends ArrayList & Comparable & Serializable & ...> T min(T a, T b){

    if(a.compareTo(b) > 0) {

        return a;

    } else {

        return b;

    }

}

```

## 四、约束和局限性

### 1、不能实例化类型变量

```

public Restrict() {

    this.data = new T();

}

```

### 2、静态域或方法里不能引用类型变量（Re:虚拟机创建一个对象时，优先执行static代码，再执行构造方法，泛型的类型只有在对象创建时才知道）

```

private static T instance;

注：静态方法是泛型方法就没有问题

private static <T> T instance(){}

```

### 3、基本类型不允许作为实例化类型参数(Re:基本类型不能作为对象使用)

### 4、不允许使用instanceof关键字

```

//        if(restrict instanceof Restrict<Double>)

//        if(restrict instanceof Restrict<T>)

```

### 5、在使用泛型时，不管传入什么类型的参数，查询类型始终是泛型类原生类型

```

Restrict<Double> restrict = new Restrict<>();

Restrict<String> restrictString = new Restrict<>();

System.out.println(restrict.getClass() == restrictString.getClass());

System.out.println(restrict.getClass().getName());

System.out.println(restrictString.getClass().getName());

// Resulet

true

*.Restrict

*.Restrict

```

### 6、不能创建参数化类型的数组

```

// 允许声明数组

Restrict<Double>[] restrictArray;

// 不允许

// Restrict<Double>[] restricts = new Restrict<Double>[10];

```

### 7、泛型类不允许作为 Exception/Throwable的派生类

```

//  private class Problem<T> extends Exception;

```

### 8、不能捕获泛型类对象

```

//    public <T extends Throwable> void doWork(T t) {

//        try {

//

//        } catch (T e) {

//            // do something

//        }

//    }

/* 注：虽然不能捕获它，但可以抛出写到throws子句里 */

public <T extends Throwable> void doWork(T t) throws T {

        try {

        } catch (Throwable throwable) {

            throw  t;

        }

    }

```

## 五、泛型类型的继承规则

### 案例说明：类Pair为泛型类，类Worker是类Employee的派生类，以下为Pair类的节选代码

```

    private static <T> void set(Pair<Employee> p){

}

public static void main(String[] args) {

        Pair<Employee> employeePair = new Pair<>();

        Pair<Worker> workerPair = new Pair<>();

        Employee employee = new Worker();

        // Pair<Employee>和Pair<Worker>没有任何继承关系

        // Pair<Employee> employeePair2 = new Pair<Worker>();

        Pair<Employee> pair = new ExtendPair<>();

        set(employeePair);

        // set(workerPair);

}

/*泛型类可以继承或者扩展其他泛型类，比如List和ArrayList*/

    private static class ExtendPair<T> extends Pair<T>{

    }

```

## 六、通配符(类型之间的继承关系不代表泛型参数化使用的继承关系，通配符可以很好地解决此问题)[通配符只能在方法中使用]

### 案例说明：类Fruit派生于类Food,类Apple和类Orange派生于类Fruit,类RedFuji派生于类Apple,类GenericType为泛型类，以下是类WildCard节选代码

```

    public static void print(GenericType<Fruit> p) {

        System.out.println(p.getData().getColor());

    }

    public static void use() {

        GenericType<Fruit> a = new GenericType<>();

        print(a);

        GenericType<Orange> b = new GenericType<>();

        //print(b); 方法print不允许传入对象b

    }

    /* --------------------------- 通配符的引入 --------------------------- */

    public static void print2(GenericType<? extends Fruit> p) {

        System.out.println(p.getData().getColor());

    }

    public static void use2() {

        GenericType<Fruit> a = new GenericType<>();

        print2(a);

        GenericType<Orange> b = new GenericType<>();

        print2(b);

        /** 注：? extends X代表类型的上界，类型参数是X或X的子类 */

        //print2(new GenericType<Food>());

        // 对象c可赋值于a或b，GenericType<? extends Fruit> c = a/b;

        GenericType<? extends Fruit> c = new GenericType<>();

        /* ? extends X 主要用于安全访问数据 */

        Apple apple = new Apple();

        Fruit fruit = new Fruit();

        // 编译器不知道传入是类Fruit或类Fruit的子类

        //c.setData(apple);

        //c.setData(fruit);

        // 调用方法getData()获得的是Fruit类型

        //Apple x = c.getData();

        //Orange x = c.getData();

        Fruit x = c.getData();

    }

    /** ? super X 表示类型的下界，类型参数是X或X的超类，主要用于安全写入数据 */

    public static void printSuper(GenericType<? super Apple> p){

        System.out.println(p.getData());

    }

    public static void useSuper(){

        GenericType<Fruit> fruitGenericType = new GenericType<>();

        GenericType<Apple> appleGenericType = new GenericType<>();

        GenericType<RedFuji> redFujiGenericType = new GenericType<>();

        GenericType<Orange> orangeGenericType = new GenericType<>();

        printSuper(fruitGenericType);

        printSuper(appleGenericType);

        //printSuper(redFujiGenericType); // 类Apple的子类，故报错

        //printSuper(orangeGenericType); // 平级类，跟类Apple没关系

        // 表示GenericType的类型参数的下界是Apple

        GenericType<? super Apple> x = new GenericType<>();

        // 方法setData()编译器不知道传入的确切类型，但传入类Apple或类Apple的子类能安全转型为对象Apple

        x.setData(new Apple());

        x.setData(new HongFuShi());

        //x.setData(new Fruit());



        // 返回一定是Apple的超类，具体哪个超类不知道，唯一确定是类Object是类Apple的超类

        Object data = x.getData();

    }

```

## 七、虚拟机实现泛型方式 --- 类型擦除

### 以类GenericRaw为例

```

public class GenericRaw<T> {

    private T data;

    public T getData() {

        return data;

    }

    public void setData(T data) {

        this.data = data;

    }

    public static void main(String[] args) {

    }

}

在JDK里类型擦除可理解为擦除成Object

public class GenericRaw<Object> {

    private Object data;

    public Object getData() {

        return data;

    }

    public void setData(Object data) {

        this.data = data;

    }

    public static void main(String[] args) {

    }

}

```

# <a name="reflection">反射</a>
## 一、定义
> 在运行时才知道要操作的类是什么，并且可以在运行时获取类的完整构造，并调用对应的方法。

## 二、功能
### 1.在运行时构造任意一个类的对象
### 2.在运行时获取任意一个类所有的成员变量和方法
### 3.在运行时调用任意一个对象的方法（属性）

## 三、类加载器
#### 在JVM中，所有类都通过类加载器加载，标志Class类的唯一性是由类加载器加上Class对象
### 1.系统类加载器
```	
// 1.可以获取，当前这个类TestClassLoader就是它加载的
ClassLoader classLoader = ClassLoader.getSystemClassLoader();
System.out.println(classLoader);

// 2.测试当前类有哪个类加载器进行加载
classLoader = Class.forName("com.example.javaadvanced.reflection.more.ReflectionTest")
                .getClassLoader();
System.out.println(classLoader);

------------ result ------------
sun.misc.Launcher$AppClassLoader@18b4aac2
sun.misc.Launcher$AppClassLoader@18b4aac2
```
### 2.扩展类加载器
```
// 3.获取扩展类加载器，系统类加载器的父类加载器，可以获取
classLoader = classLoader.getParent();
System.out.println(classLoader);

------------ result ------------
sun.misc.Launcher$ExtClassLoader@45ee12a7
```
### 3.引导类加载器
```
// 4.获取引导类加载器，扩展类加载器的父类加载器，不可获取
classLoader = classLoader.getParent();
System.out.println(classLoader);

------------ result ------------
null
```

## 四、Class类
#### 我们写的每一个类都可以看成一个对象，是java.lang.Class类的对象。当写完一个类的java文件，变异成class文件的时候，编译器会将这个类的对应的class对象放在class文件的末尾，保存着类的元数据信息，即构造器、属性、方法、实现的接口等，在java里都有对应的类来表示
```
Class是一个类，封装了当前对象所对应的类的信息

获取Class类的三种方式：
1.通过类名获取，类名.class
Class servantClass = Servant.class;
2.通过对象获取，对象名.getClass()
Class servantClass2 = servant.getClass();
3.通过全类名获取，Class.forName(全类名)
Class servantClass3 = Class.forName("com.example.javaadvanced.reflection.Servant");
```
### 1.构造器Constructor
```
public static void testConstructor() throws Exception {
        String className = "com.example.javaadvanced.reflection.more.Person";
        Class<Person> clz = (Class<Person>) Class.forName(className);

        System.out.println("获取Constructor对象：");
        Constructor<Person>[] constructors = (Constructor<Person>[]) clz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("获取某一个Constructor对象，需参数列表：");
        Constructor<Person> constructor = clz.getConstructor(String.class, int.class);
        System.out.println(constructor);

        /**
         * 初始化对象的三种方法
         * 1、普通初始化
         * 2、获取类的class对象，然后调用newInstance()
         * 3、通过反射获取构造器，再调用构造器#newInstance()创建对象，代码如下
         */
        System.out.println("调用构造器#newInstance()创建对象：");
        Person person = constructor.newInstance("Samuel", 999);
        System.out.println(person.getName() + ", " + person.getAge());
}

------------ result ------------
获取Constructor对象：
public com.example.javaadvanced.reflection.more.Person()
public com.example.javaadvanced.reflection.more.Person(java.lang.String,int)
获取某一个Constructor对象，需参数列表：
public com.example.javaadvanced.reflection.more.Person(java.lang.String,int)
调用构造器#newInstance()创建对象：
Samuel, 999
```
### 2.方法Method
```
public static void testMethod() throws Exception {
        Class clz = Class.forName("com.example.javaadvanced.reflection.more.Person");

        System.out.println(" ");
        System.out.println("获取clz对应类中的所有方法，包括父类的方法，不能获取private方法。");
        Method[] methods = clz.getMethods();
        for (Method method : methods) {
            System.out.print(method.getName() + "() ");
        }
        System.out.println(" ");
        System.out.println("--------------------------------------");

        System.out.println("获取当前类的所有方法");
        methods = clz.getDeclaredMethods();
        for (Method method: methods) {
            System.out.print(method.getName() + "() ");
        }
        System.out.println(" ");
        System.out.println("--------------------------------------");

        System.out.println("获取指定方法，有参需带参数类型和参数列表，无参不需要写");
        Method method = clz.getDeclaredMethod("setName", String.class);
        System.out.println(method);
        System.out.println("--------------------------------------");

        /* Pserson#setAge的形参类型为int，用于反射，获取方法的参数写成int.class;
        * 或把int类型改为Integer*/
        method = clz.getDeclaredMethod("setAge", int.class);
        System.out.println(method);
        System.out.println("--------------------------------------");

        System.out.println("调用方法，第一个参数表示执行哪个对象的方法，剩下的参数是执行方法时需要传入的参数");
        Object object = clz.newInstance();
        method.invoke(object, 999);

        /* 调用私有方法，在调用invoke方法前必须加上setAccessible(true) */
        method = clz.getDeclaredMethod("privateMethod");
        System.out.println(method);
        System.out.println("--------------------------------------");
        System.out.println("调用私有方法");
        method.setAccessible(true);
        method.invoke(object);
    }

------------ result ------------
获取clz对应类中的所有方法，包括父类的方法，不能获取private方法。
getName() setName() getAge() setAge() wait() wait() wait() equals() toString() hashCode() getClass() notify() notifyAll()  
--------------------------------------
获取当前类的所有方法
getName() setName() getAge() privateMethod() setAge()  
--------------------------------------
获取指定方法，有参需带参数类型和参数列表，无参不需要写
public void com.example.javaadvanced.reflection.more.Person.setName(java.lang.String)
--------------------------------------
public void com.example.javaadvanced.reflection.more.Person.setAge(int)
--------------------------------------
调用方法，第一个参数表示执行哪个对象的方法，剩下的参数是执行方法时需要传入的参数
set someone's age 
private void com.example.javaadvanced.reflection.more.Person.privateMethod()
--------------------------------------
调用私有方法
a private method
```
### 3.域Field
```
public static void testField() throws Exception {
        Class clz = Class.forName("com.example.javaadvanced.reflection.more.Person");

        System.out.println(" ");
        System.out.println("获取当前类的所有字段");
        Field[] fields = clz.getDeclaredFields();
        for (Field field: fields) {
            System.out.print(field.getName() + " ");
        }
        System.out.println();
        System.out.println("---------------------------");

        System.out.println("获取指定字段");
        Field field = clz.getDeclaredField("name");
        System.out.println(field.getName());

        Person person = (Person) clz.getConstructor(String.class, int.class).newInstance("Cris", 888);
        System.out.println("获取指定字段的值");
        Object object = field.get(person);
        System.out.println(field.getName() + " = " + object);

        System.out.println("获取私有字段，须先调用setAccessible(true)");
        field = clz.getDeclaredField("age");
        field.setAccessible(true);
        object = field.get(person);
        System.out.println(field.getName() + " = " + object);
    }

------------ result ------------
获取当前类的所有字段
name age 
---------------------------
获取指定字段
name
获取指定字段的值
name = Cris
获取私有字段，须先调用setAccessible(true)
age = 888
```
