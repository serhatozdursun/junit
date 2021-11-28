import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junit5Base {

    public static WebDriver driver;
    /**
     * Tüm testlerden ve beforeEach classından önce sadece bir kez çalışır
     */
    @BeforeAll
    public static void beforeAll() {
        System.out.println("BeforeAll Metodu Çalıştı");
    }

    /**
     * Her testen önce çalışır
     */
    @BeforeEach
    public void beforeEach() {
        System.out.println("BeforeEach Metodu Çalıştı");
    }

    /**
     * Her testen sonra çalışır
     */
    @AfterEach
    public void afterEach() {
        System.out.println("AfterEach Metodu Çalıştı");
    }

    /**
     * Tüm testlerden ve afterEach ten sonra bir kez çalışır.
     */
    @AfterAll
    public static void afterAll() {
        System.out.println("After Metodu Çalıştı");
    }
}
