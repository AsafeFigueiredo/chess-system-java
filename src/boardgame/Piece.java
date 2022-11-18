package boardgame;

public abstract class Piece {
	
	protected Position position; /* essa posição é protected, porque esse tipo de posição não é ainda 
	a posição do xadrez. Ela é uma posicão simples de matriz. Eu não quero que essa posição seja visivel
	na camada de xadrez, então ela é posta como protected.*/
	
	private Board board; /*De acordo com o UML, essa classe Piece, tem uma associação com a classe Board
	e vice-versa.. Pois essa piece conhece o tabuleiro aonde ela está.*/
	
	
	public Piece(Board board) {  /*so foi passado o tabuleiro como parametro na hora de criar a peça no construtor.
	Porque a posição de uma peça recém criada ela vai ser inicialmente como nula, dizendo que essa peça nao foi posta
	no tabuleiro ainda. Para criar um peça eu tenho que informar o board.*/
		this.board = board;
		position = null; //essa declaracao foi didática, pois por padrao o Java ja joga o null.
	}


	protected Board getBoard() {
		return board;
	}

	/*o set foi apagado pois nao é permissivel que o tabuleiro seja alterado. Só tera apenas o get, mas ele
	será protected. Apenas classes do mesmo pacote e subclasses é que podem acessar o tabuleiro de uma peça.
	Não quero que o tabuleiro seja acessivel pela camada outra camada de Xadrez. Esse Board é de uso interno 
	da camada boardgame. No caso aqui, um tabuleiro associado a uma peça, eu quero se ja acessado somente no 
	pacote boardgame e tambem pelas subclasses de peças. E nocaso serão as ChessPiece e as Pieces do xadrez.
	todas elas podem acessar o tabuleiro, fora elas, não. Essa limitacao é importante para deixar o sistema
	mais protegido e evitar que os programadores cometam erros.*/
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
		/*aqui temos um método concreto, e ele esta utilizando o método abstrato. Hook methods. Hook vem de
		gancho, é um método que faz um gancho com a subclasse. Na verdade esse método pode ser concreto...
		Porque ele ta chamando uma possivel implementacao de alguma subclasse concreta da classe piece.*/
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				if(mat[i][j]) { //ele entende como true sem operaçao?
					return true;
				}
			}
		}
		return false;
	}
}
