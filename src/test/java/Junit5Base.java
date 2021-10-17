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
    }

    /**
     * Her testen önce çalışır
     */
    @BeforeEach
    public void beforeEach() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://www.hepsiburada.com/");
    }

    /**
     * Her testen sonra çalışır
     */
    @AfterEach
    public void afterEach() {

//        if (driver != null) {
//            driver.close();
//            driver.quit();
//        }
    }

    /**
     * Tüm testlerden ve afterEach ten sonra bir kez çalışır.
     */
    @AfterAll
    public static void afterAll() {
    }
}
