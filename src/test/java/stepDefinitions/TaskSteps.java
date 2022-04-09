package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TaskSteps {
    private WebDriver driver;

    public TaskSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on People with jobs page$")
    public void iAmOnThePeoplesJobsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
        assertTrue(driver.getCurrentUrl().contains("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"));
    }


    @When("^I click on Add Person$")
    public void iClickAddPerson() throws Throwable {
        driver.findElement(By.xpath("//*[contains(text(), 'Add person')]")).click();
    }

    @And("^I get redirected to new page to enter data$")
    public void iGetRedirected() throws Throwable {
        assertTrue(driver.getCurrentUrl().contains("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html"));
    }

    @And("^I input Name \"([^\"]*)\"$")
    public void iInputName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I input Job \"([^\"]*)\"$")
    public void iInputJob(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click on Add$")
    public void iClickAdd() throws Throwable {
        driver.findElement(By.xpath("//*[contains(text(), 'Add')]")).click();
    }

    @When("^I click pencil to edit person$")
    public void iClickThePencil() throws Throwable {
        driver.findElement(By.className("fa-pencil")).click();
    }

    @And("^I change job to: \"([^\"]*)\"$")
    public void iChangeJob(String job) throws Throwable {
        driver.findElement(By.xpath("//*[@id='job']")).clear();
        driver.findElement(By.xpath("//*[@id='job']")).sendKeys(job);
        Thread.sleep(1000);
    }

    @And("^I click on Edit$")
    public void iClickEdit() throws Throwable {
        driver.findElement(By.xpath("//*[contains(text(), 'Edit')]")).click();
    }

    @When("^I click x to remove person$")
    public void iClickTheX() throws Throwable {
        driver.findElement(By.cssSelector("#person0 .closebtn")).click();
        Thread.sleep(1000);
    }

    @When("^I click on Reset List$")
    public void iClickResetList() throws Throwable {
        driver.findElement(By.xpath("//*[contains(text(), 'Reset List')]")).click();
        Thread.sleep(1000);
    }

    @When("^I click on Clear all fields$")
    public void iClickClearFields() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
        Thread.sleep(1000);
    }

    @Then("^I see new person is added to list of people$")
    public void newPersonIsAddedToList() throws Throwable {
        assertEquals("×\n" + "Mike\n" +  "Web Designer\n" +
                "×\n" + "Jill\n" +  "Support\n" + "×\n" + "Jane\n" +
                "Accountant\n" + "×\n" + "Rick\n" + "Scientist", driver.findElement(By.id("listOfPeople")).getText());
    }

    @Then("^I see Persons info is changed accordingly$")
    public void newPersonsInfoIsChanged() throws Throwable {
        assertEquals("×\n" + "Mike\n" +  "Scientist\n" +
                "×\n" + "Jill\n" +  "Support\n" + "×\n" + "Jane\n" +
                "Accountant", driver.findElement(By.id("listOfPeople")).getText());
    }

    @Then("^I see person is removed$")
    public void personIsRemoved() throws Throwable {
        assertEquals("×\n" + "Jill\n" +  "Support\n" + "×\n" + "Jane\n" +
                "Accountant", driver.findElement(By.id("listOfPeople")).getText());
    }

    @Then("^I see list is reset to original$")
    public void iSeeListIsReset() throws Throwable {
        assertEquals("×\n" + "Mike\n" +  "Web Designer\n" +
                "×\n" + "Jill\n" +  "Support\n" + "×\n" + "Jane\n" +
                "Accountant", driver.findElement(By.id("listOfPeople")).getText());
    }

    @Then("^I see the fields are cleared$")
    public void iSeeFieldsCleared() throws Throwable {
        assertEquals("",driver.findElement(By.id("name")).getText());
        assertEquals("",driver.findElement(By.id("job")).getText());
    }
}





