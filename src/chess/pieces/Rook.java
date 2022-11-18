package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R"; //essa letra vai entrar na hora de imprimir o tabuleiro, nos tra�os, R de Rook
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];  //sao todos nulos
		
		Position p = new Position(0, 0); /*uma posicao auxiliar p. S� para ter um valor inicial.
		Vamos supor que eu queira verificar acima da minha pe�a...O que deve ser feito? � a posicao
		na mesma coluna, porem a linha dessa  posicao eu tenho que ir decrementando.*/
		
		//ABOVE 
		//ser� feito, a posicao aux. p. recebendo a posicao da minha peca s� que a linha - 1
		p.setValues(position.getRow() - 1, position.getColumn());  /*qm �  esse position? ;e a posicao
		da pe�a. Que � o atributo da classe Piece, o position. Estou acessando a posicao da pr�pria
		pe�a. Entoa aqui na classe rook, ness m�todo, eu pego a posicao da propria pe�a s� que - 1 na
		linha dela, pois estou analisando acima da pe�a. Ent�ao � sempre a posicao da linha - 1*/
		
		
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { /*O que esta sendo testaddo
		aqui... Enquanto a posicao p existir, E !n�o tiver uma pe�a lam, ou seja enquanto a posica estiver
		vaga, eu vou marcar como verdadeira. */
			mat[p.getRow()][p.getColumn()] = true; /*entao, na matriz mat, [linha][coluna] recebe o valor 
			true. Em seguida � feita a linha dessa posicao andar mais uma pra cima. Ou seja, -1 ainda.*/
			p.setRow(p.getRow() - 1); /*isso � repetido enquanto existirem casas vazias. Qndo essa repeticao
			terminar ainda � testado se axiste uma casa e se essa casa possui uma pe�a adversaria. Se sim,
			ainda vou marcar mais essa casa de verdadeira. */
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { /*chamou o if pra testar se eu tenho
			que marcar mais essa pe�a adversaria.*/
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//LEFT  - ESQUERDA	
		p.setValues(position.getRow(), position.getColumn() - 1); /*agr no caso eu vou analisar a mesma
		linha, entao � tirado o (-1) da linha e posto na coluna. */						
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true; 
		/*da mesma coisa, toda vez que passar pelo o while... */
			p.setColumn(p.getColumn() - 1); //...agora � a coluna que vai andar
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { 
			mat[p.getRow()][p.getColumn()] = true; /*e aqui da mesma forma � testado se tem alguma
																pe�a adversaria no final.*/
		}
		
		//RIGHT - DIREITA
		p.setValues(position.getRow(), position.getColumn() - 1); /*agr vai ser a mesma linha, por�m
		a coluna � + 1. */ 		 			
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true; 
			p.setColumn(p.getColumn() + 1); //Aqui tambem coluna + 1
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { 
			mat[p.getRow()][p.getColumn()] = true; 
		}
		
		//BELOW - essa l�gica � parecida com a pra baixo (above)
		p.setValues(position.getRow() + 1, position.getColumn()); /*aqui no caso, a linha � + 1. E n�o
		-1.*/
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true; 
			p.setRow(p.getRow() + 1); //Aqui tambem linha + 1
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { 
			mat[p.getRow()][p.getColumn()] = true; 
		}
		
		return mat;
	}

	
}
