import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.hamcrest.MatcherAssert;
import page.MainPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)

public class MainPageFaqTest extends BaseUITests{

    //номер вопроса
    private final int numberOfElement;

    //ожидаемый текст вопроса
    private final String expectedQuestionText;

    //ожидаемый текст ответа
    private final String expectedAnswerText;

    //к-р
    public MainPageFaqTest(int numberOfElement, String expectedQuestionText, String expectedAnswerText) {
        this.numberOfElement = numberOfElement;
        this.expectedQuestionText = expectedQuestionText;
        this.expectedAnswerText = expectedAnswerText;
    }

    @Parameterized.Parameters()
    public static Object[][] setTestData() {
        return new Object[][] {
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области." },
        };
    }


    @Test
    public void checkAccordionIsCorrect() throws InterruptedException {
        MainPage mainPage = new MainPage(this.webDriver);
        Thread.sleep(3000);
        mainPage.clickOnCookieAcceptButton();
        mainPage.clickOnQuestion(this.numberOfElement);
        mainPage.waitForLoadAnswer(this.numberOfElement);

        if (mainPage.isAnswerDisplayed(this.numberOfElement)) {
            MatcherAssert.assertThat("Не совпадение в вопросе №" + this.numberOfElement,
                    this.expectedQuestionText,
                    equalTo(mainPage.getQuestionText(this.numberOfElement))
            );
            MatcherAssert.assertThat("Не совпадение в ответе №" + this.numberOfElement,
                    this.expectedAnswerText,
                    equalTo(mainPage.getAnswerText(this.numberOfElement))
            );
        }
        else {
            fail("Не совпадение в вопросе №" + this.numberOfElement);
        }
    }
}

