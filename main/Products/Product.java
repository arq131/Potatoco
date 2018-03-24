package Products;

public class Product {
    private int id;
    private String name;
    private String pic;
    private Descriptions desc = new Descriptions();
    private String description;

    public Product(int id){
        super();
        this.id = id;
        this.name = desc.getName(id);
        this.pic = desc.getPic(id);
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
