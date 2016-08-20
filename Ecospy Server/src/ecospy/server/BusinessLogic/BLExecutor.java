package ecospy.server.BusinessLogic;

import ecospy.server.Utility.IntStringWrapper;
import ecospy.server.Utility.RequestType;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

public class BLExecutor{

    MainExecutor main;
    UserExecutor user;
    ItemListExecutor item;
    public BLExecutor(){
        this.main = new MainExecutor();
        this.user = new UserExecutor();
        this.item = new ItemListExecutor();
    }
    public IntStringWrapper execute(RequestType type, HttpServletRequest request) throws IOException{

        InputStream is = request.getInputStream();
        IntStringWrapper result = null;
        switch(type){
            case ResolveImage:
                result = main.resolveImage(request.getInputStream());break;
            case GetItemList:
                result = item.getItemList(request.getInputStream());break;
            case UpdateItemList:
                result = item.updateItemList(request.getInputStream());break;
            case SignUp:
                result = user.SignUp(request.getInputStream());break;
            case SignIn:
                result = user.SignIn(request.getInputStream());break;
        }
        return result;
    }
}
