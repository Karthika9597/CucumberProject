package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\karth\\eclipse-workspace\\Cucumberdemo\\src\\test\\java\\feature",
                 dryRun=false, publish=true, monochrome=true, tags="@login")

public class Runnerc {

} 
 