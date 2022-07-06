package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.picocontainer.annotations.Inject;

import java.io.IOException;

public class CreatePost {
    @Inject
    functions.CreatePost post;

    @Given("I verify that the Post returns a {string} status code")
    public void I_verify_that_the_post_returns_a_status_code(String statusCode) {
        post.verifyPostsResponse(statusCode);
    }

    @Then("I verify that the {string} header is returned with the expected value")
    public void iVerifyThatTheHeaderIsReturnedWithTheExpectedValue(String header) {
        post.verifyPostHeader(header);
    }

    @Given("I execute a {string} request when creating a new post")
    public void iExecuteARequestWhenCreatingANewPost(String request) throws IOException {
        post.executePostRequest(request);
    }
}
