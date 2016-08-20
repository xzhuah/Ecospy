package test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;

/**
 * Created by nians on 2016/8/16.
 */
public class BusinessLogicTest {
    public static void main(String[] args) {
        BusinessLogicTest test = new BusinessLogicTest();
        test.signUpTest();
//        test.signInTest();
//        test.getItemListTest();
    }

    private void updateItemListTest() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder builder = new URIBuilder("http://127.0.0.1:5678/Ecospy/servlet/main");
            URI uri = builder.build();
            System.out.println(uri.toURL().toString());
            HttpPost request = new HttpPost(uri);
            // Request body
            System.out.println("sending the request");
            request.setHeader("Request-Type", "Update-Item-List");

            StringEntity entity1 = new StringEntity("{\"userName\":\"lixutong\"," +
                    "\"password\":\"iamapig\"}");
            request.setEntity(entity1);
            HttpResponse response = httpclient.execute(request);
            System.out.println("response code is "+response.getStatusLine().getStatusCode());
            HttpEntity entity = response.getEntity();
            String result = "";
            if (entity != null)
            {
                result = EntityUtils.toString(entity,"UTF-8");
            }
            System.out.println(result);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void signUpTest() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder builder = new URIBuilder("http://127.0.0.1:5678/Ecospy/servlet/main");
            URI uri = builder.build();
            System.out.println(uri.toURL().toString());
            HttpPost request = new HttpPost(uri);
            // Request body
            System.out.println("sending the request");
            request.setHeader("Request-Type", "Sign-Up");

            StringEntity entity1 = new StringEntity("{\"userName\":\"xzhu\"," +
                    "\"password\":\"12345\"}");
            request.setEntity(entity1);
            HttpResponse response = httpclient.execute(request);
            System.out.println("response code is "+response.getStatusLine().getStatusCode());
            HttpEntity entity = response.getEntity();
            String result = "";
            if (entity != null)
            {
                result = EntityUtils.toString(entity,"UTF-8");
            }
            System.out.println(result);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void signInTest() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder builder = new URIBuilder("http://127.0.0.1:5678/Ecospy/servlet/main");
            URI uri = builder.build();
            System.out.println(uri.toURL().toString());
            HttpPost request = new HttpPost(uri);
            // Request body
            System.out.println("sending the request");
            request.setHeader("Request-Type", "Sign-In");

            StringEntity entity1 = new StringEntity("{\"userName\":\"xzhu\"," +
                    "\"password\":\"12345\"}");
            request.setEntity(entity1);
            HttpResponse response = httpclient.execute(request);
            System.out.println("response code is "+response.getStatusLine().getStatusCode());
            HttpEntity entity = response.getEntity();
            String result = "";
            if (entity != null)
            {
                result = EntityUtils.toString(entity,"UTF-8");
            }
            System.out.println(result);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void getItemListTest() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder builder = new URIBuilder("http://127.0.0.1:5678/Ecospy/servlet/main");
//			builder.addParameter("Touch-X","60");
//			builder.addParameter("Touch-Y", "235");
            URI uri = builder.build();
            System.out.println(uri.toURL().toString());
            HttpPost request = new HttpPost(uri);
            // Request body
            System.out.println("sending the request");
            request.setHeader("Request-Type", "Get-Item-List");

            StringEntity entity1 = new StringEntity("{\"userID\":\"000002\"}");
            request.setEntity(entity1);
            HttpResponse response = httpclient.execute(request);
            System.out.println("response code is "+response.getStatusLine().getStatusCode());
            HttpEntity entity = response.getEntity();
            String result = "";
            if (entity != null)
            {
                result = EntityUtils.toString(entity,"UTF-8");
            }
            System.out.println(result);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
