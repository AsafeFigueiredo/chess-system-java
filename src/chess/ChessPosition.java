package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column; //outro sistema dde coordenadas char - int
	private int row;
	
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) { /*programação defensiva. Eu nao sabia que podia fazer
		comparação entre Chars*/
			throw new ChessException("Erros instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

									//set apagaod pois eu nao quero que sejam livremente  alteradas
	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	protected Position toPosition() {					//'a' = 97, 'b' = 98, 'c' = 99
		return new Position (8 - row, column  - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) { /*implementacao da operacao
	inversa. Dada uma posicao na matriz, eu tenho que converter para uma posicao de Xadrez. */
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row; /* sobre esse "" vazio. É uma macete para ele concatenar automatico
		se voce tirar, o compilador nao vai aceitar. Colocamos ele para forçar o compilador a entender 
		que isso é uma concatenação  de Strings*/
	}
	

	
	
	
	
}
