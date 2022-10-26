package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;

import java.util.List;

public class DataTable_StepDefinitions {

    @Then("user should see fruits I like")
    public void user_should_see_fruits_i_like(List<String> fruits) throws InterruptedException {

        Driver.getDriver().get("https://www.youtube.com/");

        Thread.sleep(5000);
        System.out.println(fruits);
        System.out.println(fruits.get(1));


    }

}
