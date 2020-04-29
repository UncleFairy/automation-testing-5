import headers.ResponseHeader;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import statuses.Get200;
import statuses.Get401;
import statuses.Get404;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class TestClass {
    public TestClass() {
        webClient = HttpClients.createDefault();
        get200 = new Get200();
        get401 = new Get401();
        get404 = new Get404();
        expectedResponseHeader = new ResponseHeader("content-encoding", "gzip");
    }

    private CloseableHttpClient webClient;
    private CloseableHttpResponse response;

    private final String HOST = "https://api.github.com";
    private final Get200 get200;
    private final Get401 get401;
    private final Get404 get404;
    private final ResponseHeader expectedResponseHeader;

    @BeforeMethod
    public void testSetUp() {
        webClient = HttpClients.createDefault();
    }

    @AfterMethod
    public void testDown() throws IOException {
        webClient.close();
    }

    @Test
    public void status_200_reached() throws IOException {
        HttpGet request = new HttpGet(HOST + get200.getSegmentPath());
        response = webClient.execute(request);
        int resultCode = response.getStatusLine().getStatusCode();

        assertEquals(resultCode, get200.getStatusCode(), "200 status has not been reached");
    }

    @Test
    public void status_401_reached() throws IOException {
        HttpGet request = new HttpGet(HOST + get401.getSegmentPath());
        response = webClient.execute(request);
        int actualResultCode = response.getStatusLine().getStatusCode();

        assertEquals(actualResultCode, get401.getStatusCode(), "401 status has not been reached");
    }

    @Test
    public void status_404_reached() throws IOException {
        HttpGet request = new HttpGet(HOST + get404.getSegmentPath());
        response = webClient.execute(request);
        int actualResultCode = response.getStatusLine().getStatusCode();

        assertEquals(actualResultCode, get404.getStatusCode(), "404 status has not been reached");
    }

    @Test
    public void header_value_matches() throws IOException {
        HttpGet request = new HttpGet(HOST + get200.getSegmentPath());
        response = webClient.execute(request);
        Header header = response.getFirstHeader(expectedResponseHeader.getHeaderName());

        assertNotNull(header, "header is present");
        assertEquals(header.getValue(), expectedResponseHeader.getHeaderValue(), "header is present");
    }
}
