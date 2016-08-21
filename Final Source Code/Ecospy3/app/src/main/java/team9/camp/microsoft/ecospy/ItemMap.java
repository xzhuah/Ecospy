package team9.camp.microsoft.ecospy;

import java.util.HashMap;

/**
 * Created by Xinyu on 8/16/2016.
 */
public class ItemMap {
    public static HashMap<Integer ,String> Id2Name;
    public static HashMap<Integer,Integer> Id2RID;
    public static HashMap<String,String> tagStr;
    public static HashMap<String,Integer> tagType;
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

        Id2RID.put(0,R.drawable.chemical_substance);
        Id2RID.put(1,R.drawable.glass);
        Id2RID.put(2,R.drawable.metal);
        Id2RID.put(3,R.drawable.raw_wood);
        Id2RID.put(4,R.drawable.plastic);
        Id2RID.put(5,R.drawable.crystal_red);
        Id2RID.put(6,R.drawable.crystal_orange);
        Id2RID.put(7,R.drawable.crystal_yellow);
        Id2RID.put(8,R.drawable.crystal_green);
        Id2RID.put(9,R.drawable.clip);
        Id2RID.put(10,R.drawable.nail);
        Id2RID.put(11,R.drawable.ring);
        Id2RID.put(12,R.drawable.wood);
        Id2RID.put(13,R.drawable.factory_plastic);
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

        tagStr.put("electronics","<a href=\"http://baike.baidu.com/subview/1379716/1379716.htm\">电子产品</a><br>电子废弃物中所蕴含的金属，尤其是贵金属，其品位是天然矿藏的几十倍甚至几百倍回收成本一般低于开采自然矿床。有研究分析结果显示，1吨随意搜集的电子板卡中，可以分离出143kg铜、0.5kg黄金、40.8kg铁、29.5kg铅、2.0kg锡、18.1kg镍、10.0kg锑");
        tagStr.put("mouse","<a href=\"http://baike.baidu.com/subview/1379716/1379716.htm\">电子产品</a><br>电子废弃物中所蕴含的金属，尤其是贵金属，其品位是天然矿藏的几十倍甚至几百倍回收成本一般低于开采自然矿床。有研究分析结果显示，1吨随意搜集的电子板卡中，可以分离出143kg铜、0.5kg黄金、40.8kg铁、29.5kg铅、2.0kg锡、18.1kg镍、10.0kg锑");
        tagStr.put("electronic","<a href=\"http://baike.baidu.com/subview/1379716/1379716.htm\">电子产品</a><br>电子废弃物中所蕴含的金属，尤其是贵金属，其品位是天然矿藏的几十倍甚至几百倍回收成本一般低于开采自然矿床。有研究分析结果显示，1吨随意搜集的电子板卡中，可以分离出143kg铜、0.5kg黄金、40.8kg铁、29.5kg铅、2.0kg锡、18.1kg镍、10.0kg锑");
        tagStr.put("connect","<a href=\"http://baike.baidu.com/subview/1379716/1379716.htm\">电子产品</a><br>电子废弃物中所蕴含的金属，尤其是贵金属，其品位是天然矿藏的几十倍甚至几百倍回收成本一般低于开采自然矿床。有研究分析结果显示，1吨随意搜集的电子板卡中，可以分离出143kg铜、0.5kg黄金、40.8kg铁、29.5kg铅、2.0kg锡、18.1kg镍、10.0kg锑");

        tagStr.put("computer","<a href=\"https://www.wastereduction.gov.hk/tc/workplace/crp_intro.htm\">电脑</a><br>電腦產品含有可以對人體和環境有害的物質。因此，我們不應隨意更換電腦，以助減少產生電腦廢物。如果確實有需要更換，則應盡量把舊電腦循環再用和回收再造。電腦所含的零件和物料，例如金屬和塑膠等，其實可以回收再用。一些廢棄的電腦只要修理妥當，更可翻新成二手機再用。");
        tagStr.put("laptop","<a href=\"https://www.wastereduction.gov.hk/tc/workplace/crp_intro.htm\">电脑</a><br>電腦產品含有可以對人體和環境有害的物質。因此，我們不應隨意更換電腦，以助減少產生電腦廢物。如果確實有需要更換，則應盡量把舊電腦循環再用和回收再造。電腦所含的零件和物料，例如金屬和塑膠等，其實可以回收再用。一些廢棄的電腦只要修理妥當，更可翻新成二手機再用。");

        tagStr.put("book","<a href=\"http://wenku.baidu.com/link?url=h32vM-HUE92HEYgV4mIK_xF83Uiy01A1IBCxyNnGk2xyxcy_f60iBWbakHtVT5Pl-HnLoCXk0kVIj5rPuroEH6sDEJoFgunljcPzB6_yKru\">废纸</a><br>造1吨纸需要约3立方米的木材，相当于二十几棵树木，我国年造纸消耗木材大约在1000万立方米。因此，回收废纸制造再生纸可以缓解造纸原料不足的状况。此外，废纸还有许多其他的综合利用途径，减少污染的同时，还充分发挥了废纸的再利用价值。");
        tagStr.put("paper","<a href=\"http://wenku.baidu.com/link?url=h32vM-HUE92HEYgV4mIK_xF83Uiy01A1IBCxyNnGk2xyxcy_f60iBWbakHtVT5Pl-HnLoCXk0kVIj5rPuroEH6sDEJoFgunljcPzB6_yKru\">废纸</a><br>造1吨纸需要约3立方米的木材，相当于二十几棵树木，我国年造纸消耗木材大约在1000万立方米。因此，回收废纸制造再生纸可以缓解造纸原料不足的状况。此外，废纸还有许多其他的综合利用途径，减少污染的同时，还充分发挥了废纸的再利用价值。");


        tagStr.put("drink","<a href=\"http://www.epd.gov.hk/epd/sc_chi/environmentinhk/waste/eco_responsibility/gcrp_pilot_ssp_ha.html\">瓶子或杯子</a>玻璃，玲瓏剔透，無毒可重用，壓碎後又可製成環保磚或鋪路，可是它的回收價值比紙皮、膠樽還要低");
        tagStr.put("beverage","<a href=\"http://www.epd.gov.hk/epd/sc_chi/environmentinhk/waste/eco_responsibility/gcrp_pilot_ssp_ha.html\">瓶子或杯子</a>玻璃，玲瓏剔透，無毒可重用，壓碎後又可製成環保磚或鋪路，可是它的回收價值比紙皮、膠樽還要低");
        tagStr.put("bottle","<a href=\"http://www.epd.gov.hk/epd/sc_chi/environmentinhk/waste/eco_responsibility/gcrp_pilot_ssp_ha.html\">瓶子或杯子</a>玻璃，玲瓏剔透，無毒可重用，壓碎後又可製成環保磚或鋪路，可是它的回收價值比紙皮、膠樽還要低");
        tagStr.put("can","<a href=\"http://www.epd.gov.hk/epd/sc_chi/environmentinhk/waste/eco_responsibility/gcrp_pilot_ssp_ha.html\">瓶子或杯子</a>玻璃，玲瓏剔透，無毒可重用，壓碎後又可製成環保磚或鋪路，可是它的回收價值比紙皮、膠樽還要低");
        tagStr.put("cup","<a href=\"http://www.epd.gov.hk/epd/sc_chi/environmentinhk/waste/eco_responsibility/gcrp_pilot_ssp_ha.html\">瓶子或杯子</a>玻璃，玲瓏剔透，無毒可重用，壓碎後又可製成環保磚或鋪路，可是它的回收價值比紙皮、膠樽還要低");
        tagStr.put("coffee","<a href=\"http://www.epd.gov.hk/epd/sc_chi/environmentinhk/waste/eco_responsibility/gcrp_pilot_ssp_ha.html\">瓶子或杯子</a>玻璃，玲瓏剔透，無毒可重用，壓碎後又可製成環保磚或鋪路，可是它的回收價值比紙皮、膠樽還要低");

        tagStr.put("wooden","<a href=\"https://theinitium.com/article/20151118-hongkong-woodrecycle01/\">木材</a><br>绝大多数木卡板的最终命运，是被视为无用的垃圾，送往垃圾堆填区。");
        tagStr.put("rack","<a href=\"https://theinitium.com/article/20151118-hongkong-woodrecycle01/\">木架</a><br>绝大多数木卡板的最终命运，是被视为无用的垃圾，送往垃圾堆填区。");

        tagStr.put("shoes","<a href=\"http://topick.hket.com/article/1431966/%E8%88%8A%E9%9E%8B%E6%95%91%E5%91%BD%20%E7%99%BC%E5%8B%95%E6%B8%AF%E4%BA%BA%E5%85%A8%E5%9F%8E%E6%8D%90%E9%9E%8B\">鞋子</a>舊鞋！誰家沒有？非洲千萬赤腳兒童每日面對沙蚤咬腳的奪命威脅，有大學生發起全城捐舊鞋運動，各區市民可集合舊鞋一併送交大學收集站，再由協辦物流公司轉送非洲。");


        tagStr.put("bag","<a href=\"http://baike.baidu.com/view/1749752.htm\">袋子</a>随着塑料制品消费量不断增大，废弃塑料也不断增多。目前我国废弃塑料主要为塑料薄膜、塑料丝及编织品、泡沫塑料、塑料包装箱及容器、日用塑料制品、塑料袋和农用地膜等。");
        tagStr.put("plastic","<a href=\"http://baike.baidu.com/view/1749752.htm\">塑料</a>我国汽车用塑料年消费量已达40万吨，电子电器及家电配套用塑料年消费量已达100多万吨，这些产品报废后成了废塑料的重要来源之一。据了解，2011年，我国废塑料产生量约为2800万吨，2012年为3413万吨。");

        tagStr.put("clothes","<a href=\"http://baike.baidu.com/view/1749752.htm\">衣物</a>綠色和平指出香港人每年棄置11萬噸紡織物，相等於每分鐘拋棄約1400件T-shirt，足以鋪滿25000個香港大球場。");
        tagStr.put("clothing","<a href=\"http://baike.baidu.com/view/1749752.htm\">衣物</a>綠色和平指出香港人每年棄置11萬噸紡織物，相等於每分鐘拋棄約1400件T-shirt，足以鋪滿25000個香港大球場");

        tagStr.put("window","<a href=\"http://www.epd.gov.hk/epd/sc_chi/environmentinhk/waste/eco_responsibility/gcrp_pilot_ssp_ha.html\">窗玻璃</a>玻璃，玲瓏剔透，無毒可重用，壓碎後又可製成環保磚或鋪路，可是它的回收價值比紙皮、膠樽還要低");
        tagStr.put("key","<a href=\"http://baike.baidu.com/view/2013629.htm\">金属</a>金属回收是指从废旧金属中分离出来的有用物质经过物理或机械加工成为再生利用的制品，是从回收、拆解、到再生利用的一条产业链。");



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
}
