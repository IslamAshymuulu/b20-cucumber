package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LambdatestHomePage {

    public LambdatestHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Input Form Submit")
    public WebElement submitField;

    @FindBy(id = "name")
    public WebElement submitName;

    @FindBy(id = "inputEmail4")
    public WebElement submitEmail;

    @FindBy(id = "inputPassword4")
    public WebElement submitPassword;

    @FindBy(id = "company")
    public WebElement submitCompany;

    @FindBy(id = "websitename")
    public WebElement submitWebsite;

    @FindBy(name = "country")
    public WebElement choiceCountry;


    @FindBy(id = "inputCity")
    public WebElement submitCity;

    @FindBy(id = "inputAddress1")
    public WebElement submitAddress;

    @FindBy(id = "inputAddress2")
    public WebElement submitAddress1;

    @FindBy(id = "inputState")
    public WebElement submitState;

    @FindBy(id = "inputZip")
    public WebElement submitZipCode;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement getSubmitField;

    @FindBy(css = ".success-msg.hidden")
    public WebElement successMessage;

}
