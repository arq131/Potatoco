package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

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

		public String get(String key) {
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
			String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + username + "&password="
					+ password;
			this.con = DriverManager.getConnection(jdbcUrl);
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

}
