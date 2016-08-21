package team9.camp.microsoft.ecospy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Xinyu on 8/15/2016.
 */
public class PictureUploader {
    public static Context context;
    public static String login(String urlStr,String name,String pass){
        try{
            String result=new FileIO().readFile("uesrInfo.txt");
            if( result.equals(""))return "{\"item\":[{\"item_10_num\":0,\"item_5_num\":10,\"item_2_num\":10,\"item_13_num\":0,\"item_19_num\":0,\"item_4_num\":10,\"item_17_num\":0,\"item_8_num\":0,\"userID\":\"000002\",\"item_15_num\":0,\"item_6_num\":0,\"item_11_num\":0,\"item_1_num\":10,\"item_9_num\":0,\"item_18_num\":0,\"item_20_num\":0,\"item_3_num\":10,\"item_12_num\":0,\"item_14_num\":0,\"item_7_num\":0,\"item_16_num\":0}]}";
            else return result;
        }catch (Exception e){
            return "{\"item\":[{\"item_10_num\":0,\"item_5_num\":10,\"item_2_num\":10,\"item_13_num\":0,\"item_19_num\":0,\"item_4_num\":10,\"item_17_num\":0,\"item_8_num\":0,\"userID\":\"000002\",\"item_15_num\":0,\"item_6_num\":0,\"item_11_num\":0,\"item_1_num\":10,\"item_9_num\":0,\"item_18_num\":0,\"item_20_num\":0,\"item_3_num\":10,\"item_12_num\":0,\"item_14_num\":0,\"item_7_num\":0,\"item_16_num\":0}]}";

        }
         /*
        String res = "";
        HttpURLConnection conn = null;
        // String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(300000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn
                    .setRequestProperty("User-Agent",
                            "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            //conn.setRequestProperty("Content-Type",
            //       "multipart/form-data; boundary=" + BOUNDARY);
            conn.setRequestProperty("Request-Type","Sign-In");
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // text
           String content= "{\"userName\":"+"\""+name+"\",\"password\":\""+pass+"\"}";
            Log.d("Click","ResponceWait:"+content);
            out.write(content.getBytes());

            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(),"UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("发送POST请求出错。" );
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        //{user_ID:000000}
        return res;*/
    }
    public static String load(String urlStr,String id){

        try{
            String result=new FileIO().readFile("uesrInfo.txt");
            if( result.equals(""))return "{\"item\":[{\"item_10_num\":0,\"item_5_num\":10,\"item_2_num\":10,\"item_13_num\":0,\"item_19_num\":0,\"item_4_num\":10,\"item_17_num\":0,\"item_8_num\":0,\"userID\":\"000002\",\"item_15_num\":0,\"item_6_num\":0,\"item_11_num\":0,\"item_1_num\":10,\"item_9_num\":0,\"item_18_num\":0,\"item_20_num\":0,\"item_3_num\":10,\"item_12_num\":0,\"item_14_num\":0,\"item_7_num\":0,\"item_16_num\":0}]}";
            else return result;
        }catch (Exception e){
            return "{\"item\":[{\"item_10_num\":0,\"item_5_num\":10,\"item_2_num\":10,\"item_13_num\":0,\"item_19_num\":0,\"item_4_num\":10,\"item_17_num\":0,\"item_8_num\":0,\"userID\":\"000002\",\"item_15_num\":0,\"item_6_num\":0,\"item_11_num\":0,\"item_1_num\":10,\"item_9_num\":0,\"item_18_num\":0,\"item_20_num\":0,\"item_3_num\":10,\"item_12_num\":0,\"item_14_num\":0,\"item_7_num\":0,\"item_16_num\":0}]}";

        }/*
        String res = "";
        HttpURLConnection conn = null;
        // String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(300000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn
                    .setRequestProperty("User-Agent",
                            "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            //conn.setRequestProperty("Content-Type",
            //       "multipart/form-data; boundary=" + BOUNDARY);
            conn.setRequestProperty("Request-Type","Get-Item-List");
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // text
            String content= "{\"userID\":"+"\""+id+"\"}";
            Log.d("Click","ResponceWait2:"+content);
            out.write(content.getBytes());

            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(),"UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("发送POST请求出错。" );
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        //{user_ID:000000}
        return res;*/
    }
    private static byte[] compressImage(byte[] image) {
        Bitmap bm = BitmapFactory.decodeByteArray(image, 0, image.length);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 50, baos);
        return baos.toByteArray();
    }
    public static void updateUser(String urlStr,String json){
        String res = "";
        HttpURLConnection conn = null;
        // String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(300000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn
                    .setRequestProperty("User-Agent",
                            "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            //conn.setRequestProperty("Content-Type",
            //       "multipart/form-data; boundary=" + BOUNDARY);
            conn.setRequestProperty("Request-Type","Update-Item-List");
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // text
            String content= json;
            Log.d("Click","ResponceWait2:"+content);
            out.write(content.getBytes());

            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(),"UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("发送POST请求出错。" );
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        //{user_ID:000000}

    }
    public static String formUpload(String urlStr,byte[] image) {
        image=compressImage(image);
        String res = "";
        HttpURLConnection conn = null;
        // String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(300000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn
                    .setRequestProperty("User-Agent",
                            "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            //conn.setRequestProperty("Content-Type",
            //       "multipart/form-data; boundary=" + BOUNDARY);
            conn.setRequestProperty("Request-Type","Resolve-Image");
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // text

            out.write(image);

            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(),"UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("发送POST请求出错。" );
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }

    public static byte[] Image2Byte(String filePath) throws IOException{
		/*
		 * In this function the first part shows how to convert an
		 * image file to byte array.
		 * The second part of the code shows how to change byte array
		 * back to a image
		 */
        File file = new File(filePath);
        System.out.println(file.exists() + "!!");

        FileInputStream fis = new FileInputStream(file);
        //create FileInputStream which obtains input bytes from a file in a file system
        //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.

        //InputStream in = resource.openStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
                //no doubt here is 0
                //Writes len bytes from the specified byte array starting at offset
                // off to this byte array output stream.
                //System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            // Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] bytes = bos.toByteArray();
        //bytes is the ByteArray we need

        return bytes;

    }
}
