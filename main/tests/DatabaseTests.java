package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.DatabaseHandler;

class DatabaseTests {

	@Test
	void test() {
		DatabaseHandler db = new DatabaseHandler();
		assertTrue(db.start());
	}

}
