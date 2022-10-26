package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In this class we will be able to pass pre- & post- conditions to each scenario and each step
 */
public class Hooks {  //project  recognise the hooks because we provide the glue path in CukesRunner

    //import @Before from io.cucumber.java not from junit
//    @Before(order = 1)    //even if we don't write the order nr it will still run the default annotation
//    public void setupScenario(){
//
//        System.out.println("=====Setting up browser using cucumber @Before====");
//
//    }
//
//    @Before(value = "@login", order = 2)  //--> priorities to what scenarios this can apply
//    public void setupScenarioForLogin(){
//        System.out.println("=====This will only apply to scenarios with @login tag");
//    }
//
//    @Before(value = "@db", order = 0) //--> priorities to what scenarios this can apply , and add certain order
//    public void setupForDatabaseScenarios(){
//        System.out.println("=====This will only apply to scenarios with @db tag");
//    }

    //import @After from io.cucumber.java not from junit
    @After
    public void tearDownScenario(Scenario scenario){ // import the parameter Scenario from cucumber-java
        //scenario keep truck of currently scenario that is executed


        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value
        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png",scenario.getName());   //attached to our report
        }



        Driver.getDriver().close();  // hooks after method will take care to close after each scenario executed


        //System.out.println("====Closing browser using cucumber @After====");
        //System.out.println("====Scenario ended/ Take a screenshot if it fails");
    }

//    @BeforeStep
//    public void setupStep(){
//
//        System.out.println("-------> applying setup using @BeforeStep");
//
//    }
//
//    @AfterClass
//    public void afterStep(){
//        System.out.println("---> applying tearDown using @AfterStep");
//
//
//    }
}
