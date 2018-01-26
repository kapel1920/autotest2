import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InsuranceTest extends BaseTest{
/*    WebDriver driver;
    String baseUrl;

    @Before
    public void beforeTest()
    {
        //Устанавливаю путь к драйверу в системных переменных
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");

        driver = new ChromeDriver();

        //Задаю значение перемменой, адрес точки входа
        baseUrl = "http://www.sberbank.ru/ru/person";

        //Разворачиваю браузер на весь экран
        driver.manage().window().maximize();
    }
*/

    @Test
    public void testInsurance()
    {
        //Добавляю слейш к адресу
        driver.get(baseUrl + "/");

        //Разворачиваю список застраховать себя и имущество
        driver.findElement(By.xpath(".//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/ul/li[5]/a/span/span[1]")).click();

        //Перехожу на страхование путешественников
        driver.findElement(By.xpath(".//*[contains(@class,'list__link_level_1')][contains(text(),'Страхование путешественников')]")).click();

        //Проверяю наличие на странице заголовка – Страхование путешественников
        //assertEquals("Страхование путешественников", driver.findElement(By.xpath("//h1[contains(text(),'Страхование путешественников')]")).getText());
        String expected = "Страхование путешественников";
        String actual = driver.findElement(By.xpath("//h1[contains(text(),'Страхование путешественников')]")).getText();
        assertTrue("Заголовок страницы не соответствует ожидаемому", expected.equals(actual));

        //Нажимаю на каотинку Оформить сейчас
        driver.findElement(By.xpath("//img[contains(@src,'id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53')]")).click();

        //Перехожу на новую вкладку
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        driver.getTitle();

        //Выбираю элемент Минимальная
        //driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")).click();
        driver.findElement(By.xpath("//*[@id='views']/form/section/section/section[2]/div[1]/div[1]")).click();
        //Нажимаю кнопку Оформить
        driver.findElement(By.xpath(".//*[contains(@class,'btn')][contains(text(),'Оформить')]")).click();

        //Нажимаю на поле Фамилия застрахованных
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'namespace.SURNAME_ENG')]")).click();
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'namespace.SURNAME_ENG')]")).clear();
        fillField(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'namespace.SURNAME_ENG')]"), "Ivanov");

        //Нажимаю на поле Имя застрахованных
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'namespace.NAME_ENG')]")).click();
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'namespace.NAME_ENG')]")).clear();
        fillField(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'namespace.NAME_ENG')]"), "Ivan");

        //Нажимаю на поле Дата рождения застрахованных
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'namespace.BIRTHDATE')]")).click();
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'namespace.BIRTHDATE')]")).clear();
        fillField(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'namespace.BIRTHDATE')]"), "01.01.1980");

        //Нажимаю на поле Фамилия страхователя
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.LASTNAME')]")).click();
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.LASTNAME')]")).clear();
        fillField(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.LASTNAME')]"), "Петров");

        //Нажимаю на поле Имя страхователя
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.FIRSTNAME')]")).click();
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.FIRSTNAME')]")).clear();
        fillField(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.FIRSTNAME')]"), "Петр");

        //Нажимаю на поле Отчество страхователя
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.MIDDLENAME')]")).click();
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.MIDDLENAME')]")).clear();
        fillField(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.MIDDLENAME')]"), "Петрович");

        //Нажимаю на поле Дата рождения страхователя
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.BIRTHDATE')]")).click();
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.BIRTHDATE')]")).clear();
        fillField(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.BIRTHDATE')]"), "01.01.1980");

        ////Нажимаю на поле Пол страхователя - Мужской
        driver.findElement(By.xpath("//input[contains(@class,'b-radio-field')][contains(@ng-model,'formdata.insurer.GENDER')]")).click();

        //Нажимаю на поле Серия пасспорта
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].DOCSERIES')]")).click();
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].DOCSERIES')]")).clear();
        fillField(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].DOCSERIES')]"), "1234");

        //Нажимаю на поле Номер пасспорта
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].DOCNUMBER')]")).click();
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].DOCNUMBER')]")).clear();
        fillField(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].DOCNUMBER')]"), "123456");

        //Нажимаю на поле Дата рвыдачи пасспорта
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].ISSUEDATE')]")).click();
        driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].ISSUEDATE')]")).clear();
        fillField(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].ISSUEDATE')]"), "04.04.1984");

        //Нажимаю на поле Кем выдан
        driver.findElement(By.xpath("//textarea[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].ISSUEDBY')]")).click();
        driver.findElement(By.xpath("//textarea[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].ISSUEDBY')]")).clear();
        fillField(By.xpath("//textarea[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].ISSUEDBY')]"), "РОВД");

        //Проверяю правильность заполнения полей
        assertEquals("Ivanov", driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'namespace.SURNAME_ENG')]")).getAttribute("value"));
        assertEquals("Ivan", driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'namespace.NAME_ENG')]")).getAttribute("value"));
        assertEquals("01.01.1980", driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'namespace.BIRTHDATE')]")).getAttribute("value"));

        assertEquals("Петров", driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.LASTNAME')]")).getAttribute("value"));
        assertEquals("Петр", driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.FIRSTNAME')]")).getAttribute("value"));
        assertEquals("Петрович", driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.MIDDLENAME')]")).getAttribute("value"));
        assertEquals("01.01.1980", driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.BIRTHDATE')]")).getAttribute("value"));

        assertEquals("1234", driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].DOCSERIES')]")).getAttribute("value"));
        assertEquals("123456", driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].DOCNUMBER')]")).getAttribute("value"));
        assertEquals("04.04.1984", driver.findElement(By.xpath("//input[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].ISSUEDATE')]")).getAttribute("value"));
        assertEquals("РОВД", driver.findElement(By.xpath("//textarea[contains(@class,'b-text-field')][contains(@ng-model,'formdata.insurer.documentList[0].ISSUEDBY')]")).getAttribute("value"));

        //Нажимаю кнопку Продолжить
        driver.findElement(By.xpath(".//*[contains(@class,'btn')][contains(text(),'Продолжить')]")).click();

        //Проверяю сообщение о необходимости заполнения всех полей
        //assertEquals("Заполнены не все обязательные поля", driver.findElement(By.xpath("//*[@id=\'views\']/section/form/section/section[5]/div[2]/div[1]")).getText());
        String expected1 = "Заполнены не все обязательные поля";
        String actual1 = driver.findElement(By.xpath("//*[@id=\'views\']/section/form/section/section[5]/div[2]/div[1]")).getText();
        assertTrue("Сообщение соответствует ожидаемому" ,expected1.equals(actual1));
    }
/*   @After
    public void afterTest()
    {
        driver.quit();
    }*/

    private void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
}
