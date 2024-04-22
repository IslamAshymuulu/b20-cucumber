package step_defs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SauceLoginPage;
import pages.SauceProductsPage;
import utils.ConfigUtils;
import utils.DriverUtils;

import java.util.List;

public class SaucedemoStepDefs {
    WebDriver driver;

    @When("I navigate to page")
    public void i_navigate_to_page() {
        driver = DriverUtils.getDriver("chrome");
        String url = ConfigUtils.getConfigProp("url3");
        driver.get(url);
    }

    @Then("I submit username and password")
    public void i_submit_username_and_password() {
        WebElement username =
                driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password =
                driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement submit =
                driver.findElement(By.xpath("//input[@id='login-button']"));
        submit.click();


    }

    @Then("Print out all item names from page")
    public void print_out_all_item_names_from_page() {
        List<WebElement> elements =
                driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        for (int i = 0; i < elements.size(); i++) {
            WebElement tempElement = elements.get(i);
            String elementText = tempElement.getText();
            System.out.println(elementText);
        }

    }

    @When("I login with locked username and password")
    public void i_login_with_locked_username_and_password() {
        SauceLoginPage slp = new SauceLoginPage(driver);
        String username = ConfigUtils.getConfigProp("sauce_locked_username");
        String password = ConfigUtils.getConfigProp("password");
        slp.login(username, password);


    }

    @Then("I should get error message")
    public void i_should_get_error_message() {
        SauceLoginPage slp = new SauceLoginPage(driver);
        String error = slp.getErrorMessage();
        System.out.println(error);

    }

    @Then("I logining to page")
    public void i_logining_to_page() {
        SauceLoginPage slp = new SauceLoginPage(driver);
        String username = ConfigUtils.getConfigProp("username");
        String password = ConfigUtils.getConfigProp("password1");
        slp.login(username, password);


    }

    @Then("I select item")
    public void i_select_item() {
        SauceLoginPage slp = new SauceLoginPage(driver);
        slp.itemName();


    }

    @Then("I print the price")
    public void i_print_the_price() {
        SauceLoginPage slp = new SauceLoginPage(driver);
        String getPrice = slp.getPrice();
        System.out.println(getPrice);

    }

    @Then("I adding item to cart")
    public void i_adding_item_to_cart() {
        SauceLoginPage slp = new SauceLoginPage(driver);
        slp.itemClick();

    }

    @Then("I going to cart")
    public void i_going_to_cart() {
        SauceLoginPage slp = new SauceLoginPage(driver);
        slp.cartClick();

    }

    @Then("I validate that item is in the cart")
    public void i_validate_that_item_is_in_the_cart() {
        SauceLoginPage slp = new SauceLoginPage(driver);
        String itemText = slp.validationItem();
        Assert.assertEquals("Sauce Labs Onesie", itemText);

    }

    @When("I login with visual user")
    public void i_login_with_visual_user() {
        SauceLoginPage slp = new SauceLoginPage(driver);
        String username = ConfigUtils.getConfigProp("sauce_visual_username");
        String password = ConfigUtils.getConfigProp("password1");
        slp.login(username, password);

    }
    @Then("I should see {string} item")
    public void i_should_see_backpack_item(String item) {
        SauceProductsPage spp = new SauceProductsPage(driver);

        if (item.equalsIgnoreCase("backpack")) {

            boolean isBackpackDisplayed = spp.backpackItem.isDisplayed();
            Assert.assertTrue(isBackpackDisplayed);
        }else if(item.equalsIgnoreCase("onesie")){
            boolean isOnesieDisplayed = spp.onesieItem.isDisplayed();
            Assert.assertTrue(isOnesieDisplayed);

    }else {
            Assert.fail("Provided item is not supported yet");
        }

    }

    @Then("price should be {double}")
    public void price_should_be(double price) {
        SauceProductsPage spp = new SauceProductsPage(driver);
        String priceText = spp.onesiePrice.getText();
        System.out.println(priceText);
        System.out.println(priceText.substring(1));

    }


}
