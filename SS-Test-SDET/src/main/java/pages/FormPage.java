package pages;

import config.FormTestConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс в котором происходит взаимодействие со страннице с формой
 */
public class FormPage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;

    /**
     * Экземпляр конфигурации с параметрами для тестов формы на странице
     */
    private final FormTestConfig config = ConfigFactory.create(FormTestConfig.class, System.getenv());

    /**
     * Элемент с полем ввода First Name
     */
    @FindBy(css = "input[id='firstName']")
    private WebElement firstName;

    /**
     * Конструктор создания FormPage
     *
     * @param driver драйвер для управления браузером
     */
    public FormPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод ввода текста в поле поиска
     *
     * @param str текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода")
    public FormPage inputFirstName(String str) {
        firstName.sendKeys(str);
        return this;
    }

}