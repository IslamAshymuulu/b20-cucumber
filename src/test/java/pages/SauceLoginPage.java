package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {


    public  SauceLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(tagName = "h3")
    public WebElement error;

    @FindBy(linkText = "Sauce Labs Onesie")
    public WebElement itemName;

    @FindBy(xpath = "//button[@id='add-to-cart']")
    public WebElement item;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    public WebElement price;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement toCart;

    @FindBy(xpath = "//a[@id='item_2_title_link']")
    public WebElement validation;

    public String getErrorMessage(){
        String errorMessage = error.getText();
        return errorMessage;
    }


    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void itemName(){
        itemName.click();
    }

    public String getPrice(){
        String getPrice = price.getText();
        return getPrice;
    }


    public void itemClick(){
        item.click();
    }

    public void cartClick(){
        toCart.click();
    }

    public String validationItem(){
        String validationText = validation.getText();
        return validationText;

    }









}
