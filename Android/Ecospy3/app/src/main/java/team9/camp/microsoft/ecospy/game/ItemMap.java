package team9.camp.microsoft.ecospy.game;

import android.content.Context;

import java.util.HashMap;

import team9.camp.microsoft.ecospy.R;

/**
 * Created by Xinyu on 8/16/2016.
 */
public class ItemMap {
    public static HashMap<Integer ,String> Id2Name;
    public static HashMap<Integer,Integer> Id2RID;
    public static HashMap<String,String> tagStr;
    public static HashMap<String,Integer> tagType;
    public static Context context;
    static{
        Id2Name=new HashMap<Integer ,String>();
        Id2RID=new HashMap<Integer ,Integer>();
        tagStr=new HashMap<String,String>();
        tagType=new HashMap<String,Integer>();

        Id2Name.put(0,"chemical_substance");
        Id2Name.put(1,"glass");
        Id2Name.put(2,"metal");
        Id2Name.put(3,"raw_wood");
        Id2Name.put(4,"plastic");
        Id2Name.put(5,"crystal_red");
        Id2Name.put(6,"crystal_orange");
        Id2Name.put(7,"crystal_yellow");
        Id2Name.put(8,"crystal_green");
        Id2Name.put(9,"clip");
        Id2Name.put(10,"nail");
        Id2Name.put(11,"ring");
        Id2Name.put(12,"wood");
        Id2Name.put(13,"factory_plastic");
        Id2Name.put(14,"chestpin_red");
        Id2Name.put(15,"chestpin_orange");
        Id2Name.put(16,"chestpin_yellow");
        Id2Name.put(17,"chestpin_green");
        Id2Name.put(18,"bracelet_red");
        Id2Name.put(19,"bracelet_orange");
        Id2Name.put(20,"bracelet_yellow");
        Id2Name.put(21,"bracelet_green");
        Id2Name.put(22,"crystal_ring_red");
        Id2Name.put(23,"crystal_ring_orange");
        Id2Name.put(24,"crystal_ring_yellow");
        Id2Name.put(25,"crystal_ring_green");
        Id2Name.put(26,"photoframe");
        Id2Name.put(27,"sandy_clock");
        Id2Name.put(28,"closet");
        Id2Name.put(29,"door");
        Id2Name.put(30,"clock");
        Id2Name.put(31,"electronic_watch");
        Id2Name.put(32,"mechanical_watch");
        Id2Name.put(33,"smart_bracelet");
        Id2Name.put(34,"usb_light");
        Id2Name.put(35,"flash_light");
        Id2Name.put(36,"table_lamp");
        Id2Name.put(37,"chandelier");
        Id2Name.put(38,"glasses");
        Id2Name.put(39,"magnifier");
        Id2Name.put(40,"telescope");
        Id2Name.put(41,"camera");
        Id2Name.put(42,"wooden_sculpture");
        Id2Name.put(43,"wooden_desk");
        Id2Name.put(44,"wooden_ringbox_red");
        Id2Name.put(45,"ringbox_orange");
        Id2Name.put(46,"ringbox_yellow");
        Id2Name.put(47,"ringbox_green");
        Id2Name.put(48,"bank_card");
        Id2Name.put(49,"fan");
        Id2Name.put(50,"smart_ring");

        //Basic Material
        Id2RID.put(0, R.drawable.chemical_substance);
        Id2RID.put(1,R.drawable.glass);
        Id2RID.put(2,R.drawable.metal);
        Id2RID.put(3,R.drawable.raw_wood);
        Id2RID.put(4,R.drawable.plastic);

        //Low level
        Id2RID.put(5,R.drawable.crystal_red);
        Id2RID.put(6,R.drawable.crystal_orange);
        Id2RID.put(7,R.drawable.crystal_yellow);
        Id2RID.put(8,R.drawable.crystal_green);

        Id2RID.put(9,R.drawable.clip);
        Id2RID.put(10,R.drawable.nail);
        Id2RID.put(11,R.drawable.ring);
        Id2RID.put(12,R.drawable.wood);
        Id2RID.put(13,R.drawable.factory_plastic);

        //Mid Level
        Id2RID.put(14,R.drawable.chestpin_red);
        Id2RID.put(15,R.drawable.chestpin_orange);
        Id2RID.put(16,R.drawable.chestpin_yellow);
        Id2RID.put(17,R.drawable.chestpin_green);

        Id2RID.put(18,R.drawable.bracelet_red);
        Id2RID.put(19,R.drawable.bracelet_orange);
        Id2RID.put(20,R.drawable.bracelet_yellow);
        Id2RID.put(21,R.drawable.bracelet_green);

        Id2RID.put(22,R.drawable.crystal_ring_red);
        Id2RID.put(23,R.drawable.crystal_ring_orange);
        Id2RID.put(24,R.drawable.crystal_ring_yellow);
        Id2RID.put(25,R.drawable.crystal_ring_green);


        //High Level
        Id2RID.put(26,R.drawable.photoframe);
        Id2RID.put(27,R.drawable.sandy_clock);
        Id2RID.put(28,R.drawable.closet);
        Id2RID.put(29,R.drawable.door);
        Id2RID.put(30,R.drawable.clock);
        Id2RID.put(31,R.drawable.electronic_watch);
        Id2RID.put(32,R.drawable.mechanical_watch);
        Id2RID.put(33,R.drawable.smart_bracelet);
        Id2RID.put(34,R.drawable.usb_light);
        Id2RID.put(35,R.drawable.flash_light);
        Id2RID.put(36,R.drawable.table_lamp);
        Id2RID.put(37,R.drawable.chandelier);
        Id2RID.put(38,R.drawable.glasses);
        Id2RID.put(39,R.drawable.magnifier);
        Id2RID.put(40,R.drawable.telescope);
        Id2RID.put(41,R.drawable.camera);
        Id2RID.put(42,R.drawable.wooden_sculpture);
        Id2RID.put(43,R.drawable.wooden_desk);

        Id2RID.put(44,R.drawable.wooden_ringbox_red);
        Id2RID.put(45,R.drawable.wooden_ringbox_orange);
        Id2RID.put(46,R.drawable.wooden_ringbox_yellow);
        Id2RID.put(47,R.drawable.wooden_ringbox_green);

        Id2RID.put(48,R.drawable.bank_card);
        Id2RID.put(49,R.drawable.fan);
        Id2RID.put(50,R.drawable.smart_ring);






        tagType.put("electronics",1);
        tagType.put("electronic",1);
        tagType.put("mouse",1);
        tagType.put("connect",1);

        tagType.put("computer",2);
        tagType.put("laptop",2);

        tagType.put("book",3);
        tagType.put("paper",3);

        tagType.put("drink",4);
        tagType.put("beverage",4);
        tagType.put("bottle",4);
        tagType.put("can",4);
        tagType.put("cup",4);
        tagType.put("coffee",4);
        tagType.put("window",4);

        tagType.put("wooden",5);
        tagType.put("rack",5);

        tagType.put("shoes",6);
        tagType.put("bag",7);
        tagType.put("plastic",7);

        tagType.put("clothes",8);
        tagType.put("clothing",8);

        tagType.put("key",9);



    }
    public static void getStrReady(){
        try {
            String electStr = "<a href=\"" + context.getResources().getString(R.string.intro_link_elect) + "\">" + context.getResources().getString(R.string.intro_title_elect) + "</a><br>" + context.getResources().getString(R.string.intro_elect);
            tagStr.put("electronics", electStr);
            tagStr.put("mouse", electStr);
            tagStr.put("electronic", electStr);
            tagStr.put("connect", electStr);

            String compStr = "<a href=\"" + context.getResources().getString(R.string.intro_link_comp) + "\">" + context.getResources().getString(R.string.intro_title_comp) + "</a><br>" + context.getResources().getString(R.string.intro_comp);
            tagStr.put("computer", compStr);
            tagStr.put("laptop", compStr);

            String paperStr = "<a href=\"" + context.getResources().getString(R.string.intro_link_paper) + "\">" + context.getResources().getString(R.string.intro_title_paper) + "</a><br>" + context.getResources().getString(R.string.intro_paper);
            tagStr.put("book", paperStr);
            tagStr.put("paper", paperStr);

            String canStr = "<a href=\"" + context.getResources().getString(R.string.intro_link_can) + "\">" + context.getResources().getString(R.string.intro_title_can) + "</a><br>" + context.getResources().getString(R.string.intro_can);
            tagStr.put("drink", canStr);
            tagStr.put("beverage", canStr);
            tagStr.put("bottle", canStr);
            tagStr.put("can", canStr);
            tagStr.put("cup", canStr);
            tagStr.put("coffee", canStr);

            String woodStr = "<a href=\"" + context.getResources().getString(R.string.intro_link_wood) + "\">" + context.getResources().getString(R.string.intro_title_wood) + "</a><br>" + context.getResources().getString(R.string.intro_wood);
            tagStr.put("wooden", woodStr);
            tagStr.put("rack", woodStr);


            String shoesStr = "<a href=\"" + context.getResources().getString(R.string.intro_link_shoes) + "\">" + context.getResources().getString(R.string.intro_title_shoes) + "</a><br>" + context.getResources().getString(R.string.intro_shoes);
            tagStr.put("shoes", shoesStr);


            String bagStr = "<a href=\"" + context.getResources().getString(R.string.intro_link_bag) + "\">" + context.getResources().getString(R.string.intro_title_bag) + "</a><br>" + context.getResources().getString(R.string.intro_bag);
            tagStr.put("bag", bagStr);

            String plasticStr = "<a href=\"" + context.getResources().getString(R.string.intro_link_plastic) + "\">" + context.getResources().getString(R.string.intro_title_plastic) + "</a><br>" + context.getResources().getString(R.string.intro_plastic);
            tagStr.put("plastic", plasticStr);

            String clothStr = "<a href=\"" + context.getResources().getString(R.string.intro_link_cloth) + "\">" + context.getResources().getString(R.string.intro_title_cloth) + "</a><br>" + context.getResources().getString(R.string.intro_cloth);
            tagStr.put("clothes", clothStr);
            tagStr.put("clothing", clothStr);


            String windowStr = "<a href=\"" + context.getResources().getString(R.string.intro_link_window) + "\">" + context.getResources().getString(R.string.intro_title_window) + "</a><br>" + context.getResources().getString(R.string.intro_window);
            tagStr.put("window", windowStr);


            String metalStr = "<a href=\"" + context.getResources().getString(R.string.intro_link_metal) + "\">" + context.getResources().getString(R.string.intro_title_metal) + "</a><br>" + context.getResources().getString(R.string.intro_metal);
            tagStr.put("key", metalStr);
        }catch(Exception e){

        }
    }
}
