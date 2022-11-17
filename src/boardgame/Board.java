package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces; //matriz de pe�as linhas e colunas
	
	
	public Board(int rows, int columns) { /*programa��o defensinva: quando eu for criar um tabuleiro
	a quantidadde de linhas e colunas tem que ser pelo menos 1. Nao faz sentido eu criar um tabuleiro
	com 0 ou menos colunas. Entao...*/
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; //interessante 
	}
//SET ROWS/COLUMNS foram retirados; programacao defensiva pois eu nao quero que minhas linhas e colunas sejam alteradas
	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}

	
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) { //se essa posicao nao existe...
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) { //se essa posicao nao existe...
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {  /*esse piece � a matriz que 
	est� declarada no tabuleiro que tambem foi instanciada no construtor. o que est� sendo
	feito �, pegar a matriz na posicao dada, e atribuir a ela a pe�a(piece) informada. E essa 
	pe�a n�o est� mais na posicao nula, ela esta na posicao do par�metro.*/
		if(thereIsAPiece(position)) { /*o m�todo de colocar uma pe�a numa dada posi��o, antes de colocar essa pe�a na posi��o
		eu tenho que testar se ja existe uma pe�a nessa posi��o. Se ja existir uma pe�a nessa posicao, eu nao posso colocar
		colocar outra no mesma posi��o. E tambem, antes de testar se existe uma pe�a na posi��o, eu num tinha que testar se essa
		posi��o existe? Exato.*/
			throw new BoardException("There is already a piece on position: " + position);
		}		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; /*aqui ela deixa de ser nula. E a posicao da pe�a � acessivel
		diretamente, pois ela � protected. Como esta no mesmo pacote, pode ser acesada livremente*/
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) { //se a posicao !n�o existe 
			throw new BoardException("Position not on the board");
		}
		if(piece(position) == null) {   /*se a pe�a do tabuleiro � == null*/
			return null; //se for verdade, se for verdadde sigifica que n tem pe�a nessa posicao
		} 
		Piece aux = piece(position); /*var. auxiliar e recebe a pe�a que tiver no tabuleiro nessa posicao*/
		aux.position = null; /*pega essa peca aux e diz que a posicao dela ser� null. Ou seja foi removida do
		tabuleiro, nao tem posicao mais. E � representado pelo valor nulo. */
		pieces[position.getRow()][position.getColumn()]  = null;/*� acessado a matriz de pe�as pieces e diz
		o seguinte: essa matriz de pe�as na linha: [getRow] e na coluna: [getColumn], v�o receber nulo.
		Na minha matriz de pe�as, na posic�o(Position position) do parametro, onde estou removendo a pe�a, 
		agora ser� nulo, indicando que nao tem mais pe�a nessa posicao da matriz */
		return aux;
	}
	
	private boolean positionExists(int row, int column) { /*isso foi feito pois, aqui dentro da
	classe, ter� um momento em que vai ser mais f�cil testar pela linha e pela coluna do que pela
	posi��o. Quando que uma posicao numa dada linha/coluna existe? � quando essa posi��o est�
	dentro do tabuleiro, o tabuleiro � (8, 8), ent�o, essa linha tem que ser maior/igual a zero
	, nao pode ser menor que zero e tambem essa linha tem que ser menor do que a altura do tabuleiro
	que � o atributo rows aqui do tabuleiro(board). Da mesma forma, a coluna tem que ser maior/igual
	a zero e tambem tem que ser menor do que a quantidade de colunas do meu tabuleiro, que � o columns.*/
		return row >= 0 && row < rows && column >= 0 && column < columns;		
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}	
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {/*antes de testar o thereIsAPiece, ele ja testa se a posi��o existe, 
		se nao existir ele ja para e lan�a uma exce��o*/
				throw new BoardException("Position not on the board");
			}		
		return piece(position) != null; /*esse piece(position) � o m�todo acima
		na linha 35. Ele vai me retornar a pe�a que estiver na matriz, naquela
		posi��o. Se essa pe�a for diferente de nulo, significa que h� uma pe�a
		nessa posi��o*/
	}
	
}
