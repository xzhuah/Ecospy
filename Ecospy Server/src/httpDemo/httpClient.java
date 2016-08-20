package httpDemo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

import ecospy.server.Utility.IntStringWrapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class httpClient {

    public static void main(String[] args) {
//        test1();


    }

    public static void APIServerTest(){

    }

    public static void test2(){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try{
            URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/vision/v1.0/tag");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/octet-stream");
            request.setHeader("Ocp-Apim-Subscription-Key", "19d222efe0a543ff880ee2b56f0766df");


            // Request body
            ByteArrayEntity reqEntity = new ByteArrayEntity(getImageBinary());
            request.setEntity(reqEntity);


            HttpResponse response = httpclient.execute(request);

            HttpEntity entity = response.getEntity();
            String result = "";
            if (entity != null)
            {
                result = EntityUtils.toString(entity,"UTF-8");
            }
            System.out.println(result);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test1(){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try
        {
            URIBuilder builder = new URIBuilder("http://139.129.40.103:5678/Ecospy/servlet/main");
//			builder.addParameter("Touch-X","60");
//			builder.addParameter("Touch-Y", "235");
            URI uri = builder.build();
            System.out.println(uri.toURL().toString());
            HttpPost request = new HttpPost(uri);
            // Request body
            System.out.println("sending the request");
            request.setHeader("Request-Type", "Resolve-Image");

            ByteArrayEntity entity1 = new ByteArrayEntity(getImageBinary());
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

    static byte[] getImageBinary(){
        File f = new File("C:\\users\\nians\\desktop\\2.jpg");
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            return bytes;
            //			return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    static void writeImage(byte[] src) throws IOException{
        byte[] b = src;//传来的图片信息byte数组

        String URL="C:\\3.jpg";

        File file=new File(URL);

        FileOutputStream fos=new FileOutputStream(file);

        fos.write(b,0,b.length);

        fos.flush();

        fos.close();
    }
}
