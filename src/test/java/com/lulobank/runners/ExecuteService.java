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
        tags = "@services",
        //tags =  "@GetVote",
        //tags = " @GetVotes",
        //tags = "@GetBreeds",
        //tags = "@GetAnBreed",
        //tags = "@GetCategories",
        //tags = "@DeleteVote or @UHPDeleteVote or @GetBreeds or @GetAnBreed or @GetCategories",
        //tags = "@GetBreeds or @GetAnBreed or @GetCategories",
        //tags = "@PostVote or @DeleteVote",
        //tags = "@PostVote or @DeleteVote or @UHPDeleteVote
        //tags = "@UHPDeleteVote",
        //tags = "@PostVote",
        snippets = SnippetType.CAMELCASE,
        monochrome = true

)
public class ExecuteService {
}
