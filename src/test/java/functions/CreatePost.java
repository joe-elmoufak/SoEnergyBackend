package functions;

import org.apache.http.client.methods.HttpPost;
import utils.ResponseUtils;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static utils.HttpClient.client;
import static utils.HttpClient.response;
import static utils.ResponseUtils.BASE;

public class CreatePost {

    private static final Map<String, String> ENDPOINTS = Map.of(
            "successful", "/posts",
            "bad_request", "/postsx"
    );

    private static final Map<String, Integer> EXPECTED_RESPONSE = Map.of(
            "successful", 201,
            "bad_request", 404
    );

    private static final Map<String, Object> EXPECTED_HEADERS = Map.of(
            "Server", "cloudflare",
            "Content-Length", "15",
            "X-Ratelimit-Limit", "1000"
    );

    public void executePostRequest(String requestEndpoint) throws IOException {
        HttpPost request = new HttpPost(BASE + ENDPOINTS.get(requestEndpoint));
        response = client.execute(request);
    }

    public void verifyPostsResponse(String expectedOutcome) {
        int expectedStatus = EXPECTED_RESPONSE.get(expectedOutcome);
        assertEquals(expectedStatus,response.getStatusLine().getStatusCode());
    }

    public void verifyPostHeader(String headerToVerify) {
        String headerValue = (ResponseUtils.getHeaders(response, headerToVerify));
        assertEquals(EXPECTED_HEADERS.get(headerToVerify), headerValue);
    }
}
