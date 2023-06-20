package ru.praktikum.scooter.pageobject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;

public class PageAboutRent {

    public PageAboutRent(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    private WebDriver webDriver;

    //Локатор для поля "Когда привезти самокат"
    public By fieldDeliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Локатор для даты из календаря
    public By deliveryDate = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--026']");

    //Локатор для поля "Срок аренды"
    private final By fieldRentalPeriod = By.xpath(".//div[(contains(@class, 'Dropdown-control') and div[text()='* Срок аренды'])]");

    //Локатор для выбора срока аренды из выпадающего списка
    private final By rentalPeriod = By.xpath(".//div[contains(@class, 'Dropdown-option') and text()='трое суток']");

    //Локатор для включения чекбокса "Серая безысходность"
    private final By checkboxGrey = By.xpath(".//input[@id='grey' and @type='checkbox']");

    //Локатор для поля "Комментарий для курьера"
    private final By fieldComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Локатор для кнопки "Заказать"
    private By buttonOrderOnPageAboutRent = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //Локатор для кнопки "Да" в окне подтверждения заказа
    private By buttonYesOnModal = By.xpath(".//button[text()='Да']");

    //Локатор окна "Заказ оформлен"
    private By orderStatusModal = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");


    //Метод для заполнения поля "Когда привезти самокат"
    public void fillFieldDeliveryDate() {
        webDriver.findElement(fieldDeliveryDate).click();
        webDriver.findElement(deliveryDate).click();
    }

    //Метод для заполнения поля "Срок аренды"
    public void fillFieldRentalPeriod() {
        webDriver.findElement(fieldRentalPeriod).click();
        webDriver.findElement(rentalPeriod).click();
    }

    //Метод для включения чекбокса "Серая безысходность"
    public void clickCheckboxGrey() {
        webDriver.findElement(checkboxGrey).click();
    }

    //Метод для заполнения поля "Комментарий для курьера"
    public void fillFieldComment(String comment) {
        webDriver.findElement(fieldComment).sendKeys(comment);
    }

    //Метод для клика по кнопке "Заказать" на странице "Про аренду"
    public void clickButtonOrderOnPageAboutRent() {
        webDriver.findElement(buttonOrderOnPageAboutRent).click();
    }

    //Метод для клика по кнопке подтверждения заказа
    public void clickButtonYesOnModal() {
        webDriver.findElement(buttonYesOnModal).click();
    }

    //Метод для заполнения формы "Про аренду"
    public void fillPageAboutRent (String comment) {
        fillFieldDeliveryDate();
        fillFieldRentalPeriod();
        clickCheckboxGrey();
        fillFieldComment(comment);
        clickButtonOrderOnPageAboutRent();
        clickButtonYesOnModal();
     }

    //Метод для проверки открытия окна "Заказ оформлен"
    public void checkOrderStatus (String expectedStatus) {
        MatcherAssert.assertThat(webDriver.findElement(orderStatusModal).getText(), containsString(expectedStatus));
    }
}
