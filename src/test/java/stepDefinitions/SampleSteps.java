package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }


    @Given("^I am on the locators page$")
    public void iAmOnLocatorsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    @Then("^I should see both locators page headers$")
    public void iShouldSeePageHeader() throws Throwable {
        assertEquals("Heading 1",
                driver.findElement(By.id("heading_1")).getText());
        assertEquals("Heading 2 text",
                driver.findElement(By.id("heading_2")).getText());
    }

    @Then("^I should be able to click buttons$")
    public void iShouldBeAbleToClickButtons() throws Throwable {
        assertTrue(driver.findElement(By.name("randomButton1")).isEnabled());
        assertTrue(driver.findElement(By.name("randomButton2")).isEnabled());

    }



    @Then("^I see error: \"([^\"]*)\"$")
    public void iSeeAgeError(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("error")).getText());
    }

    @And("^I am not navigated to age message page$")
    public void notNavigatedToAgeMessagePage() throws Throwable {
        assertFalse(driver.getCurrentUrl().contains("https://kristinek.github.io/site/examples/age_2.html"));
        assertTrue(driver.getCurrentUrl().contains("https://kristinek.github.io/site/examples/age"));
    }

    @Given("^I (?:am on|open) a feedback page$")
    public void iAmOnFeedbackPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @When("^I enter name in feedback: \"([^\"]*)\"$")
    public void iEnterNameInFeedback(String name) throws Throwable {
        driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(name);
    }

    @And("^I enter age in feedback: ([^\"]*)$")
    public void iEnterAgeInFeedback(String age) throws Throwable {
        driver.findElement(By.id("fb_age")).clear();
        driver.findElement(By.id("fb_age")).sendKeys(age);
    }

    @And("^I click send button$")
    public void iClickTheSendButton() throws Throwable {
        driver.findElement(By.className("w3-btn-block")).click();
        Thread.sleep(3000);
    }

    @Then("^I can see name \"([^\"]*)\" in feedback check$")
    public void iSeeName(String name) throws Throwable {
        assertEquals(name, driver.findElement(By.id("name")).getText());
    }

    @Then("^I can see age \"([^\"]*)\" in feedback check$")
    public void iSeeAge(String age) throws Throwable {
        assertEquals(age, driver.findElement(By.id("age")).getText());
    }

    @Then("^I can see genre \"([^\"]*)\" in feedback check$")
    public void iSeeGenre(String age) throws Throwable {
        assertEquals(age, driver.findElement(By.id("gender")).getText());
    }

    @Given("^I (?:am on|open) Number page$")
    public void iAmOnNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number \"([^\"]*)\"$")
    public void iEnterMyInvalidNumber(String number) throws Throwable {
        driver.findElement(By.xpath("//*[@id='numb']")).clear();
        driver.findElement(By.xpath("//*[@id='numb']")).sendKeys(number);
    }

    @And("^I click submit$")
    public void iClickTheeSubmit() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
        Thread.sleep(1000);
    }

    @Then("^I see error message \"([^\"]*)\"$")
    public void iSeeTheMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @When("^I enter my valid number \"([^\"]*)\"$")
    public void iEnterMyValidNumber(String number) throws Throwable {
        driver.findElement(By.xpath("//*[@id='numb']")).clear();
        driver.findElement(By.xpath("//*[@id='numb']")).sendKeys(number);
    }

    @Then("^I see Alert saying \"([^\"]*)\"$")
    public void iSeeTheAlert(String alert) throws Throwable {
        assertEquals("Square root of 81 is 9.00", driver.switchTo().alert().getText());
    }

    @And("^I click Ok$")
    public void iAcceptTheAlert() throws Throwable {
        driver.switchTo().alert().accept();
    }

    @And("^I get returned to initial page with clear input field and no errors$")
    public void iGetReturnedToFirstPage() throws Throwable {
        assertTrue(driver.getCurrentUrl().contains("https://kristinek.github.io/site/tasks/enter_a_number"));
        assertEquals("", driver.findElement(By.id("numb")).getText());
        assertEquals("", driver.findElement(By.id("ch1_error")).getText());
    }

    @When("^I select the feedback languages$")
    public void iSelectFeedbackLanguages(List<String> languages) throws Throwable {
        for (String language : languages) {
            driver.findElement(By.xpath("//input[@class='w3-check' and @value='" + language + "']")).click();
        }
    }

    @Then("^I can see languages \"([^\"]*)\" in feedback check$")
    public void iCanSeeLanguages(String languages) throws Throwable {
        assertEquals(languages, driver.findElement(By.id("language")).getText());
    }


    @When("^I enter input in feedback page$")
    public void iEnterInputInFeedback(Map<String, String> feedbackInput) throws Throwable {
        if (feedbackInput.containsKey("name")) {
            iEnterNameInFeedback(feedbackInput.get("name"));
        }
        iEnterAgeInFeedback(feedbackInput.get("age"));
        driver.findElement(By.xpath("//input[@value='" + feedbackInput.get("genre") + "']")).click();
    }

    @When("^I enter input in feedback page as data table$")
    public void iEnterInputInFeedback(DataTable inputTable) throws Throwable {
        for(Map<String, String> feedbackInput : inputTable.asMaps(String.class, String.class)) {
            if (feedbackInput.containsKey("name")) {
                iEnterNameInFeedback(feedbackInput.get("name"));
            }
            iEnterAgeInFeedback(feedbackInput.get("age"));
            driver.findElement(By.xpath("//input[@value='" + feedbackInput.get("genre") + "']")).click();
        }
    }
}



