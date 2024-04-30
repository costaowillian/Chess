package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;

	public ChessMatch() {
		this.board = new Board(8, 8);
		this.initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++ ) {
				mat[i][j] = (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
	
	private void placeNewPeace(char column, int row, ChessPiece piece) { 
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup () {
		this.placeNewPeace('b', 6, new Rook(this.board, Color.WHITE));
		this.placeNewPeace('e', 8, new King(this.board, Color.BLACK));
		this.placeNewPeace('e', 1, new King(this.board, Color.WHITE));
	}

}
