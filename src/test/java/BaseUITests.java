import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseUITests {

    protected WebDriver webDriver;
    private final static String MAIN_PAGE = "https://qa-scooter.praktikum-services.ru";
    @Before
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
        this.webDriver.get(this.MAIN_PAGE);
    }
    @After

    public void tearDown(){

        webDriver.quit();
    }

}
