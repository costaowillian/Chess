package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position position = new Position(0, 0);
		
		if(this.getColor() == Color.WHITE) {
			position.setValues(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
				mat[position.getRow()][position.getColumn()] = true;
			}
			
			position.setValues(position.getRow() - 2, position.getColumn());
			Position position2 = new Position(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && getBoard().positionExists(position2) && !getBoard().thereIsAPiece(position2) && this.getMoveCount() == 0) {
				mat[position.getRow()][position.getColumn()] = true;
			}
			
			position.setValues(position.getRow() - 1, position.getColumn() - 1);
			if(getBoard().positionExists(position) && isThereOpponentPiece(position)) {
				mat[position.getRow()][position.getColumn()] = true;
			}
			
			position.setValues(position.getRow() - 1, position.getColumn() + 1);
			if(getBoard().positionExists(position) && isThereOpponentPiece(position)) {
				mat[position.getRow()][position.getColumn()] = true;
			}
		} 
		else {
			position.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
				mat[position.getRow()][position.getColumn()] = true;
			}
			
			position.setValues(position.getRow() + 2, position.getColumn());
			Position position2 = new Position(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && getBoard().positionExists(position2) && !getBoard().thereIsAPiece(position2) && this.getMoveCount() == 0) {
				mat[position.getRow()][position.getColumn()] = true;
			}
			
			position.setValues(position.getRow() + 1, position.getColumn() - 1);
			if(getBoard().positionExists(position) && isThereOpponentPiece(position)) {
				mat[position.getRow()][position.getColumn()] = true;
			}
			
			position.setValues(position.getRow() + 1, position.getColumn() + 1);
			if(getBoard().positionExists(position) && isThereOpponentPiece(position)) {
				mat[position.getRow()][position.getColumn()] = true;
			}
		}
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
