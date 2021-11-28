import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Junit4 extends Junit4Base {


    @Test
    public void assertEquals() {
        Assert.assertEquals("Değerler eşitdeğil", 1, 1);
        System.out.println("pass");
    }

    @Test
    public void assertNotEquals() {
        Assert.assertNotEquals("Değerler eşit", 1, 2);
        System.out.println("pass");
    }

    @Test
    public void arrayEquals() {

        String[] array1 = {"Testinium", "Test", "QA"};
        String[] array2 = {"Testinium", "QA", "Test"};

        Arrays.sort(array1);
        Arrays.sort(array2);
        Assert.assertArrayEquals(array1, array2);

        System.out.println("Array karşılaştırma başarılı");
    }

    @Test
    public void arrayNotEquals() {

        String[] array1 = {"Testinium", "Test", "QA"};
        String[] array2 = {"Testinium", "Qa", "Test"};
        Arrays.sort(array1);
        Arrays.sort(array2);

        Assert.assertFalse(Arrays.equals(array1, array2));
        System.out.println("Array karşılaştırma başarılı");
    }

    @Test
    public void assertListEquals() {

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

        Assert.assertEquals("Bu fail oldu", intList2, intList1);
        System.out.println("List karşılaştırma başarılı");
    }

    @Test
    public void assertListNotEquals() {

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

        Assert.assertNotEquals("Bu fail oldu", intList2, intList1);
        System.out.println("List karşılaştırma başarılı");
    }

    @Test
    public void assertTrue() {
        int a = 11;
        Assert.assertTrue("a bire eşit değil veya ondan büyük değil", a == 1 || a > 10);
    }

    @Test
    public void assertFalse() {
        int a = 11;
        Assert.assertFalse("a bire eşit veya ondan büyük", a == 1 && a > 10);
    }

    @Test
    public void assertNull() {
        String a = null;
        Assert.assertNull("Değer null değil", a);
    }

    @Test
    public void assertNotNull() {
        // empty ile null'u karıştırmayalım
        String a = "";
        Assert.assertNotNull("Değer null", a);
    }

    @Test
    @Ignore
    public void test2() {
        System.out.println("Test 2");
    }

}
