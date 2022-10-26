package com.cydeo.step_definitions;

import com.cydeo.pages.WebTablePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebTable_StepDefinitions {

    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        //Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        String url = ConfigurationReader.getProperties("webTableUrl");
        Driver.getDriver().get(url);
    }

    WebTablePage webTablePage = new WebTablePage();
    @When("user enters username {string}")
    public void user_enters_username(String string) {
        webTablePage.usernameInputBox.sendKeys(string);
    }
    @When("user enters password {string}")
    public void user_enters_password(String string) {
        webTablePage.passwordInputBox.sendKeys(string);
    }

    @When("user click to login button")
    public void user_click_to_login_button() {
        webTablePage.loginButton.click();
    }
    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtils.verifyUrlContains("orders");
    }

    @When("user enters username {string} and password {string} and logins")
    public void user_enters_username_and_password_and_logins(String username, String password) {
        webTablePage.login(username,password);
    }

}
