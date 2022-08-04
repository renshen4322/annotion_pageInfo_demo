package com.dn.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class Java8StreamTest_去重 {
    public static class Book{

        private String id;

        private String name;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        private Integer age;

        public Book(String id, String name,Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void testUnique(){
        List<Book> books = Lists.newArrayList(new Book("1","1",18),new Book("2","2",20),new Book("3","3",23),new Book("2","2",30));

        books.stream().forEach(c->{
            System.out.println(c.id+": "+c.name+": "+c.age);
        });

        //使用TreeSet去重
        List<Book> unique1 = books.stream().collect(
                collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getId()))),
                        ArrayList::new));

        System.out.println("使用TreeSet去重==="+unique1);

        //使用map去重
        List<Book> unique2 = books.stream()
                .filter(distinctByKey(o -> o.getId()))
                .collect(Collectors.toList());
        System.out.println(unique2);

    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        System.out.println("这个函数将应用到每一个item");
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
