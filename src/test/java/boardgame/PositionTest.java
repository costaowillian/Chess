package boardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

	@DisplayName("When To String The Position Should Return a String")
	@Test
	void testPosition_whenToString_ShouldRetrurnAString() {
		// Given / Arrange
		Position pos = new Position(3,5);
		String expected = "3, 5";
		// When / Act
		String actual = pos.toString();
		// Then / Assert
		assertEquals(expected, actual, () -> "Shoul return a string whit " + expected + " but got " +  actual + "!");
	}

}
