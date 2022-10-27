package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
           "html:target/cucumber-reports.html",//generated automatically after run the code under target folder
           "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,   //when is true our code will print just the snippet/report
        tags = "@wip"  //we can attach using annotation a meaningful name for our feature file, so we
                        // customise how many scenarios will be running by calling them
        //IMPORTANT- if we use tags the reports won't be generated
)
public class CukesRunner {
}
