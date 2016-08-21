package team9.camp.microsoft.ecospy;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Xinyu on 8/20/2016.
 */
public class FileIO {

    Context context;
    public FileIO(Context context){
        this.context=context;
    }
    public void writeFile(String fileName,String writestr) throws IOException{
        try{

            FileOutputStream fout = context.openFileOutput(fileName, context.MODE_PRIVATE);

            byte [] bytes = writestr.getBytes();

            fout.write(bytes);

            fout.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

    //读数据
    public String readFile(String fileName) throws IOException {
        String res="";
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    context.openFileInput(fileName),"UTF-8"));

            StringBuffer strBuf = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return res;

    }
}
