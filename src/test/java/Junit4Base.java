import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junit4Base {

    public WebDriver driver;

    /**
     * Tüm testlerden önce ve before class tan önce bir kez çalışır
     */
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Testler başladı");
    }

    /**
     * Her testen önce çalışır.
     */
    @Before
    public void before() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://www.hepsiburada.com/");
    }

    /**
     * Her testen sonra çalışır
     */
    @After
    public void after() {

//        if (driver != null) {
//            driver.close();
//            driver.quit();
//        }
    }

    /**
     * Tüm testlerden ve after classtan sonra bir kez çalışır.
     */
    @AfterClass
    public static void afterClass() {
        System.out.println("Testler bitt");
    }
}
