package main.test;


import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import static java.lang.Math.sqrt;

public class Java1_8 {
    private static int test_num = 1;

    public static void main(String[] args) {
        Java1_8 j = new Java1_8();
//        j.Function_Java_1_8();
//        j.stream_1_8();
          j.stream_1();
          j.stream_2();
    }

    void Stream_1() {
        List<String> names = Arrays.asList("peter", "lily", "lucy");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
    }

    void Function_Java_1_8() {
        //函数式编程第一种
       /* Convert<Integer,String> converter=(from) -> String.valueOf(from);
        String a=converter.convert(895);
        System.out.println(a);
        //函数式编程第二种
        Convert<String,Integer> c=Integer::valueOf;
        int b=c.convert("123");
        System.out.println(b);
        //函数式编程第三种
        Something something=new Something();
        Convert<String,String> c1=something::startWith;
        String c1_r=c1.convert("java");
        System.out.println(c1_r);
        //函数编程第四种
        PersonFactory<Person> p1=Person::new;
        Person person=p1.create("peter","Davi");*/
        //函数编程第五种
        int num = 0;
        Convert<Integer, String> stringConverter =
                (from) -> {
                    test_num = test_num + 1;
                    return String.valueOf(from + test_num);
                };
        String qq = stringConverter.convert(2);
        System.out.println(test_num);
        System.out.println(qq);
        //----
        Formula formula = (a) -> sqrt(a * 100) + 1;
        System.out.println(formula.add(100));
        System.out.println(formula.sqrt(100));
        //
        Predicate<String> predicate = (s) -> s.length() > 0;
        boolean f01 = predicate.test("foo");
        boolean f = predicate.negate().test("gg");
        System.out.println(f + "  " + f01);
        Your<String> y = (s) -> {
            System.out.println("test:" + s);
            return s;
        };
        y.negate(y);
    }

    void Stream_1_Java_1_8() {
        List<String> names = Arrays.asList("peter", "lily", "lucy");
        /**
         * lambda的第一种
         */
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        /**
         * lambda的第二种
         */
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        /**
         * lambda的第三种
         */
        Collections.sort(names, (a, b) -> b.compareTo(a));
    }

    void stream_1_8() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        stringCollection.stream()
                .sorted()
                .map(String::toUpperCase)//map是每个元素都是独立的，对每个元素都执行map中的函数
                .forEach(System.out::println);
        boolean anyMatchA = stringCollection.stream().noneMatch((s) -> s.startsWith("a"));
        long anyMatchB = stringCollection.stream().filter((s) -> s.startsWith("a")).count();
        Optional<String> reduced = stringCollection.stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);//reduce是每个函数连起来
        System.out.println(anyMatchB);
        reduced.ifPresent(System.out::println);
    }

    void stream_1() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }
    void stream_2(){
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        long t0 = System.nanoTime();

        long count = values.parallelStream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }
}
interface Formula{
     double add(int a);
     default double sqrt(int b){
         return Math.sqrt(b);
     }
}
@FunctionalInterface
interface Convert<F,T>{
    T convert(F from);
}
class Something{
    String startWith(String s){
        return String.valueOf(s.charAt(0));
    }
}
class Person{
    String firstName;
    String lastName;
    Person(){}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
interface PersonFactory<P extends Person>{
    P create(String firstName,String lastName);
}
@FunctionalInterface
interface Your<T>{
    String test(T t);
    default  Your<T> negate(Your<? extends T> other){
        Objects.requireNonNull(other);
        return (s)->test(s)+" hello";
    }
}