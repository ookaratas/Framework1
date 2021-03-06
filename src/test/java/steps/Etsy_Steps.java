package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EtsyHomePage;
import utilities.Config;
import utilities.Driver;
import org.junit.Test;

import static utilities.Driver.driver;

public class Etsy_Steps {

    EtsyHomePage etsyHomePage = new EtsyHomePage();


    @Given("User is on Etsy Homepage")
    public void user_is_on_Etsy_Homepage() {
      Driver.getDriver().get("https://etsy.com");

    }

    @When("User types {string} in the search box")
    public void user_types_in_the_search_box(String string) {

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(etsyHomePage.searchBox));
        etsyHomePage.searchBox.sendKeys(string);
        
    }

    @When("User clicks search button")
    public void user_clicks_search_button() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(etsyHomePage.searchBox));
        etsyHomePage.searchButton.click();

        
    }

    @Then("User sees {string} is in the title")
    public void user_sees_is_in_the_title(String string) {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = string + " | Etsy";

        Assert.assertTrue(actualTitle.equalsIgnoreCase("Wooden spoon | Etsy"));

    }
}
