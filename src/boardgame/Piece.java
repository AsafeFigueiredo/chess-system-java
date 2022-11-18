package boardgame;

public abstract class Piece {
	
	protected Position position; /* essa posi��o � protected, porque esse tipo de posi��o n�o � ainda 
	a posi��o do xadrez. Ela � uma posic�o simples de matriz. Eu n�o quero que essa posi��o seja visivel
	na camada de xadrez, ent�o ela � posta como protected.*/
	
	private Board board; /*De acordo com o UML, essa classe Piece, tem uma associa��o com a classe Board
	e vice-versa.. Pois essa piece conhece o tabuleiro aonde ela est�.*/
	
	
	public Piece(Board board) {  /*so foi passado o tabuleiro como parametro na hora de criar a pe�a no construtor.
	Porque a posi��o de uma pe�a rec�m criada ela vai ser inicialmente como nula, dizendo que essa pe�a nao foi posta
	no tabuleiro ainda. Para criar um pe�a eu tenho que informar o board.*/
		this.board = board;
		position = null; //essa declaracao foi did�tica, pois por padrao o Java ja joga o null.
	}


	protected Board getBoard() {
		return board;
	}

	/*o set foi apagado pois nao � permissivel que o tabuleiro seja alterado. S� tera apenas o get, mas ele
	ser� protected. Apenas classes do mesmo pacote e subclasses � que podem acessar o tabuleiro de uma pe�a.
	N�o quero que o tabuleiro seja acessivel pela camada outra camada de Xadrez. Esse Board � de uso interno 
	da camada boardgame. No caso aqui, um tabuleiro associado a uma pe�a, eu quero se ja acessado somente no 
	pacote boardgame e tambem pelas subclasses de pe�as. E nocaso ser�o as ChessPiece e as Pieces do xadrez.
	todas elas podem acessar o tabuleiro, fora elas, n�o. Essa limitacao � importante para deixar o sistema
	mais protegido e evitar que os programadores cometam erros.*/
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
		/*aqui temos um m�todo concreto, e ele esta utilizando o m�todo abstrato. Hook methods. Hook vem de
		gancho, � um m�todo que faz um gancho com a subclasse. Na verdade esse m�todo pode ser concreto...
		Porque ele ta chamando uma possivel implementacao de alguma subclasse concreta da classe piece.*/
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				if(mat[i][j]) { //ele entende como true sem opera�ao?
					return true;
				}
			}
		}
		return false;
	}
}
