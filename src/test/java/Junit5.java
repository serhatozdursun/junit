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

     /*
    Buradan aşağısı browser üzerinden yaptığımız örnekler. Yukarıdaki testlerin hızlı çalışması için tarayıcı ayağa kaldıran
    kodları yorum satırına alıp kapattım bu sebepten aşağaıdaki kısımların çalışması için JunitBase sınıftaki yorum satırına
    alınmış kodları açmanız gerekmekte.
     */

    @Test
    public void lgnButtonTextCheck() {
        String loginBtnText = driver.findElement(By.cssSelector(".sf-OldMyAccount-PhY-T")).getText();
        Assert.assertEquals("Giriş Yap", loginBtnText);

    }

    @Test
    public void lgnBtnIsEnabled() {
        WebElement lgnBtn = driver.findElement(By.id("myAccount"));
        Assert.assertTrue(lgnBtn.isEnabled());
    }

    @Test
    public void assertRegisterButtonDisabled() throws InterruptedException {
        driver.findElement(By.id("myAccount")).click();
        driver.findElement(By.id("login")).click();
        new WebDriverWait(driver, 15).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Üye ol')]"))
        ).click();
        WebElement registerBtn = driver.findElement(By.id("btnSignUpSubmit"));
        /*
        Yukarıdaki kısımlara takılmayın selenium eğitiminde size bu kısımlar anlatılacak.
        Burada asıl önemli nokta üye ol butonunu aktif olmadığını doğruluyoruz.
        isEnabled() methodu eğer buton aktifse true dönüyor, o biz fals olmasını beklediğimiz için
        assertFalse assertionı kullandık.
        */
        Assert.assertFalse(registerBtn.isEnabled());
    }

    @Test
    public void assertSearchButton() {
        String isEnabledBefore = driver.findElement(By.cssSelector(".desktopOldAutosuggestTheme-input")).getAttribute("value");
        driver.findElement(By.cssSelector(".desktopOldAutosuggestTheme-input")).sendKeys("iphone");
        String isEnabledAfter = driver.findElement(By.cssSelector(".desktopOldAutosuggestTheme-input")).getAttribute("value");
        /*
        Burda bir elementin o elemente yeni bir value atamadan önceki value bilgisini çektik daha sonra o elemente yeni bir velue
        tanımlayıp değeri tekrar çektik. Sonuç olarak önceki ve sonraki değerlerin birbirinden farklı olmasını beklediğimiz için
        assertNotEquals assertionı kullandık. Daha sonra elementteki değerin bizim gönderdiğimiz değerle aynı olup olmadığını doğruladık.
         */
        Assert.assertNotEquals(isEnabledAfter, isEnabledBefore);
        Assert.assertEquals("iphone", isEnabledAfter);
    }


}
