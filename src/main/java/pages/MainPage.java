package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(xpath = "//ul[contains(@class,'alt-menu-mid__list')]")
    WebElement mainMenuI;
    @FindBy(xpath = "//li[contains(@class,'alt-menu-collapser')]")
    WebElement subMenu;
    @FindBy(xpath = "(//div[@class = 'alt-menu-collapser__hidder'])[5]")
}
