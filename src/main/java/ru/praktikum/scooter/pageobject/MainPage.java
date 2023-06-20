package ru.praktikum.scooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    public MainPage(WebDriver webDriver) {
        this.webDriver=webDriver;
    }
    private WebDriver webDriver;

    //Локатор для кнопки "Заказать" в шапке
    private final By buttonOrderInHeader = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Локатор для кнопки "Заказать" в теле
    private final By buttonOrderInBody = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локатор для кнопки принятия куки
    private final By buttonCookiesApprove = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    //Локатор для блока "Вопросы о важном"
    private By fieldImportantQuestion = By.xpath(".//*[@class='accordion__panel' and not(@hidden)]/p");

    //Метод для принятия куки
    public void clickCookiesApprove() {
        webDriver.findElement(buttonCookiesApprove).click();
    }

    //Метод для клика по кнопке "Заказать" в шапке
    public void clickButtonOrderInHeader() {
        webDriver.findElement(buttonOrderInHeader).click();
    }

    //Метод для клика по кнопке "Заказать" в теле
    public void clickButtonOrderInBody() {
        WebElement element = webDriver.findElement(buttonOrderInBody);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Метод для выбора кнопки "Заказать"
    public void chooseOrderButton(String buttonPlace){
        if (buttonPlace.equals("header")){
            clickButtonOrderInHeader();
        } else {
            clickButtonOrderInBody();
        }
    }

    //Метод для получения ответов в блоке "Вопросы о важном"
    public List<String> getTextFromImportantList() {
        List<WebElement> elements = webDriver.findElements(By.className("accordion__button"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", elements.get(0));

        ArrayList<String> listOfTexts = new ArrayList<String>();
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).click();
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", elements.get(i));
            String answersField = webDriver.findElement(fieldImportantQuestion).getText();
            listOfTexts.add(answersField);
        }

        return listOfTexts;
    }
}
