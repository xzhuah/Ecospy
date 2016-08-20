package ecospy.server.BusinessLogic;

import ecospy.server.Data.ItemData;
import ecospy.server.PO.ItemListPO;
import ecospy.server.Utility.IntStringWrapper;
import ecospy.server.Utility.UtilityTools;
import net.sf.json.JSONObject;

import javax.servlet.ServletInputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by nians on 2016/8/15.
 */
public class ItemListExecutor {
    private ItemData data;
    public ItemListExecutor() {
        this.data = new ItemData();
    }

    public IntStringWrapper getItemList(ServletInputStream inputStream) {
        String source = UtilityTools.Stream2String(inputStream);
        String userID = this.getUserID(source);
        JSONObject result = new JSONObject();
        ArrayList<String> list = new ArrayList<String>();
        Iterator<ItemListPO> it = data.getItemList(userID);
        while(it.hasNext()){
            String tmp = JSONObject.fromObject(it.next()).toString();
            System.out.println(tmp);
            list.add(tmp);
        }
        result.accumulate("item", list);
        return new IntStringWrapper(HttpURLConnection.HTTP_OK,result.toString());
    }

    public IntStringWrapper updateItemList(ServletInputStream inputStream) {
        String source = UtilityTools.Stream2String(inputStream);
        JSONObject jo = JSONObject.fromObject(source);
        ItemListPO itemList = (ItemListPO) JSONObject.toBean(jo, ItemListPO.class);
        data.updateItemList(itemList);
        return new IntStringWrapper(HttpURLConnection.HTTP_OK,"Success");
    }

    private String getUserID(String source){
        String userID = JSONObject.fromObject(source).getString("userID");
        return userID;
    }
}
