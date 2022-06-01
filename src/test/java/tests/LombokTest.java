package tests;

import lombok.Cleanup;
import lombok.extern.java.Log;
import lombok.val;
import lombok.var;
import models.*;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;

@Log
public class LombokTest {

    @Test
    public void valTest() {
        val list = new ArrayList<String>(); // Transfer to final variable
        list.add("Test Value");
        System.out.println(list.get(0));
    }

    @Test
    public void varTest() {
        var list = new ArrayList<String>(); // Transfer to not final variable
        list.add("Test Value");
        System.out.println(list.get(0));
    }

    @Test
    public void сleanUpTest() throws IOException {
        @Cleanup InputStream in = new FileInputStream("src/test/resources/text.txt");
        @Cleanup OutputStream out = new FileOutputStream("src/test/resources/text1.txt");
        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
    }

    @Test
    public void getterAndSetterTest() {
        Person person = new Person();
        person.setAge(23);
        System.out.println(person.getAge());
    }

    @Test
    public void getterAndSetterTest1() {
        Person1 person = new Person1();
        person.setAge(23);
        person.setName("Alex");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.toString());
    }

    @Test
    public void getterAndSetterTest2() {
        Person1 person = new Person1();
        person.setAge(23);
        person.setName("Alex");

        Person1 person1 = new Person1();
        person1.setAge(23);
        person1.setName("Alex");

        System.out.println(person.toString());
        System.out.println(person1.toString());
        System.out.println(person.equals(person1));
        System.out.println(person.hashCode());
    }

    @Test
    public void getterAndSetterTest3() {
        Person1 person = new Person1();
        person.setAge(23);
        person.setName("Alex");

        Person1 person1 = new Person1(23, "Alex");

        System.out.println(person.toString());
        System.out.println(person1.toString());
        System.out.println(person.equals(person1));
        System.out.println(person.hashCode());
    }

    @Test
    public void getterAndSetterTest4() {
        Person2 person = new Person2();
        person.setAge(23);
        person.setName("Alex");

        Person2 person1 = new Person2(23, "Alex", "Trostyanko");

        Person2 person2 = new Person2("Trostyanko");

        System.out.println(person.toString());
        System.out.println(person1.toString());
        System.out.println(person2.toString());
    }

    @Test
    public void getterAndSetterTest5() {
        Person3 person = new Person3();
        person.setAge(23);
        person.setName("Alex");

        Person3 person1 = new Person3("Alex");

        System.out.println(person.toString());
        System.out.println(person1.toString());
    }

    @Test
    public void builderTest() {
        PersonBuilder person = PersonBuilder.builder()
                .name("Alex")
                .age(44)
                .surname("Trostyanko")
                .build();

        System.out.println(person.toString());
    }

    @Test
    public void builderTest1() {
        PersonBuilder person = PersonBuilder.builder()
                .name("Alex")
                .age(44)
                .surname("Trostyanko")
                .UUID(1)
                .build();

        PersonBuilder person1 = PersonBuilder.builder()
                .name("Alex")
                .age(44)
                .surname("Trostyanko")
                .UUID(2)
                .build();

        log.severe(person.toString());
        log.severe(person1.toString());
    }
}