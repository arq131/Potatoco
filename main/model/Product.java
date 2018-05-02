package model;

public class Product {
	
	private int id;
	private String name;
	private double cost;
	private String description;
	private String imagePath;
	private String tag;
	
	public Product(int id, String name, double cost, String description, String imagePath, String tag){
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = description;
		this.imagePath = imagePath;
		this.tag = tag;
	}
	
	public Product(int id){
		this.id = id;
		name = "";
		cost = 0.0;
		description = "";
		imagePath = "";
		tag = "";
	}
	
	public int getId(){
		return id;
	}
	
	public double getCost(){
		return cost;
	}
	
	public void setCost(double cost){
		this.cost = cost;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getImagePath(){
		return imagePath;
	}
	
	public void setImagePath(String imagePath){
		this.imagePath = imagePath;
	}
	
	public String getTag(){
		return tag;
	}
	
	public void setTag(String tag){
		this.tag = tag;
	}
	
	public String display() {
		return this.description + "\n\n\n" + String.format("$%.2f",  this.cost);
	}
	
}
