package ru.ibs.qa.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ExperimentalSteps {

    public static WebDriver driver;

    @И("открыта страница по адресу {string}")
    public void открыта_страница_по_адресу(String string1) {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Renat\\IdeaProjects\\cucumberQA-practice\\src\\test\\resources\\chromedriver.exe");

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @И("выполнено нажатие на {string}")
    public void выполнено_нажатие_на(String string) {
        driver.get("http://localhost:8080/");

        WebElement element = driver.findElement(By.xpath("//a[@id=\"navbarDropdown\"]"));
        element.click();

        WebElement buttonFood = driver.findElement(By.xpath("//a[@href=\"/food\"]"));
        buttonFood.click();

        WebElement buttonAddNewFood = driver.findElement(By.xpath("//button[@data-target=\"#editModal\"]"));
        buttonAddNewFood.click();
    }

    @И("в поле {string} выбирается значение {string}")
    public void выбран_тип_товара(String string, String string1) {
        WebElement inputFoodName = driver.findElement(By.xpath("//input[@id=\"name\"]"));
        inputFoodName.clear();
        inputFoodName.sendKeys("Арбуз");

        WebElement inputFoodType = driver.findElement(By.xpath("//select[@id=\"type\"]"));
        inputFoodType.click();
        WebElement inputFoodTypeFruit = driver.findElement(By.xpath("//select[@id=\"type\"]//option[@value=\"FRUIT\"]"));
        inputFoodTypeFruit.click();

        WebElement inputCheckbox = driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
        inputCheckbox.click();
    }


    @И("выполнено нажатие на {string} для добавления нового товара")
    public void нажатие_для_добавления(String string) {
        WebElement buttonSave = driver.findElement(By.xpath("//button[@id=\"save\"]"));
        buttonSave.click();
    }

    @И("поле {string} заполняется значением {string}")
    public void поле_заполняется_значением(String string, String string2) {
        // Реализация
    }

    @И("проверка добавленного товара")
    public void проверка_добавленного_товара() {
        WebElement carrotName = driver.findElement(By.xpath("//tbody/tr[5]/td[1]"));
        Assertions.assertEquals("Арбуз", carrotName.getText(), "Не соответствует значение...");

        WebElement carrotType = driver.findElement(By.xpath("//tbody/tr[5]/td[2]"));
        Assertions.assertEquals("Фрукт", carrotType.getText(), "Не соответствует значение...");

        WebElement carrotExotic = driver.findElement(By.xpath("//tbody/tr[5]/td[3]"));
        Assertions.assertEquals("false", carrotExotic.getText(), "Не соответствует значение...");
    }

    @И("выполнено нажатие на {string} и затем на {string}")
    public void сброс_данных(String string, String string1) {
        WebElement element = driver.findElement(By.xpath("//a[@id=\"navbarDropdown\"]"));
        element.click();

        WebElement elementResetData = driver.findElement(By.xpath("//a[@id=\"reset\"]"));
        elementResetData.click();
    }




}
