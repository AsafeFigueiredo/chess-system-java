package boardgame;

public class BoardException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BoardException(String msg) {
		super(msg);
	}
	
	/* esse construtor via repassar a mensagem para o construtos da super classe
	no caso a RuntimeException. */
	

}
