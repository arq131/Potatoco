package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.DatabaseHandler;
import model.Product;

class DatabaseTests {

	@Test
	void testDBConnection() {
		System.out.println("ATtempting to test DB Connection");
		DatabaseHandler db = new DatabaseHandler();
		try {
			assertTrue(db.start());
			db.stop();
		} catch (Exception e) {
			Assert.fail("Unable to stop database connection.");
		}
	}
	
	@Test
	void testAddProduct() {
		DatabaseHandler db = new DatabaseHandler();
		db.start();
		Product product = new Product(3);
		product.setCost(9.99);
		product.setName("Potato test");
		product.setDescription("JUnit test for adding in a product.");
		product.setTag("tag1;tag2;tag3");
		product.setImagePath("/image1.png");
		assertTrue(db.addProduct(product));
		try { db.stop(); } catch (Exception e) {}
		
	}

}
