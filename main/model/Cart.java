package model;

import java.util.ArrayList;


public class Cart {

	private double totalCost; 	// Total cost of all products in cart
	private int itemAmt; 		// Total number of items in cart
	public ArrayList<Product> cartProduct = new ArrayList<Product>(); // list of all products user has

	// using user id V
	public Cart() {
		this.totalCost = 0.0;
		this.itemAmt = 0;
	}

	// adds product to cart; needs update after addition.
	public void addToCart(Product product) {
		cartProduct.add(product);
		this.totalCost += product.getCost();
		this.itemAmt++;
	}

	// removes product from cart; needs update after removal.
	public void removeFromCart(Product product) {
		cartProduct.remove(product);
		if (totalCost - product.getCost() < 0)
			this.totalCost = 0;
		else
			this.totalCost -= product.getCost();
		this.itemAmt--;
	}

	// reset the cart to empty once purchase is made.
	public void resetCart() {
		cartProduct.clear();
		this.totalCost = 0.0;
		this.itemAmt = 0;
	}

	public ArrayList<Product> getProducts() {
		return this.cartProduct;
	}

	public double getCost() {
		return this.totalCost;
	}

	public int getAmt() {
		return this.itemAmt;
	}

}
