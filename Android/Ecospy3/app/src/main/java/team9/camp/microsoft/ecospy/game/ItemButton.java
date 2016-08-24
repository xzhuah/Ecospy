package team9.camp.microsoft.ecospy.game;

import android.content.Context;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import team9.camp.microsoft.ecospy.R;

/**
 * Created by Xinyu on 8/23/2016.
 */
public class ItemButton{

    private Context context;
    private int x;
    private int y;
    private final static String defaultName="None";
    private final static int defaultID=-1;
    private final static int defaultResourceID= R.drawable.question;
    private int backgroundID;
    private String itemname;
    private int num;
    private TextView numText;
    private ImageButton imb;



    public ItemButton(Context context) {

        this.context=context;

        backgroundID=defaultID;
        this.itemname=defaultName;
        this.x=0;
        this.y=0;
        num=0;

    }

    public ItemButton(Context context,int x,int y) {

        this.context=context;


        backgroundID=defaultID;
        this.itemname=defaultName;
        this.x=x;
        this.y=y;
        num=0;
    }

    public ImageButton getButton(){
        return imb;
    }
    public void setButton(ImageButton ib){
        imb=ib;
        imb.setTag(-1);
        this.setBackgroundResource(defaultResourceID);
    }
    public void setBackgroundResource(int id){
        try{
            imb.setBackgroundResource(id);
        }catch (Exception e){
            imb.setBackgroundResource(ItemMap.Id2RID.get(id));
        }
    }
    public ItemButton(Context context,ImageButton imageButton,int x,int y,TextView textView) {
        this(context,x,y);
        this.numText=textView;
    }
    public void setTextView(TextView text){
        this.numText=text;
    }
    public void setRow(int x){
       this.x=x;
    }
    public void setCol(int y){
       this.y=y;
    }
    public int getRow(){
        return x;
    }
    public int getCol(){
        return y;
    }
    public int getID(){
        return this.backgroundID;
    }
    public int getResourceID(){
        try {
            return ItemMap.Id2RID.get(this.backgroundID);
        }catch (Exception e){
            return -1;
        }
    }

    public void setNum(int num){
        this.num=num;
        if(numText!=null) numText.setText(""+num);
    }
    public void setItem(int backid){
        try{
            this.setBackgroundResource(backid);
            this.backgroundID=backid;
            this.itemname=ItemMap.Id2Name.get(backid);
            this.imb.setTag(backid);
        }catch(Exception e){
            Log.d("FUCK","At "+e);
            this.backgroundID=defaultID;
            this.itemname=defaultName;
            this.imb.setTag(-1);
        }
        if(backid!=-1){
            this.setNum(1);
        }else{
            this.setNum(0);
        }
    }
    public void init(){
        this.backgroundID=defaultID;
        this.itemname=defaultName;
        this.setBackgroundResource(defaultResourceID);
        this.imb.setTag(defaultID);
        try {
            this.numText.setText("0");
        }catch (Exception e){

        }
    }
    public static void init(ImageButton ib){
        ib.setBackgroundResource(defaultResourceID);
        ib.setTag(defaultID);
    }

}
