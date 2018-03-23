package Products;

import Products.Pic_paths;
import Products.Descriptions;

public class Product {
    private int id;
    private Pic_paths path = new Pic_paths();
    private String pic;
    private Descriptions desc = new Descriptions();
    private String description;

    public Product(int id){
        super();
        this.id = id;
        this.pic = path.getPicPath(id);
        path = null;
        this.description = desc.getDescription(id);
        desc = null;
    }

    public int getId() {
        return id;
    }

    public String getPic() {
        return pic;
    }

    public String getDescription() {
        return description;
    }
}
