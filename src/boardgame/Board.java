package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces; //matriz de peças
	
	
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
	
	public void placePiece(Piece piece, Position position) {  /*esse piece é a matriz que 
	está declarada no tabuleiro que tambem foi instanciada no construtor. o que está sendo
	feito é, pegar a matriz na posicao dada, e atribuir a ela a peça(piece) informada. E essa 
	peça não está mais na posicao nula, ela esta na posicao do parâmetro. Então...  */
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; /*aqui ela deixa de ser nula. E a posicao da peça é acessivel
		diretamente, pois ela é protected. Como esta no mesmo pacote, pode ser acesada livremente*/
	}
	
	
}
