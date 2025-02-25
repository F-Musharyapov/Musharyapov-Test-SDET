package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static utils.ScreenHelper.makeScreenShot;

/**
 * Класс в котором происходит взаимодействие с ответом формы
 */
public class PopupPage  extends Assert {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;

    /**
     * Конструктор создания FormPage
     *
     * @param driver драйвер для управления браузером
     */
    public PopupPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Элемент форма
     */
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement title;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")
    private WebElement nameLabel;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")
    private WebElement emailLabel;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")
    private WebElement genderLabel;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")
    private WebElement mobileLabel;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")
    private WebElement dateOfBirthLabel;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")
    private WebElement subjectsLabel;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")
    private WebElement hobbiesLabel;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[8]/td[2]")
    private WebElement pictureLabel;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")
    private WebElement addressLabel;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")
    private WebElement stateAndCityLabel;


    /**
     * Метод проверки сообщения в форме
     *
     * @return текущая страница
     */
    @Step("Проверка успешной отправки формы")
    public PopupPage checkTitle() {
        String titleForm = title.getText();

        Assert.assertEquals("Thanks for submitting the form", titleForm);
        makeScreenShot(driver);
        return this;
    }

    /**
     * Метод проверки выведенных данных форме, сравнение с отправленными
     *
     * @return текущая страница
     */
    @Step("Проверка успешной отправки формы")
    public void checkElements() {

    }
}
