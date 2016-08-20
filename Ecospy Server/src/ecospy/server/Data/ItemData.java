package ecospy.server.Data;

import ecospy.server.PO.ItemInfoPO;
import ecospy.server.PO.ItemListPO;
import ecospy.server.PO.UserPO;
import ecospy.server.Utility.IntStringWrapper;
import ecospy.server.Utility.ResultMessage;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;

public class ItemData {
    Session session;
    public ItemData(){
        this.session = MySessionFactory.getSessionFactory().openSession();
    }

    public ResultMessage saveItemList(ItemListPO itemListPO) {
        session.beginTransaction();
        session.save(itemListPO);
        session.getTransaction().commit();
        return new ResultMessage(true,"success");


    }

    public Iterator<ItemListPO> getItemList(String userID){
        session.beginTransaction();
        Criteria cri = session.createCriteria(ItemListPO.class);
        cri.add(Restrictions.eq("userID", userID));
        return (Iterator<ItemListPO>)cri.list().iterator();
    }

    public ResultMessage updateItemList(ItemListPO itemListPO){
        session.beginTransaction();
        session.update(itemListPO);
        session.getTransaction().commit();
        return new ResultMessage(true,"success");
    }

    public ItemInfoPO findItemInfo(String name) {
        session.beginTransaction();
        Criteria cri = session.createCriteria(ItemInfoPO.class);
        cri.add(Restrictions.eq("name", name));
        if(cri.list().isEmpty())
            return null;
        else
            return (ItemInfoPO) cri.list().get(0);
    }

    public UserPO findUserByID(String userID){
        session.beginTransaction();
        Criteria cri = session.createCriteria(UserPO.class);
        cri.add(Restrictions.eq("userID", Integer.parseInt(userID)));
        if(cri.list().isEmpty())
            return null;
        else
            return (UserPO) cri.list().get(0);
    }
}
