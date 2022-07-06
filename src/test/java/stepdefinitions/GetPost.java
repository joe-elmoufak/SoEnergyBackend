package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.picocontainer.annotations.Inject;

import java.io.IOException;

public class GetPost {
    @Inject
    functions.GetPost get;

    @Given("I execute a request to retrieve a post")
    public void iExecuteARequestToRetrieveAPost() throws IOException {
        get.executeGetPostRequest();
    }

    @Then("I cycle through each post that is returned and verify the email addresses are in a valid format")
    public void iCycleThroughEachPostThatIsReturnedAndVerifyTheEmailAddressesAreInAValidFormat() throws IOException {
        get.verifyEmailsAreValid();
    }


}
