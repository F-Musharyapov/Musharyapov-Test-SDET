package pages;

import config.FormTestConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

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

    @FindBy(css = "input[id='lastName']")
    private WebElement lastName;

    @FindBy(css = "input[id='userEmail']")
    private WebElement userEmail;

    @FindBy(css = "label[for='gender-radio-3']")
    private WebElement gender;

    @FindBy(css = "input[id='userNumber']")
    private WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select")
    private WebElement month;

    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option[10]")
    private WebElement monthOctober;

    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")
    private WebElement year;

    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select/option[92]")
    private WebElement year1991;

    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[1]")
    private WebElement day13;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(id = "react-select-2-option-0")
    private WebElement subjectsSelect;

    @FindBy(xpath = "//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")
    private WebElement hobbiesWrapper;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;

    @FindBy(css = "textarea[id='currentAddress']")
    private WebElement currentAddress;

    @FindBy(id = "state")
    private WebElement selectState;

    @FindBy(id = "react-select-3-option-0")
    private WebElement selectStateNCR;

    @FindBy(id = "city")
    private WebElement selectCity;

    @FindBy(id = "react-select-4-option-0")
    private WebElement selectCityDelhi;

    @FindBy(id = "submit")
    private WebElement submitButton;



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
     * @param input текст ввода
     * @return текущая страница
     */
    @Step("Ввод данных в поле ввода")
    public FormPage inputFirstName(String input) {
        firstName.sendKeys(input);
        return this;
    }

    public FormPage inputLastName(String input) {
        lastName.sendKeys(input);
        return this;
    }
    public FormPage inputUserEmail(String input) {
        userEmail.sendKeys(input);
        return this;
    }
    public FormPage clickToGender() {
        gender.click();
        return this;
    }
    public FormPage inputUserNumber(String input) {
        userNumber.sendKeys(input);
        return this;
    }
    public FormPage selectDateOfBirth() {
        dateOfBirth.click();
        month.click();
        monthOctober.click();
        year.click();
        year1991.click();
        day13.click();
        return this;
    }
    public FormPage inputSubjectsInput(String input) {
        subjectsInput.sendKeys(input);
        subjectsSelect.click();
        return this;
    }
    public FormPage clickToHobbiesWrapper() {
        hobbiesWrapper.click();
        return this;
    }
    public FormPage uploadPicture() {
        uploadPicture.sendKeys(new File(config.testPicture()).getAbsolutePath());
        return this;
    }
    public FormPage inputCurrentAddress(String input) {
        currentAddress.sendKeys(input);
        return this;
    }
    public FormPage clickToSelectState() {
        selectState.click();
        selectStateNCR.click();
        return this;
    }
    public FormPage clickToSelectCity() {
        selectCity.click();
        selectCityDelhi.click();
        return this;
    }
    public FormPage clickToSubmit() {
        submitButton.click();
        return this;
    }
}