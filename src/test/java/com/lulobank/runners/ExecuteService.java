package com.lulobank.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.checkerframework.framework.qual.PostconditionAnnotation;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber"},
        glue = "com.lulobank.stepdefinitions",
        //tags = "@services",
        //tags = "@GetBreeds",
        //tags = "@GetAnBreed",
        //tags = "@GetCategories",
        tags = "@DeleteVote",
        //tags = "@PostVote",
        snippets = SnippetType.CAMELCASE,
        monochrome = true

)
public class ExecuteService {
}
