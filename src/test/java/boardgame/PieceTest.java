package boardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PieceTest {

	@DisplayName("When Create APeace Should Return A Null Position and A Board")
	@Test
	void testPeice_whenCreateAPeace_ShouldReturnANullPositionAndABoard() {
		// Given / Arrange
		Board board = new Board(8,8);
		
		// When / Act
		Piece piece = new Piece(board);
		
		// Then / Assert
		assertEquals(piece.getBoard(), board, () -> "Should return the Board");
		assertNull(piece.position, () -> "Position should be null");
	}

}
