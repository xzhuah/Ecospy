package ecospy.server.PO;

/**
 * Created by nians on 2016/8/16.
 */
public class ItemInfoPO {
    private String name;
    private String description;

    public ItemInfoPO(){}

    public ItemInfoPO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
