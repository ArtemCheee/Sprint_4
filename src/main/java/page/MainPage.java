package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    //писание страницы
    private final WebDriver webDriver;

    private final By faqQuestion = By.className("accordion__heading");

    private final By faqAnswer = By.xpath(".//div[@class='accordion__panel']/p");

    private final By cookieAcceptButton = By.id("rcc-confirm-button");

    private final By orderButtonHeader = By.xpath(".//div[starts-with(@class, 'Header_Nav')]//button[starts-with(@class, 'Button_Button')]");

    private final By orderButtonBody = By.xpath(".//div[starts-with(@class, 'Home_RoadMap')]//button[starts-with(@class, 'Button_Button')]");

    //к-р MainPage
    public MainPage(WebDriver driver) {
        this.webDriver = driver;
    }


    //ожидание загрузки faq
    public void waitForLoadAnswer(int index) {
        new WebDriverWait(this.webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(this.webDriver.findElements(this.faqAnswer).get(index)));
    }

    //клик на вопрос
    public void clickOnQuestion(int index) {
        this.webDriver.findElements(this.faqQuestion).get(index).click();
    }

    //получить вопрос
    public String getQuestionText(int index) {
        return this.webDriver.findElements(this.faqQuestion).get(index).getText();
    }

    //проверка раскрытия ответа
    public boolean isAnswerDisplayed(int index) {
        return this.webDriver.findElements(this.faqAnswer).get(index).isDisplayed();
    }

    //получить ответ
    public String getAnswerText(int index) {

        return this.webDriver.findElements(this.faqAnswer).get(index).getText();
    }

    //клик куки
    public void clickOnCookieAcceptButton() {

        this.webDriver.findElement(this.cookieAcceptButton).click();
    }
    //клик по верхней кнопке заказа
    public void clickOrderButtonHeader() {

        this.webDriver.findElement(this.orderButtonHeader).click();
    }

    // Клик по нижней кнопке заказа
    public void clickOrderButtonBody() {
        this.webDriver.findElement(this.orderButtonBody).click();
    }
}