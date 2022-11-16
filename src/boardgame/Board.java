package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces; //matriz de pe�as
	
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; //interessante 
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getColumns() {
		return columns;
	}


	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {  /*esse piece � a matriz que 
	est� declarada no tabuleiro que tambem foi instanciada no construtor. o que est� sendo
	feito �, pegar a matriz na posicao dada, e atribuir a ela a pe�a(piece) informada. E essa 
	pe�a n�o est� mais na posicao nula, ela esta na posicao do par�metro. Ent�o...  */
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; /*aqui ela deixa de ser nula. E a posicao da pe�a � acessivel
		diretamente, pois ela � protected. Como esta no mesmo pacote, pode ser acesada livremente*/
	}
	
	
}
