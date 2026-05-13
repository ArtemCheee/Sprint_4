
import page.MainPage;
import page.OrderPage;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)

public class UpperOrderPositiveTest extends BaseUITests {

    // Переменные для параметров теста - данных для оформления заказа
    private final String name, surname, address, metro, phone, date, term, color, comment;

    // Сообщение об успешном оформлении заказа
    private final String expectedOrderSuccessText = "Заказ оформлен";


    //К-р класса OrderPositiveTest

    public UpperOrderPositiveTest(
            String name,
            String surname,
            String address,
            String metro,
            String phone,
            String date,
            String term,
            String color,
            String comment
    ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.term = term;
        this.color = color;
        this.comment = comment;
    }


    @Parameterized.Parameters(name = "Оформление заказа. Позитивный сценарий. Пользователь: {0} {1}")
    public static Object[][] setDataForOrder() {
        return new Object[][] {
                {"Петр", "Петров", "фывфывфывфывфыв", "Ростокино", "+78889991122", "13.05.2026", "двое суток", "серая безысходность", "123123"},
                {"Иван ", "Иванов", "фывфывфывфывфыв", "Ростокино", "+71112223344", "13.05.2026", "трое суток", "чёрный жемчуг", "456456"},
        };
    }


    //Проверка верхней кнопки

    @Test
    public void orderWithHeaderButtonWhenSuccess() {
        MainPage mainPage = new MainPage(this.webDriver);
        OrderPage orderPage = new OrderPage(this.webDriver);

        mainPage.clickOnCookieAcceptButton();
        mainPage.clickOrderButtonHeader();
        orderPage.waitForLoadForm();
        orderPage.setName(this.name);
        orderPage.setSurname(this.surname);
        orderPage.setAddress(this.address);
        orderPage.setMetro(this.metro);
        orderPage.setPhone(this.phone);
        orderPage.clickNextButton();


        orderPage.setDate(this.date);
        orderPage.setTerm(this.term);
        orderPage.setColor(this.color);
        orderPage.setComment(this.comment);
        orderPage.makeOrder();

        MatcherAssert.assertThat(
                "Не создается заказ",
                orderPage.getNewOrderSuccessMessage(),
                containsString(this.expectedOrderSuccessText)
        );
    }
}
