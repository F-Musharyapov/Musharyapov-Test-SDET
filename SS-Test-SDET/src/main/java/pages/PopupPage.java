package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.ScreenHelper.makeScreenShot;

/**
 * Класс в котором происходит взаимодействие с ответом формы
 */
public class PopupPage {

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

    //Массив  с ожидаемыми значениями, которые будут использоваться для проверки данных
    private final Map<String, String> expectedMap = createExpectedMap();
    /**
     * Элемент чекбокс с одиночным выбором Gender
     */
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement head;
    private final String nameLabel = "Student Name";
    private final String emailLabel = "Student Email";
    private final String genderLabel = "Gender";
    private final String mobileLabel = "Mobile";
    private final String dateOfBirthLabel = "Date of Birth";
    private final String subjectsLabel = "Subjects";
    private final String hobbiesLabel = "Hobbies";
    private final String pictureLabel = "Picture";
    private final String addressLabel = "Address";
    private final String stateAndCityLabel = "State and City";

    /**
     * Метод проверки
     *
     * @return текущая страница
     */
    @Step("Проверка")
    public PopupPage checkHead() {
        head.getText();
        String actualHead = driver.findElement(head).getText();

        Assert.assertEquals("Thanks for submitting the form", actualHead);
        makeScreenShot(driver);
        return this;
    }

    public void checkTableElements() {
        List<WebElement> myList = driver.findElements(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[2]"));
        Map<String, String> actualTable = new HashMap<>();
        List<WebElement> labelAndValue;

        for (int i = 1; i <= myList.size(); i++) {
            labelAndValue = findElements(i);
            String label = labelAndValue.get(0).getText();
            String value = labelAndValue.get(1).getText();

            actualTable.put(label, value);
            labelAndValue.clear();
        }

        Assert.assertEquals(actualTable.get(nameLabel), expectedMap.get(nameLabel));
        Assert.assertEquals(actualTable.get(emailLabel), expectedMap.get(emailLabel));
        Assert.assertEquals(actualTable.get(genderLabel), expectedMap.get(genderLabel));
        Assert.assertEquals(actualTable.get(mobileLabel), expectedMap.get(mobileLabel));
        Assert.assertEquals(actualTable.get(dateOfBirthLabel), expectedMap.get(dateOfBirthLabel));
        Assert.assertEquals(actualTable.get(subjectsLabel), expectedMap.get(subjectsLabel));
        Assert.assertEquals(actualTable.get(hobbiesLabel), expectedMap.get(hobbiesLabel));
        Assert.assertEquals(actualTable.get(pictureLabel), expectedMap.get(pictureLabel));
        Assert.assertEquals(actualTable.get(addressLabel), expectedMap.get(addressLabel));
        Assert.assertEquals(actualTable.get(stateAndCityLabel), expectedMap.get(stateAndCityLabel));
    }

    private List<WebElement> findElements(int i) {
        return driver.findElements(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[1]/td[1]"));
    }

    private Map<String, String> createExpectedMap() {
        Map<String, String> expectedMap = new HashMap<>();

        expectedMap.put(nameLabel, "FirstTEST LastTEST");
        expectedMap.put(emailLabel, "email@test.com");
        expectedMap.put(genderLabel, "Other");
        expectedMap.put(mobileLabel, "9020012233");
        expectedMap.put(dateOfBirthLabel, "13 May,1992");
        expectedMap.put(subjectsLabel, "English");
        expectedMap.put(hobbiesLabel, "");
        expectedMap.put(pictureLabel, "image.jpg");
        expectedMap.put(addressLabel, "55 Lenin Street, Ulyanovsk");
        expectedMap.put(stateAndCityLabel, "NCR Delhi");

        return expectedMap;
    }
}