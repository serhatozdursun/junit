import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(0)
public class Junit5 extends Junit5Base {

    @Order(10)
    @ParameterizedTest
    @ValueSource(strings = {"kullanıcı 1", "kullanıcı 2", "kullanıcı 3", "kullanıcı 4"})
    public void test1(String param) {
        System.out.println(param + " kullanıcı login oldu");
    }


    String getUserName() {
        return "Kullanıcı 1<br>";
    }

    @Test
    @Order(8)
    void assertEqualsTest() {
        String userName = getUserName().trim().replaceAll("<br>", "");
        Assertions.assertEquals("Kullanıcı 1", userName, "Kullanıcı adı beklenen değer değil");
    }

    @Test
    @Order(9)
    public void assertNotEqualsTest() {
        Assertions.assertNotEquals(1, 2, "Değerler eşit");
    }

    @Test
    @Order(7)
    public void assertArraysEquals() {
        String[] array1 = {"Testinium", "Test", "QA"};
        String[] array2 = {"Testinium", "QA", "Test"};

        Arrays.sort(array1);
        Arrays.sort(array2);

        Assertions.assertArrayEquals(array1, array2, "Array eşit değil");
        System.out.println("Array karşılaştırma başarılı");
    }

    @Test
    @Order(5)
    void assertArraysNotEquals() {
        String[] array1 = {"Testinium", "Test", "QA"};
        String[] array2 = {"Testinium", "Test", "Qa"};

        Assertions.assertFalse(Arrays.equals(array1, array2), "Arrayler eşit olmamalı");
        System.out.println("Arrayler eşit değil");
    }

    @Test
    @Order(6)
    void assertListEquals() {
        List<Integer> intList1 = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};

        List<Integer> intList2 = new ArrayList<Integer>() {{
            add(2);
            add(1);
            add(3);
        }};

        Collections.sort(intList2);
        Collections.sort(intList1);

        Assertions.assertEquals(intList2, intList1, "Listeler eşit değil");
        System.out.println("List karşılaştırma başarılı");
    }

    @Test
    @Order(4)
    void assertListNotEquals() {
        List<Integer> intList1 = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};

        List<Integer> intList2 = new ArrayList<Integer>() {{
            add(2);
            add(1);
            add(5);
        }};

        Collections.sort(intList2);
        Collections.sort(intList1);

        Assertions.assertNotEquals(intList2, intList1, "Listeler eşit");
        System.out.println("List karşılaştırma başarılı");
    }

    @Test
    @Order(3)
    void assertNotNullTest() {
        String a = "";
        Assertions.assertNotNull(a, "Değer null değil");
    }

    @Test
    @Order(2)
    void assertNullTest() {
        String a = null;
        Assertions.assertNull(a, "Değer null");
    }

    @Test
    @Order(1)
    void assertTrue() {
        int a = 11;
        Assertions.assertTrue(a > 0 && a == 11, "a sıfırdan büyük ve 11 eşit olmalı");
    }

    @Test
    @Order(0)
    void assertFalse() {
        int a = 12;
        Assertions.assertFalse(a > 0 && a == 11, "a sıfırdan büyük ve 11 eşit olmamalı");
    }

}
