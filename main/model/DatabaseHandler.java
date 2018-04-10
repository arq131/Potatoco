package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;

public class DatabaseHandler {
	private Connection con;
	private DBInfo dbInfo;

	private class DBInfo {
		private HashMap<String, String> hash = new HashMap<String, String>();

		public DBInfo(File file) {
			read(file);
		}

		private void read(File file) {
			try {
				String input;
				BufferedReader br = new BufferedReader(new FileReader(file));
				while ((input = br.readLine()) != null) {
					String[] inputs = input.split(":");
					hash.put(inputs[0], inputs[1]);
				}
				br.close();
			} catch (Exception e) {
				System.out.println("Unable to read file. Exception: " + e.getMessage());
			}
		}

		protected String get(String key) {
			return hash.get(key);
		}
	}

	public DatabaseHandler() {
		dbInfo = new DBInfo(new File("credentials.txt"));
	}

	public boolean start() {
		System.out.println("Attempting to start up connection...");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dbName = dbInfo.get("dbName");
			String username = dbInfo.get("username");
			String password = dbInfo.get("password");
			String hostname = dbInfo.get("hostname");
			String port = dbInfo.get("port");
			String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;
			this.con = DriverManager.getConnection(jdbcUrl, username, password);
			if (con != null) {
				System.out.println("Connection successful!");
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error with connection. Exception found: " + e.getMessage());
			return false;
		}
		return false;
	}
	
	/**
	 * Stop the current connection to the database
	 */
	public void stop() throws SQLException {
		if (this.con != null)
			con.close();
	}
	
	/**
	 * Query the database to get a list of all the products
	 * @return
	 */
	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		Statement stmt = null;
		String query = "SELECT * FROM potatoco.products";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Product product = new Product(rs.getInt("id"));
				product.setCost(rs.getDouble("cost"));
				product.setDescription(rs.getString("description"));
				product.setImagePath(rs.getString("path"));
				product.setTag(rs.getString("tag"));
				product.setName(rs.getString("name"));
				products.add(product);
			}
			stmt.close();
		} catch (Exception e) {
			
		}
		
		return products;
	}
	
	/**
	 * This will add a product into the database
	 * @param product
	 */
	public boolean addProduct(Product product) {
		try {
			Statement stmt = con.createStatement();
			String query = "INSERT INTO products (name, cost, description, path, tags) VALUES ('"
					+ product.getName() + "', " + product.getCost() + ", '"
					+ product.getDescription() + "', '" + product.getImagePath() + "', '"
					+ product.getTag() + "')";
			stmt.executeQuery(query);
			System.out.println("Successfully inserted product into database");
			stmt.close();
			return true;
		} catch (Exception e) {
			Assert.fail("Unable to insert product into database. Error: " + e.getMessage());
		}
		return false;
		
	}

}
