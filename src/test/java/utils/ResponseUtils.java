package utils;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import java.util.Arrays;
import java.util.List;

public class ResponseUtils {
    public static final String BASE = "https://jsonplaceholder.typicode.com";

    public static String getHeaders(CloseableHttpResponse response, String headerName) {
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        Header matchedHeader = httpHeaders.stream()
                .filter(header -> headerName.equalsIgnoreCase(header.getName()))
                .findFirst().orElseThrow(() -> new RuntimeException("Didnt FInd The Header"));

        return matchedHeader.getValue();
    }
}
