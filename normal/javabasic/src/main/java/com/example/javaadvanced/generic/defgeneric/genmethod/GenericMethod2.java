package com.example.javaadvanced.generic.defgeneric.genmethod;

public class GenericMethod2 {

    public class Generic<T> {
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        // 虽然在方法中使用了泛型，但并不是一个泛型方法
        // 这只是类中一个普通的成员方法，只不过返回值是在声明泛型类已经声明过的泛型
        // 所以在这个方法中才可以继续使用T这个泛型
        public T getKey() {
            return key;
        }

        /**
         * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
         * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
         */
//        public E setKey(E key) {
////            this.key = key;
////        }

        /**
         * 这才是一个真正的泛型方法。
         * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
         * 这个T可以出现在这个泛型方法的任意位置.
         * 泛型的数量也可以为任意多个
         *    如：public <T,K> K showKeyName(Generic<T> container){
         *        ...
         *        }
         */

        // 这也不是一个泛型方法，这就是一个普通的方法，
        // 只是使用了Generic<Number>这个泛型类做形参而已。
        public void show(Generic<Number> num) {

        }
    }

//    public void show(T data) {
//
//    }
}
