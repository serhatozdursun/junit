import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;


public class Junit4Base {

    public WebDriver driver;

    /**
     * Tüm testlerden önce ve before class tan önce bir kez çalışır
     */
    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeClass Metodu Çalıştı");
    }

    /**
     * Her testen önce çalışır.
     */
    @Before
    public void before() {
        System.out.println("Before Metodu Çalıştı ");
    }

    /**
     * Her testen sonra çalışır
     */
    @After
    public void after() {
        System.out.println("After Metodu Çalıştı");
    }

    /**
     * Tüm testlerden ve after classtan sonra bir kez çalışır.
     */
    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass Metodu Çalıştı");
    }
}
