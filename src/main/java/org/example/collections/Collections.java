package org.example.collections;

import org.example.collections.model.Person;
import org.example.collections.model.Rector;
import org.example.collections.model.Student;
import org.example.collections.model.Teacher;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
//        arrayDemo();
//        collectionDemo();
//        arrayListDemo();
//        linkedListDemo();
//        collectionObjectDemo();
//        queueDemo();
//        setDemo();
//        mapDemo();
    }

    private static void arrayDemo() {
        //        int, float, double, boolean, char - primitives
        int[] arr = {1, 3, 5, 7};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void collectionDemo() {
        ArrayList integers = new ArrayList<>();
        integers.add(4);
        integers.add("sdnashbd");
        integers.add(2.4);
        System.out.println(integers);
    }

    private static void arrayListDemo() {
        System.out.println("Array list");
        ArrayList<Integer> integers = new ArrayList<>();
        fillList(integers);
//        for (Integer value : integers) {
//            System.out.println(value);
//        }

//        System.out.println(integers.get(0));
//        integers.set(0, 55);
//        System.out.println(integers.get(0));
//        integers.remove(0);
//        System.out.println(integers.get(0));
        System.out.println("---------------------");
        System.out.println(integers.size());
        System.out.println(integers.isEmpty());
        integers.clear();
        System.out.println("---------------------");
        System.out.println(integers.size());
        System.out.println(integers.isEmpty());
    }

    private static void linkedListDemo() {
        LinkedList<Integer> integers = new LinkedList<>();
        fillList(integers);
        integers.addFirst(0);
        integers.addLast(0);
        for (Integer i : integers) {
            System.out.println(i);
        }

        Integer first = integers.pollFirst();
        integers.pollLast();
        integers.pollLast();
        integers.pollLast();

        System.out.println("first element: " + first);
        for (Integer i : integers) {
            System.out.println(i);
        }
    }

    private static void collectionObjectDemo() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Student());
        people.add(new Teacher());
        people.add(new Student());
        people.add(new Rector());
        for (Person per : people) {
            per.greeting();
        }
    }

    private static void setDemo() {
        List<Integer> integerList = new ArrayList<>();
        Set<Integer> integerSet = new HashSet<>();

        fillList(integerList);
        fillList(integerSet);
        System.out.println(integerList);
        System.out.println("-----");
        System.out.println(integerSet);
    }

    private static void queueDemo() {
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
        PriorityQueue<Integer> integerQueueWithComparator = new PriorityQueue<>((Integer c1, Integer c2) -> Integer.compare(c2,c1));

        integerQueueWithComparator.add(3);
        integerQueue.add(3);

        integerQueueWithComparator.add(2);
        integerQueue.add(2);

        integerQueueWithComparator.add(1);
        integerQueue.add(1);

        System.out.println(integerQueue);
        System.out.println(integerQueueWithComparator);

        System.out.println(integerQueue.poll() + " " + integerQueueWithComparator.poll());
        System.out.println(integerQueue.poll() + " " + integerQueueWithComparator.poll());
        System.out.println(integerQueue.poll() + " " + integerQueueWithComparator.poll());
    }

    private static void mapDemo() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "January");
        map.put(2, "February");
        map.put(3, "March");
        map.put(4, "April");
        System.out.println(map);

        System.out.println(map.get(5));
        System.out.println(map.get(1));

        map.putIfAbsent(4, "May");
        System.out.println(map);
        System.out.println("----------------------");
        map.putIfAbsent(5, "May");
        System.out.println(map);

        System.out.println("----------------------");
        System.out.println(map.containsValue("June"));
        System.out.println(map.containsValue("March"));
    }


    private static void fillList(Collection<Integer> integers) {
        integers.add(1);
        integers.add(1);
        integers.add(2);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(5);
        integers.add(5);
        integers.add(5);
    }
}