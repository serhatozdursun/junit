import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Junit4 extends Junit4Base {


    @Test
    public void assertEquals() {
        Assert.assertNotEquals("Değerler eşitdeğil", 1, 1);
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
