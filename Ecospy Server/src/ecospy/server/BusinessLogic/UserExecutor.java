package ecospy.server.BusinessLogic;

import ecospy.server.Data.ItemData;
import ecospy.server.PO.ItemListPO;
import ecospy.server.PO.UserPO;
import ecospy.server.Utility.IntStringWrapper;
import ecospy.server.Utility.ResponseCodeInterpreter;
import ecospy.server.Utility.UtilityTools;
import net.sf.json.JSONObject;
import ecospy.server.Data.UserData;

import java.io.InputStream;
import java.net.HttpURLConnection;

public class UserExecutor {
	private UserData data;
    private ItemData itemData;
	UserExecutor(){
		this.data = new UserData();
        this.itemData = new ItemData();
    }
	public IntStringWrapper SignIn(InputStream is){
		String source = UtilityTools.Stream2String(is);
		String userName = this.getAttribute(source, "userName");
		UserPO user = data.findUserByName(userName);
		if(user==null){
			return this.getBadResponse();
		}
		if(user.getPassword().equals(this.getAttribute(source, "password")))
			return new IntStringWrapper(HttpURLConnection.HTTP_OK,this.getResponseJSON(user));
		else
			return new IntStringWrapper(HttpURLConnection.HTTP_FORBIDDEN, "your password is wrong");
	}
	public IntStringWrapper SignUp(InputStream is){
		String source = UtilityTools.Stream2String(is);
		String userName = this.getAttribute(source, "userName");
		String password = this.getAttribute(source, "password");
		UserPO user = new UserPO(userName,password);
		data.addUser(user);
		UserPO tmp = data.findUserByName(userName);
        itemData.saveItemList(ItemListPO.createEmptyItemList(tmp.getID()));
        String repString = "{\"userID\":\""+tmp.getID()+"\"}";
		return new IntStringWrapper(HttpURLConnection.HTTP_OK,repString);
	}
	
	private IntStringWrapper getBadResponse(){
		return new IntStringWrapper(HttpURLConnection.HTTP_NOT_FOUND,ResponseCodeInterpreter.getExplain(HttpURLConnection.HTTP_NOT_FOUND));
	}
	private UserPO getUser(String source){
		String userID = this.getAttribute(source, "userID");
		UserPO user = data.findUserByID(userID);
		return user;
	}
	private String getAttribute(String source, String attribute){
		String userID = JSONObject.fromObject(source).getString(attribute);
		return userID;
	}
	private String getResponseJSON(UserPO user){
		JSONObject tmp = new JSONObject();
		tmp.accumulate("userID", user.getID());
		return tmp.toString();
	}
	public static void main(String[] args){
		String source = "{\"userName\":\"wrr\",\"password\":\"132\"}";
		System.out.println(source);
		JSONObject jo = JSONObject.fromObject(source);
		
	}
}
