package com.globalLogic.discovery.cukes;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.globalLogic.discovery.PropertyFileReader;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author shivanand sunagad
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, tags = {"@homeTask", "~@ignore" }, features = {
		"src/test/resources/com.globalLogic.discovery/" }, glue = {
				"com.globalLogic.discovery.stepdefs.steps" }, plugin = { "json:target/cucumber.json" })

public class RunCukeTest {
	@BeforeClass
	public static void init() {
		String browserType=PropertyFileReader.getProperty("browser.type");
		System.setProperty("browserType", browserType );
		System.setProperty("driverLibDir", System.getProperty("user.dir").concat("/lib"));
		System.setProperty("log.level", "DEBUG");
		System.setProperty("Time Zone", System.getProperty("user.timezone"));
	}

	@AfterClass
	public static void finish() throws IOException {
		
		
		
			}

}
