package functions;

import org.apache.http.client.methods.HttpPut;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static utils.HttpClient.client;
import static utils.HttpClient.response;
import static utils.ResponseUtils.BASE;

public class ChangePost {
    String CHANGE_POST = "/posts/";
    String ID = "id";

    public void executePutRequest(String postId) throws IOException {
        System.out.println("asdhsadjbjhasdbjasdbjasd");
        System.out.println(BASE + CHANGE_POST + postId);
        HttpPut request = new HttpPut(BASE + CHANGE_POST + postId);
        response = client.execute(request);
    }
    public void verifyChangePostRequest(Integer postId) throws IOException {
        assertEquals(200,response.getStatusLine().getStatusCode());
        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);
        assertEquals(jsonObject.get(ID),postId);
    }

}
