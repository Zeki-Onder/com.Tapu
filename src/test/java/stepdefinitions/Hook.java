package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

import static utilities.Driver.waitFor;

public class Hook {


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            File scrFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(".\\HataliEkranGoruntuleri\\" + scenario.getName() + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        waitFor(5);
        Driver.closeDriver();
        waitFor(5);
    }

}
