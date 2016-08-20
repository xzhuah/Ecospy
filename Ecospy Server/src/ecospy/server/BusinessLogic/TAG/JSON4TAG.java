package ecospy.server.BusinessLogic.TAG;

import ecospy.server.Data.ItemData;
import ecospy.server.PO.ItemInfoPO;
import ecospy.server.Utility.IntStringWrapper;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

public class JSON4TAG {
    private static final String[] laptopKeyWord = {"laptop", "computer"};
    private static final String[] bottleKeyWord = {"drink", "beverage", "bottle", "can","cup","coffee"};
    private static final String[] electronicsKeyWord = {"electronics", "mouse", "keyboard"};

    private ItemData data;
    public JSON4TAG() {
        data = new ItemData();
    }

    public String getTAGResult(String src) {
        System.out.println("tag return is " + src);
        JSONObject jo = JSONObject.fromObject(src);
        JSONArray ja = jo.getJSONArray("tags");
        RecognizableObject recognizableObject = null;
        ArrayList<String> tags = new ArrayList<>();
        for (int i = 0; i < ja.size(); i++) {
            String tag = ja.getJSONObject(i).getString("name");
            tags.add(tag);
        }

        if (isLaptop(tags))
            recognizableObject = RecognizableObject.LAPTOP;
        else if (isElectronics(tags))
            recognizableObject = RecognizableObject.ELECTRONICS;
        else
//        if (isBottle(tags))
            recognizableObject = RecognizableObject.BOTTLE;
//        else recognizableObject = RecognizableObject.NOT;

        return JSONObject.fromObject(data.findItemInfo(recognizableObject.toString())).toString();
    }

    private boolean isLaptop(Collection<String> tags) {
        for (String tag : tags) {
            if (this.isIn(tag, JSON4TAG.laptopKeyWord))
                return true;
        }
        return false;
    }

    private boolean isBottle(Collection<String> tags) {
        for (String tag : tags) {
            if (this.isIn(tag, JSON4TAG.bottleKeyWord))
                return true;
        }
        return false;
    }

    private boolean isElectronics(Collection<String> tags) {
        for (String tag : tags) {
            if (this.isIn(tag, JSON4TAG.electronicsKeyWord))
                return true;

        }
        return false;
    }

    private boolean isIn(String tag, String[] bag) {
        for (String s : bag) {
            if (s.equals(tag))
                return true;
        }
        return false;
    }
}

enum RecognizableObject{
    LAPTOP, CAN, BOTTLE, ELECTRONICS, NOT
}

class ResultVO {
    private String obj;
    private String description;

    public ResultVO(String obj, String description) {
        this.obj = obj;
        this.description = description;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
