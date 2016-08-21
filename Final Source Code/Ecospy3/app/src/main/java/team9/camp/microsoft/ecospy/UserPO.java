package team9.camp.microsoft.ecospy;

import android.content.Context;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class UserPO {
    public static Context context;

    public static String userID;

    public static HashMap<Integer, Integer> itembag;
    public static String server="http://192.168.43.82:5678/Ecospy/servlet/main";




    public static HashMap<Integer, Integer> getItemList(String str) {
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        int number=-1, count;
       while(str.contains("_")){
           str=str.substring(str.indexOf("_")+1,str.length());
           int id=Integer.parseInt(str.substring(0,str.indexOf("_")));
          str=str.substring(str.indexOf(":")+1,str.length());
           int num=0;
           if(str.contains("_")){
               num=Integer.parseInt(str.substring(0,str.indexOf(",")));
           }else{

               num=Integer.parseInt(str.substring(0,str.indexOf(",")));

           }
           result.put(id,num);

       }
        return result;
    }



    public static String getJson(){
        String result="{";
        Set<Integer> s = itembag.keySet();
        for(Integer i:s){
            result+="\"item_";
            result+=i;
            result+="_num\":";
            result+=itembag.get(i);
            result+=",";
        }
        String id=""+userID;
        while(id.length()<6){
            id="0"+id;
        }
        result+="\"userID\":\""+id+"\"}";
        return result;
    }
    public static int[] getOwnedId(){
        Vector<Integer> vec=new Vector<Integer>();
        Set<Integer> s = itembag.keySet();
        for(int i:s){
           int a=(int)itembag.get(i);
            if(a>0){
                vec.add(i);
            }
        }
        int result[]=new int[vec.size()];
        for(int i=0;i<result.length;i++){
            result[i]=vec.get(i);
        }
        return result;
    }
    public static void updateOnline(){
        new Thread(){
            public void run(){
                //PictureUploader.updateUser(server, getJson());
                try {
                    new FileIO(context).writeFile("uesrInfo.txt", getJson());
                }catch (Exception e){

                }
            }
        }.start();

    }



    }
