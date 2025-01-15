package test.grader;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rect.Rectangle;


public class TestRectangle {

	Rectangle rect1, rect2;

	@BeforeEach
	void setup() {
		rect1 = new Rectangle(4, 5);
		rect2 = new Rectangle(9, 12);
	}

	/**
	 * Width and height are always more than 1
	 */
	@Test
	void testConstructor1() {
		assertEquals(4, rect1.getWidth());
		assertEquals(5,rect1.getHeight());

		assertEquals(9,rect2.getWidth());
		assertEquals(12,rect2.getHeight());
	}

	/**
	 * Width or height is less than 1
	 */
	@Test
	void testConstructor2() {
		// Width is less than 1
		Rectangle rect = new Rectangle(0, 5);
		assertEquals(1,rect.getWidth());
		assertEquals(5,rect.getHeight());

		// Height is less than 1
		rect = new Rectangle(10, -2);
		assertEquals(10,rect.getWidth());
		assertEquals(1,rect.getHeight());

		// Both width and height are less than 1
		rect = new Rectangle(-7, -3);
		assertEquals(1,rect.getWidth());
		assertEquals(1,rect.getHeight());
	}

	@Test
	void testGetArea() {
		assertEquals(20,rect1.getArea());
		assertEquals(108, rect2.getArea());
	}

}
