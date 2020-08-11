package com;

import com.maveric.core.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"./src/test/resources/features"},
        glue ={ "com.internetapp.pages"},
        dryRun=false,
        tags = "@ParaBankTest",
        monochrome = true
)
public class CucumberRunner extends CucumberBaseTest {


}
