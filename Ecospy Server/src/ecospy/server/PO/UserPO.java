package ecospy.server.PO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UserPO {
	private int userID;
	private String userName;
	private String password;
    private int level;

	public UserPO(){}
	public UserPO(String userName, String password) {
		this.userName = userName;
		this.password = password;
        this.level = 0;
	}

	public String getID() {
		return this.toStringID();
	}
	public void setID(String iD) {
		userID = Integer.parseInt(iD);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private String toStringID(){
		String tmp = this.userID+"";
		while(tmp.length()!=6){
			tmp = "0"+tmp;
		}
		return tmp;
	}
	@Override
	public boolean equals(Object o){
		UserPO source = (UserPO) o;
		if(source.getID().equals(this.getID()))
			return true;
		return false;
	}


}
