import org.junit.Test;

import page.MainPage;
import page.OrderPage;


public class LowerOrderPositiveTest extends BaseUITests {

    private MainPage mainPage;
    private OrderPage orderPage;
    private final String expectedSuccessText = "Для кого самокат";




@Test

public void lowerOrderButtonOpensForm() {
    MainPage mainPage = new MainPage(this.webDriver);
    OrderPage orderPage = new OrderPage(this.webDriver);

    mainPage.clickOnCookieAcceptButton();
    mainPage.clickOrderButtonBody();

    String actualHeaderText = orderPage.getOrderHeaderText();
    assert actualHeaderText.contains(expectedSuccessText)
            : "Ожидался заголовок '" + expectedSuccessText + "', но получили '" + actualHeaderText + "'";

}

}
