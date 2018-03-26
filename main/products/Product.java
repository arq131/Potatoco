package products;

public class Product {
    private int id;
    private String name;
    private String pic;
    private Descriptions desc = new Descriptions();
    private String description;
    private double cost;

    public Product(int id){
        super();
        this.id = id;
        this.name = desc.getName(id);
        this.pic = desc.getPic(id);
        this.description = desc.getDescription(id);
        this.cost = desc.getCost(id);
        desc = null;
    }
    public String getName() {
    	return name;
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

	public double getCost() {
		// TODO Auto-generated method stub
		return cost;
	}
}
