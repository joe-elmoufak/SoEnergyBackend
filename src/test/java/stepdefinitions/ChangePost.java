package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.picocontainer.annotations.Inject;

import java.io.IOException;

public class ChangePost {
    @Inject
    functions.ChangePost put;

    @Given("I execute a request to change post id {string}")
    public void iExecuteARequestToChangePostId(String postID) throws IOException {
        put.executePutRequest(postID);
    }

    @Then("I verify that it was id {int} that was changed in the response")
    public void iVerifyThatItWasIdThatWasChangedInTheResponse(int postID) throws IOException {
        put.verifyChangePostRequest(postID);
    }
}
