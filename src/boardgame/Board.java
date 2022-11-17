package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces; //matriz de peças linhas e colunas
	
	
	public Board(int rows, int columns) { /*programação defensinva: quando eu for criar um tabuleiro
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
	
	public void placePiece(Piece piece, Position position) {  /*esse piece é a matriz que 
	está declarada no tabuleiro que tambem foi instanciada no construtor. o que está sendo
	feito é, pegar a matriz na posicao dada, e atribuir a ela a peça(piece) informada. E essa 
	peça não está mais na posicao nula, ela esta na posicao do parâmetro.*/
		if(thereIsAPiece(position)) { /*o método de colocar uma peça numa dada posição, antes de colocar essa peça na posição
		eu tenho que testar se ja existe uma peça nessa posição. Se ja existir uma peça nessa posicao, eu nao posso colocar
		colocar outra no mesma posição. E tambem, antes de testar se existe uma peça na posição, eu num tinha que testar se essa
		posição existe? Exato.*/
			throw new BoardException("There is already a piece on position: " + position);
		}		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; /*aqui ela deixa de ser nula. E a posicao da peça é acessivel
		diretamente, pois ela é protected. Como esta no mesmo pacote, pode ser acesada livremente*/
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) { //se a posicao !não existe 
			throw new BoardException("Position not on the board");
		}
		if(piece(position) == null) {   /*se a peça do tabuleiro é == null*/
			return null; //se for verdade, se for verdadde sigifica que n tem peça nessa posicao
		} 
		Piece aux = piece(position); /*var. auxiliar e recebe a peça que tiver no tabuleiro nessa posicao*/
		aux.position = null; /*pega essa peca aux e diz que a posicao dela será null. Ou seja foi removida do
		tabuleiro, nao tem posicao mais. E é representado pelo valor nulo. */
		pieces[position.getRow()][position.getColumn()]  = null;/*é acessado a matriz de peças pieces e diz
		o seguinte: essa matriz de peças na linha: [getRow] e na coluna: [getColumn], vão receber nulo.
		Na minha matriz de peças, na posicão(Position position) do parametro, onde estou removendo a peça, 
		agora será nulo, indicando que nao tem mais peça nessa posicao da matriz */
		return aux;
	}
	
	private boolean positionExists(int row, int column) { /*isso foi feito pois, aqui dentro da
	classe, terá um momento em que vai ser mais fácil testar pela linha e pela coluna do que pela
	posição. Quando que uma posicao numa dada linha/coluna existe? É quando essa posição está
	dentro do tabuleiro, o tabuleiro é (8, 8), então, essa linha tem que ser maior/igual a zero
	, nao pode ser menor que zero e tambem essa linha tem que ser menor do que a altura do tabuleiro
	que é o atributo rows aqui do tabuleiro(board). Da mesma forma, a coluna tem que ser maior/igual
	a zero e tambem tem que ser menor do que a quantidade de colunas do meu tabuleiro, que é o columns.*/
		return row >= 0 && row < rows && column >= 0 && column < columns;		
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}	
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {/*antes de testar o thereIsAPiece, ele ja testa se a posição existe, 
		se nao existir ele ja para e lança uma exceção*/
				throw new BoardException("Position not on the board");
			}		
		return piece(position) != null; /*esse piece(position) é o método acima
		na linha 35. Ele vai me retornar a peça que estiver na matriz, naquela
		posição. Se essa peça for diferente de nulo, significa que há uma peça
		nessa posição*/
	}
	
}
