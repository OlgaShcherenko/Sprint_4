import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.scooter.pageobject.MainPage;
import ru.praktikum.scooter.pageobject.PageAboutCustomer;
import ru.praktikum.scooter.pageobject.PageAboutRent;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest{
    private String buttonPlace;
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phoneNumber;
    private String comment;

    public OrderTest(String buttonPlace, String firstName, String lastName, String address, String metroStation, String phoneNumber, String comment){
        this.buttonPlace=buttonPlace;
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.metroStation=metroStation;
        this.phoneNumber=phoneNumber;
        this.comment=comment;
    }

    @Parameterized.Parameters
    public static Object[][] orderData() {
        return new Object[][]{
                {"header", "Иван", "Петров", "Гагарина, 1", "Сокольники", "89025512333", "Привет"},
                {"body", "Андрей", "Сидоров", "Ленина, 2", "Черкизовская", "89991122333", "Добрый день"},
        };
    }

    @Test
    public void checkOrderCreationSuccess(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickCookiesApprove();
        mainPage.chooseOrderButton(buttonPlace);
        PageAboutCustomer pageAboutCustomer = new PageAboutCustomer(webDriver);
        pageAboutCustomer.fillPageAboutCustomer(firstName, lastName, address, metroStation, phoneNumber);
        PageAboutRent pageAboutRent = new PageAboutRent(webDriver);
        pageAboutRent.fillPageAboutRent(comment);
        pageAboutRent.checkOrderStatus("Заказ оформлен");
    }
}
