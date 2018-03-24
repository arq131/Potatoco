package Products;

import java.util.ArrayList;

import model.Product;

public class Cart {
	// cart requires:
		// total product number
		// total product cost
		// name of each product
		// cost of each product
		// ability to remove a product from cart
		// user id for cart identification?
	
	private int userId; // USER IDENTIFICATION?
	private double totalCost;
	private int itemAmt;
	public ArrayList<Product> cartProduct = new ArrayList<Product>();
	public int i;
	
	// using user id V
	public Cart(int userId) {
		super();
		this.userId = userId;
		
		itemAmt = cartProduct.size();
		
		if (itemAmt == 0)
		{	
			totalCost = 0.0;
		}
		else
		{
			for (i = 0; i <= itemAmt; i++)
				totalCost += cartProduct.get(i).getCost();
		}
		// ^^^^^^^^^^ what about item quantity? 
		
		
	}
	
	// adds product to cart; needs update after addition.
	public void addToCart(Product product) {
		cartProduct.add(product);
	}
	
	// removes product from cart; needs update after removal.
	public void removeFromCart(Product product) {
		cartProduct.remove(product);	
	}
	
	// reset the cart to empty once purchase is made.
	public void resetCart(Product product) {
		cartProduct.clear();
	}
	
	// return list of products? needs to be an array?
	//public Product getProducts() {
		
	//}
	
	public double getCost() {
		return totalCost;
	}
	
	public int getAmt() {
		return cartProduct.size();
	}
	
}
