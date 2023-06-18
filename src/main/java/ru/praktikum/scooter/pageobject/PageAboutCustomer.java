package ru.praktikum.scooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PageAboutCustomer {

    public PageAboutCustomer (WebDriver webDriver){
        this.webDriver=webDriver;
    }

    private WebDriver webDriver;

    //Локатор для поля "Имя"
    private By fieldFirstName = By.xpath(".//input[@placeholder='* Имя']");

    //Локатор для поля "Фамилия"
    private By fieldLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    //Локатор для поля "Адрес"
    private By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Локатор для поля "Станция метро"
    private By fieldMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    //Локатор для поля "Телефон"
    private By fieldPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Локатор для кнопки "Далее"
    private By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Метод для заполнения поля "Имя"
    public void fillFieldFirstName(String firstName) {
        webDriver.findElement(fieldFirstName).sendKeys(firstName);
    }

    //Метод для заполнения поля "Фамилия"
    public void fillFieldLastName(String lastName) {
        webDriver.findElement(fieldLastName).sendKeys(lastName);
    }

    //Метод для заполнения поля "Адрес"
    public void fillFieldAddress(String address) {
        webDriver.findElement(fieldAddress).sendKeys(address);
    }

    //Метод для заполнения поля "Станция метро"
    public void fillFieldMetroStation(String metroStation) {
        webDriver.findElement(fieldMetroStation).sendKeys(metroStation, Keys.ARROW_DOWN, Keys.ENTER);
    }

    //Метод для заполнения поля "Телефон"
    public void fillFieldPhoneNumber(String phoneNumber) {
        webDriver.findElement(fieldPhoneNumber).sendKeys(phoneNumber);
    }

    //Метод для клика по кнопке "Далее"
    public void clickButtonNext() {
        webDriver.findElement(buttonNext).click();
    }

    //"Метод для заполнения формы "Для кого самокат"
    public void fillPageAboutCustomer(String firstName, String lastName, String address, String metroStation, String phoneNumber) {
        fillFieldFirstName(firstName);
        fillFieldLastName(lastName);
        fillFieldAddress(address);
        fillFieldMetroStation(metroStation);
        fillFieldPhoneNumber(phoneNumber);
        clickButtonNext();
    }
}