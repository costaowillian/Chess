package chess;

import boardgame.Board;
import boardgame.BoardException;
import boardgame.Piece;
import boardgame.Position;
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
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		this.validateSourcePostion(source);
		this.validadeTargetPosition(source, target);
		Piece capturedPiece = this.makeMove(source, target);
		return (ChessPiece) capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece piece = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(piece, target);
		return capturedPiece;
	}
	
	private void validateSourcePostion(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("Theres is no piece on source position");
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece!");
		}
	}
	
	private void validadeTargetPosition(Position source, Position target) {
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position!");
		}
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) { 
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup () {
		this.placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		this.placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		this.placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		this.placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		this.placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		this.placeNewPiece('d', 1, new King(board, Color.WHITE));

		this.placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		this.placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		this.placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		this.placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		this.placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		this.placeNewPiece('d', 8, new King(board, Color.BLACK));
	}

}
