import org.junit.Test;
import page.MainPage;
import page.OrderPage;

import static org.junit.Assert.assertEquals;


public class LowerOrderPositiveTest extends BaseUITests {

    private final String expectedSuccessText = "Для кого самокат";




@Test

public void lowerOrderButtonOpensForm() {
    MainPage mainPage = new MainPage(this.webDriver);
    OrderPage orderPage = new OrderPage(this.webDriver);

    mainPage.clickOnCookieAcceptButton();
    mainPage.clickOrderButtonBody();

    String actualHeaderText = orderPage.getOrderHeaderText();

    assertEquals("Заголовок формы не соответствует ожидаемому", expectedSuccessText, actualHeaderText);
}

}

