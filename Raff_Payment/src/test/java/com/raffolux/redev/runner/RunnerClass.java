package com.raffolux.redev.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
monochrome=true,
features= {"src\\test\\resources\\Features\\Checkout01.feature"},
glue= {"com.stepdefinition"},
plugin = {"pretty","html:target/RedevPayment.html",}
)

public class RunnerClass {   
	//script ececute store
}
