package team9.camp.microsoft.ecospy.game;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

import team9.camp.microsoft.ecospy.R;
import team9.camp.microsoft.ecospy.tool.UserPO;

/**
 * Created by Xinyu on 8/23/2016.
 */
public class ItemButtonGroup {
    private View.OnClickListener[][] itemlistener;
    private static final int DefaultRow=3;
    private static final int DefaultCol=3;
    private static final int DefaltResult=1;

    private int[] resultId;
    Context context;

    ItemButton[][] buttons;
    ItemButton[] results;

    private HashMap<Integer,Integer> localItems;

    private HashMap<Integer, Integer> mitembag;

    public ItemButtonGroup(Context context){
        this.context=context;

        buttons=new ItemButton[DefaultRow][DefaultCol];
        results=new ItemButton[DefaltResult];


        resultId=new int[DefaltResult];
        itemlistener=new View.OnClickListener[DefaultRow][DefaultCol];
        localItems=new HashMap<Integer,Integer>();
        for(int i=0;i<buttons.length;i++){
            for(int j=0;j<buttons[i].length;j++){
                buttons[i][j]=new ItemButton(context);
            }
        }
        for(int i=0;i<results.length;i++){
            results[i]=new ItemButton(context);
        }

        initListener();
    }

    public ItemButtonGroup(Context context,int row,int col,int result){
        this.context=context;
        buttons=new ItemButton[row][col];
        results=new ItemButton[result];

        resultId=new int[result];
        itemlistener=new View.OnClickListener[row][col];
        localItems=new HashMap<Integer,Integer>();
        for(int i=0;i<buttons.length;i++){
            for(int j=0;j<buttons[i].length;j++){
                buttons[i][j]=new ItemButton(context);
            }
        }
        for(int i=0;i<results.length;i++){
            results[i]=new ItemButton(context);
        }

        initListener();
    }

    public void setItemButton(ImageButton ib,int row,int col){
        this.buttons[row][col].setButton(ib);
    }
    public void setResultButton(ImageButton ib,int i){
        this.results[i].setButton(ib);
    }
    public void setTextView(TextView v,int i){
        this.results[i].setTextView(v);
    }


    private void setItemAt(int itemid,int x,int y){
        int oid=buttons[x][y].getID();
        buttons[x][y].setItem(itemid);
        if(oid!=-1){
            localItems.put(oid,localItems.get(oid)-1);
            if(itemid!=-1){
                try {
                    localItems.put(itemid, localItems.get(itemid) + 1);
                }catch (Exception e){
                    localItems.put(itemid,1);
                }
            }
        }else{
            try {
                localItems.put(itemid, localItems.get(itemid) + 1);
            }catch (Exception e){
                localItems.put(itemid,1);
            }
        }

    }
    private int countObj(int id){
        Object obj=localItems.get(id);
        if(obj!=null){
            return (int)obj;
        }else{
            return 0;
        }
    }
    private void initListener(){
        for(int i=0;i<itemlistener.length;i++){
            for(int j=0;j<itemlistener[i].length;j++){
                final int finalI = i;
                final int finalJ = j;
                itemlistener[i][j]=new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                            //Get item list to be shown

                            Set<Integer> set = UserPO.itembag.keySet();
                            Vector<Integer> validItem=new Vector<Integer>();
                           for(int key:set){
                                int num= UserPO.itembag.get(key)-ItemButtonGroup.this.countObj(key);
                               if(num>0) validItem.add(key);
                           }
                            int[] itemlist= new int[validItem.size()];
                            for(int i=0;i<itemlist.length;i++) itemlist[i]=validItem.get(i);


                            //show itemlist//Add Listener to itemlist
                            verifyDialog(itemlist,finalI,finalJ);

                        }

                };
            }
        }

    }

    public void addListener(){
        for(int i=0;i<buttons.length;i++){
            for(int j=0;j<buttons[i].length;j++){
                buttons[i][j].getButton().setOnClickListener(itemlistener[i][j]);
            }
        }
        for(int i=0;i<results.length;i++){
            results[i].getButton().setOnClickListener(resultlistener);
        }
    }



    public void initView(int[] viewID){

    }
    private int[] getKey(){
        int [] result=new int[this.buttons.length*this.buttons[0].length];
        for(int i=0;i<this.buttons.length;i++){
            for(int j=0;j<this.buttons[0].length;j++){
                result[i*this.buttons[0].length+j]=buttons[i][j].getID();
            }
        }
        return result;
    }
    private String getKey2(){
      String result="";
        int ii[]=getKey();
        for(int i=0;i<ii.length;i++){
            result+=ii[i]+",";
        }
        return result.substring(0,result.length()-1);
    }

    private int getResult(){
        int[] key=getKey();
        String strkey="";
        for(int i=0;i<key.length;i++){
            strkey+=key[i]+",";
        }
        strkey=strkey.replace("-1,", "");
        if( strkey.endsWith(",")){
            strkey= strkey.substring(0, strkey.length()-1);
        }
        Object result= ObjectGen.objectGen.get(strkey);
        int resultid=-1;
        if(result!=null) resultid=(int)result;
        return  resultid;

    }

    private int getResult(int [] key){
        String strkey="";
        for(int i=0;i<key.length;i++){
            strkey+=key[i]+",";
        }
        strkey=strkey.replace("-1,", "");
        if( strkey.endsWith(",")){
            strkey= strkey.substring(0, strkey.length()-1);
        }
        Object result=ObjectGen.objectGen.get(strkey);
        int resultid=-1;
        if(result!=null) resultid=(int)result;
        return  resultid;

    }

    private View.OnClickListener resultlistener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id=(int)v.getTag();//id is the id of the image [0~50]
            if(id==-1) return;

            int ids[]=new int[buttons.length*buttons[0].length];
            for(int i=0;i<buttons.length;i++){
                for(int j=0;j<buttons[0].length;j++){
                    ids[i*buttons[0].length+j]=buttons[i][j].getID();
                    if(ids[i*buttons[0].length+j]!=-1){
                        UserPO.itembag.put(ids[i*buttons[0].length+j], UserPO.itembag.get(ids[i*buttons[0].length+j])-1);
                        try{
                            ItemButtonGroup.this.localItems.put(ids[i*buttons[0].length+j],ItemButtonGroup.this.localItems.get(ids[i*buttons[0].length+j])-1);
                        }catch (Exception e){
                            ItemButtonGroup.this.localItems.put(ids[i*buttons[0].length+j],0);
                        }
                    }
                    buttons[i][j].init();


                }
            }



            // updateUserInfo();
            UserPO.itembag.put(id, UserPO.itembag.get(id)+1);

            UserPO.updateOnline();


            //updateUI

            for(int i=0;i<ItemButtonGroup.this.results.length;i++){
                ItemButtonGroup.this.results[i].init();
            }



        }
    };



    private static int tempID;
    private Dialog dialog;
    private void verifyDialog(int[] buttonlist, final int rowx, final int coly)
    {


        dialog = new Dialog(context, R.style.popupDialog);
        dialog.setContentView(R.layout.itemlist);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        //ImageButton btn1_1=(ImageButton)
        ImageButton[][] buttons=new ImageButton[12][7];


        buttons[0][0]=(ImageButton)dialog.findViewById(R.id.item_11);
        buttons[0][1]=(ImageButton)dialog.findViewById(R.id.item_12);
        buttons[0][2]=(ImageButton)dialog.findViewById(R.id.item_13);
        buttons[0][3]=(ImageButton)dialog.findViewById(R.id.item_14);
        buttons[0][4]=(ImageButton)dialog.findViewById(R.id.item_15);
        buttons[0][5]=(ImageButton)dialog.findViewById(R.id.item_16);
        buttons[0][6]=(ImageButton)dialog.findViewById(R.id.item_17);
        buttons[1][0]=(ImageButton)dialog.findViewById(R.id.item_21);
        buttons[1][1]=(ImageButton)dialog.findViewById(R.id.item_22);
        buttons[1][2]=(ImageButton)dialog.findViewById(R.id.item_23);
        buttons[1][3]=(ImageButton)dialog.findViewById(R.id.item_24);
        buttons[1][4]=(ImageButton)dialog.findViewById(R.id.item_25);
        buttons[1][5]=(ImageButton)dialog.findViewById(R.id.item_26);
        buttons[1][6]=(ImageButton)dialog.findViewById(R.id.item_27);
        buttons[2][0]=(ImageButton)dialog.findViewById(R.id.item_31);
        buttons[2][1]=(ImageButton)dialog.findViewById(R.id.item_32);
        buttons[2][2]=(ImageButton)dialog.findViewById(R.id.item_33);
        buttons[2][3]=(ImageButton)dialog.findViewById(R.id.item_34);
        buttons[2][4]=(ImageButton)dialog.findViewById(R.id.item_35);
        buttons[2][5]=(ImageButton)dialog.findViewById(R.id.item_36);
        buttons[2][6]=(ImageButton)dialog.findViewById(R.id.item_37);
        buttons[3][0]=(ImageButton)dialog.findViewById(R.id.item_41);
        buttons[3][1]=(ImageButton)dialog.findViewById(R.id.item_42);
        buttons[3][2]=(ImageButton)dialog.findViewById(R.id.item_43);
        buttons[3][3]=(ImageButton)dialog.findViewById(R.id.item_44);
        buttons[3][4]=(ImageButton)dialog.findViewById(R.id.item_45);
        buttons[3][5]=(ImageButton)dialog.findViewById(R.id.item_46);
        buttons[3][6]=(ImageButton)dialog.findViewById(R.id.item_47);
        buttons[4][0]=(ImageButton)dialog.findViewById(R.id.item_51);
        buttons[4][1]=(ImageButton)dialog.findViewById(R.id.item_52);
        buttons[4][2]=(ImageButton)dialog.findViewById(R.id.item_53);
        buttons[4][3]=(ImageButton)dialog.findViewById(R.id.item_54);
        buttons[4][4]=(ImageButton)dialog.findViewById(R.id.item_55);
        buttons[4][5]=(ImageButton)dialog.findViewById(R.id.item_56);
        buttons[4][6]=(ImageButton)dialog.findViewById(R.id.item_57);
        buttons[5][0]=(ImageButton)dialog.findViewById(R.id.item_61);
        buttons[5][1]=(ImageButton)dialog.findViewById(R.id.item_62);
        buttons[5][2]=(ImageButton)dialog.findViewById(R.id.item_63);
        buttons[5][3]=(ImageButton)dialog.findViewById(R.id.item_64);
        buttons[5][4]=(ImageButton)dialog.findViewById(R.id.item_65);
        buttons[5][5]=(ImageButton)dialog.findViewById(R.id.item_66);
        buttons[5][6]=(ImageButton)dialog.findViewById(R.id.item_67);
        buttons[6][0]=(ImageButton)dialog.findViewById(R.id.item_71);
        buttons[6][1]=(ImageButton)dialog.findViewById(R.id.item_72);
        buttons[6][2]=(ImageButton)dialog.findViewById(R.id.item_73);
        buttons[6][3]=(ImageButton)dialog.findViewById(R.id.item_74);
        buttons[6][4]=(ImageButton)dialog.findViewById(R.id.item_75);
        buttons[6][5]=(ImageButton)dialog.findViewById(R.id.item_76);
        buttons[6][6]=(ImageButton)dialog.findViewById(R.id.item_77);
        buttons[7][0]=(ImageButton)dialog.findViewById(R.id.item_81);
        buttons[7][1]=(ImageButton)dialog.findViewById(R.id.item_82);
        buttons[7][2]=(ImageButton)dialog.findViewById(R.id.item_83);
        buttons[7][3]=(ImageButton)dialog.findViewById(R.id.item_84);
        buttons[7][4]=(ImageButton)dialog.findViewById(R.id.item_85);
        buttons[7][5]=(ImageButton)dialog.findViewById(R.id.item_86);
        buttons[7][6]=(ImageButton)dialog.findViewById(R.id.item_87);
        buttons[8][0]=(ImageButton)dialog.findViewById(R.id.item_91);
        buttons[8][1]=(ImageButton)dialog.findViewById(R.id.item_92);
        buttons[8][2]=(ImageButton)dialog.findViewById(R.id.item_93);
        buttons[8][3]=(ImageButton)dialog.findViewById(R.id.item_94);
        buttons[8][4]=(ImageButton)dialog.findViewById(R.id.item_95);
        buttons[8][5]=(ImageButton)dialog.findViewById(R.id.item_96);
        buttons[8][6]=(ImageButton)dialog.findViewById(R.id.item_97);
        buttons[9][0]=(ImageButton)dialog.findViewById(R.id.item_101);
        buttons[9][1]=(ImageButton)dialog.findViewById(R.id.item_102);
        buttons[9][2]=(ImageButton)dialog.findViewById(R.id.item_103);
        buttons[9][3]=(ImageButton)dialog.findViewById(R.id.item_104);
        buttons[9][4]=(ImageButton)dialog.findViewById(R.id.item_105);
        buttons[9][5]=(ImageButton)dialog.findViewById(R.id.item_106);
        buttons[9][6]=(ImageButton)dialog.findViewById(R.id.item_107);
        buttons[10][0]=(ImageButton)dialog.findViewById(R.id.item_111);
        buttons[10][1]=(ImageButton)dialog.findViewById(R.id.item_112);
        buttons[10][2]=(ImageButton)dialog.findViewById(R.id.item_113);
        buttons[10][3]=(ImageButton)dialog.findViewById(R.id.item_114);
        buttons[10][4]=(ImageButton)dialog.findViewById(R.id.item_115);
        buttons[10][5]=(ImageButton)dialog.findViewById(R.id.item_116);
        buttons[10][6]=(ImageButton)dialog.findViewById(R.id.item_117);
        buttons[11][0]=(ImageButton)dialog.findViewById(R.id.item_121);
        buttons[11][1]=(ImageButton)dialog.findViewById(R.id.item_122);
        buttons[11][2]=(ImageButton)dialog.findViewById(R.id.item_123);
        buttons[11][3]=(ImageButton)dialog.findViewById(R.id.item_124);
        buttons[11][4]=(ImageButton)dialog.findViewById(R.id.item_125);
        buttons[11][5]=(ImageButton)dialog.findViewById(R.id.item_126);
        buttons[11][6]=(ImageButton)dialog.findViewById(R.id.item_127);

        for(int i=0;i<buttons.length;i++){
            for(int j=0;j<buttons[i].length;j++){
                buttons[i][j].setTag(i * buttons[0].length + j);
            }
        }


        //Click to remove
        for(int i=0;i<buttons.length;i++){
            for(int j=0;j<buttons[i].length;j++){
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        results[0].init();
                        int oid = ItemButtonGroup.this.buttons[rowx][coly].getID();
                        ItemButtonGroup.this.buttons[rowx][coly].init();
                        try {
                            ItemButtonGroup.this.localItems.put(oid, ItemButtonGroup.this.localItems.get(oid) - 1);
                        } catch (Exception e) {
                            ItemButtonGroup.this.localItems.put(oid, 0);
                        }

                        int resultid=getResult();
                        Log.d("Click","Array is "+getKey2());
                        try{
                            resultid=ObjectGen.objectGen2.get(getKey2());
                        }catch (Exception e){

                        }


                        results[0].setItem(resultid);

                        dialog.dismiss();
                        dialog=null;
                    }
                });
            }
        }




        for(int i=0;i<buttonlist.length;i++){
            tempID=buttonlist[i];
            int row=tempID/7;
            int col=tempID%7;
            int id;
            try {
                id = ItemMap.Id2RID.get(tempID);
            }catch (Exception e){
                continue;
            }
            if(buttons[row][col]!=null) {
                buttons[row][col].setBackgroundResource(id);
                // Log.d("ERROR", "Col" + col + " Row" + row + " " + buttons[row][col].toString());
            }else{
                // Log.d("ERROR", "Col" + col + " Row" + row + " " );
                return;
            }


            buttons[row][col].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Initialize result
                    for(int i=0;i<ItemButtonGroup.this.results.length;i++){
                        ItemButtonGroup.this.results[i].init();
                    }

                   ItemButton caller=ItemButtonGroup.this.buttons[rowx][coly];


                    int oid=caller.getID();

                    try{
                        ItemButtonGroup.this.localItems.put(oid,ItemButtonGroup.this.localItems.get(oid)-1);
                    }catch (Exception e){
                        ItemButtonGroup.this.localItems.put(oid,0);
                    }

                    caller.setItem((int) v.getTag());

                    int nid=caller.getID();
                    try{
                        ItemButtonGroup.this.localItems.put(nid,ItemButtonGroup.this.localItems.get(nid)+1);
                    }catch (Exception e){
                        ItemButtonGroup.this.localItems.put(nid,1);
                    }

                    int resultid=getResult();
                    Log.d("Click","Array is "+getKey2());
                    try{
                        resultid=ObjectGen.objectGen2.get(getKey2());
                    }catch (Exception e){

                    }
                    results[0].setItem(resultid);

                    dialog.dismiss();
                    dialog=null;
                }
            });
        }
        if(dialog!=null && !dialog.isShowing())
        {
            dialog.show();
        }
    }



}
