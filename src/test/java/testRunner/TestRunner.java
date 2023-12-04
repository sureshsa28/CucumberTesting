package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/Features/login.feature",
		glue = "stepsCucum",
		dryRun = !true,
		snippets = SnippetType.CAMELCASE,
		publish = true,
		plugin = {"pretty","html:target2/output.html",
				   "junit:target2/output.xml",
				   "json:target2/output.json"},
		monochrome = true,
		tags = "@datas"
		
		)
public class TestRunner {
	
}
