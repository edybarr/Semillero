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
        //tags = "@GetBreeds",
        //tags = "@GetAnBreed",
        //tags = "@GetBreeds or @GetAnBreed or @GetAnBreedOutline",
        //tags = "@GetAnbreed_uhp",
        //tags = "@GetCategories",
        //tags = "@GetCategory",
        //tags = "@GetTwoCategories",
        //tags = "@GetCategories or @GetCategory or @GetTwoCategories",
        //tags = "@GetBreeds or @GetAnBreed or @GetCategories",
        //tags =  "@GetVote",
        //tags = " @GetVotes",
        //tags = "@PostVote or @DeleteVote",
        //tags = "@PostVote or @DeleteVote or @UHPDeleteVote
        //tags = "@UHPDeleteVote",
        //tags = "@PostVote",
        //tags = "@DeleteCreatedVote",
        //tags = "@GetVotes or @GetVote or PostVote or DeleteVote or @DeleteVoteCreado or @UHPDeleteVote",
        //tags = "@DeleteVote or @UHPDeleteVote or @GetBreeds or @GetAnBreed or @GetCategories",
        snippets = SnippetType.CAMELCASE,
        monochrome = true

)
public class ExecuteService {
}
