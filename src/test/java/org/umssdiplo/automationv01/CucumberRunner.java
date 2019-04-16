package org.umssdiplo.automationv01;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;

@CucumberOptions(
        features = {"src/test/resources/features"},
        format = {"pretty",
                "html:build/cucumber",
                "json:build/cucumber/cucumber.json",
                "junit:build/test-report.xml"},
        tags = {"@bvt"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests{

    @AfterTest
    public void closeBrowser(){
        ManageDriver.getInstance().getWebDriver().close();
    }
}
