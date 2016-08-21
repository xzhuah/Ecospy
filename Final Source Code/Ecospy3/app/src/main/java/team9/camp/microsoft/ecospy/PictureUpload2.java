package team9.camp.microsoft.ecospy;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 *
 * Created by Xinyu on
 * 8/20/2016.
 */
public class PictureUpload2 {

    public static String urladdress="https://api.projectoxford.ai/vision/v1.0/tag";
    private static String key="a69c03eb83a44ec789045ffee811a228";
        public static String uploadPicture(byte[] pic) throws URISyntaxException, IOException {
            URL obj = new URL(urladdress);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            //con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type", "application/octet-stream");
            con.setRequestProperty("Ocp-Apim-Subscription-Key", key);
            con.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.write(pic);
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
   //         String res=response.toString();
//            try {
//                JSONObject jobj = new JSONObject(res);
//                Log.d("JSON","JSON:"+jobj.toString());
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
            return response.toString();
    }

}
