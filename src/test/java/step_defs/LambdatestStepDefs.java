package step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.LambdatestHomePage;
import utils.ConfigUtils;
import utils.DriverUtils;

import java.util.Map;

public class LambdatestStepDefs {

    private WebDriver driver;

    private LambdatestHomePage lhp;


    @Given("I navigate to Lambdatest home page")
    public void i_navigate_to_lambdatest_home_page() {
        driver = DriverUtils.getDriver("chrome");
        String url = ConfigUtils.getConfigProp("lambdatest_url");
        driver.navigate().to(url);

    }


    @Then("I click input form submit link")
    public void i_click_input_form_submit_link() {
        LambdatestHomePage lhp = new LambdatestHomePage(driver);
        lhp.submitField.click();


    }
    @Then("I enter all required data in form")
    public void i_enter_all_required_data_in_form() {
        LambdatestHomePage lhp = new LambdatestHomePage(driver);
        lhp.submitName.sendKeys("Islam");
        lhp.submitEmail.sendKeys("IslamAsh@gamil.com");
        lhp.submitPassword.sendKeys("Islam234");
        lhp.submitCompany.sendKeys("Codefish");
        lhp.submitWebsite.sendKeys("Codefish.io");


        Select select = new Select(lhp.choiceCountry);
        select.selectByVisibleText("United States");

        lhp.submitCity.sendKeys("Des Plaines");
        lhp.submitAddress.sendKeys("Devon 2200");
        lhp.submitAddress1.sendKeys("Burlington 300");
        lhp.submitState.sendKeys("IL");
        lhp.submitZipCode.sendKeys("60443");


    }
    @Then("I click submit")
    public void i_click_submit() {
        LambdatestHomePage lhp = new LambdatestHomePage(driver);
        lhp.getSubmitField.click();

    }
    @Then("I validate success message")
    public void i_validate_success_message() {
        lhp = new LambdatestHomePage(driver);
        String expectedMessage = "Thanks for contacting us, we will get back to you shortly.";
        String actualMessage =lhp.successMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @When("I fill out the form with following information")
    public void i_fill_out_the_form_with_following_information(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap();

        lhp = new LambdatestHomePage(driver);


        //retrieving values from data table by keys
        String name = dataMap.get("name");
        System.out.println(name);
        lhp.submitName.sendKeys(name);

        String email = dataMap.get("email");
        System.out.println(email);
        lhp.submitEmail.sendKeys(email);

        String password = dataMap.get("password");
        System.out.println(password);
        lhp.submitPassword.sendKeys(password);

        String company = dataMap.get("company");
        System.out.println(company);
        lhp.submitCompany.sendKeys(company);

        String website = dataMap.get("website");
        System.out.println(website);
        lhp.submitWebsite.sendKeys(website);

        String country = dataMap.get("country");
        System.out.println(country);

        Select select = new Select(lhp.choiceCountry);
        select.selectByVisibleText(country);

        String city = dataMap.get("city");
        System.out.println(city);
        lhp.submitCity.sendKeys(city);

        String address1 = dataMap.get("address1");
        System.out.println(address1);
        lhp.submitAddress.sendKeys(address1);

        String address2 = dataMap.get("address2");
        System.out.println(address2);
        lhp.submitAddress1.sendKeys(address2);

        String state = dataMap.get("state");
        System.out.println(state);
        lhp.submitState.sendKeys(state);

        String zipCode = dataMap.get("zipCode");
        System.out.println(zipCode);
        lhp.submitZipCode.sendKeys(zipCode);





    }





}
