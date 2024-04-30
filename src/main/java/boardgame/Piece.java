package boardgame;

public abstract class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		this.position = null;
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	//Hook method
	public boolean possibleMove(Position position) {
		return this.possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	//Hook method
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = this.possibleMoves();
		for (int i = 0; i<mat.length; i++) {
			for (int j = 0; j < mat.length; j++ ) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
